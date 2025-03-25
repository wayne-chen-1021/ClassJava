import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.io.*;

public class GuessGame { // 主程式
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        gameManager.creatGame();
    }
}

class Player { // 加入Player類別
    private String playerName;
    private int guessNum = 0;
    private int guessCount = 0;
    private int level = 1;

    public Player(String name) {
        playerName = name;
    }
    public Player() {
        this("Player");
    }

    public String getName() {
        return playerName;
    }
    public int getLevel() {
        return level;
    }
    public int getGuessCount() {
        return guessCount;
    }
    public int getGuessNum() {
        return guessNum;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public void setGuessCount(int count) {
        guessCount = count;
    }
    public void setGuessNum(int num) {
        guessNum = num;
    }
}

class Game { // Game類別實踐
    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);
    private Player player;
    private int level, range, targetNum;

    public Game(Player player, int level) {
        this.player = player;
        this.level = level; // 難易度模式切換
        range = level * 100;
        targetNum = random.nextInt(range) + 1;
    }

    public void startGuess() {
        System.out.println(player.getName() + "， 歡迎來到猜數字遊戲! Level: " + level);
        System.out.println("我已經選了一個 1 到 " + range + " 之間的數字，快來猜猜看吧！");
        int guessCount = 0;
        while (true) {
            System.out.print("請輸入你的猜測：");
            if (scanner.hasNextInt()) {
                int guess = scanner.nextInt();
                player.setGuessNum(guess);
                guessCount++;
                if (guess < targetNum) {
                    System.out.println("猜的數字太小了！");
                } else if (guess > targetNum) {
                    System.out.println("猜的數字太大了！");
                } else {
                    System.out.println("恭喜你！猜對了！");
                    System.out.println("你總共猜了 " + guessCount + " 次！\n");
                    player.setGuessCount(guessCount);
                    break;
                }
            } else {
                System.out.println("請輸入有效的數字！");
                scanner.next();
            }
        }
    }
}

class GameManager {
    private Scanner scanner = new Scanner(System.in);
    private List<Player> playersList = new ArrayList<>();
    private BoardManager boardManager = new BoardManager();
    private int playerNums = 0;

    public void creatGame() {
        System.out.print("有幾位玩家呢？"); // 輸入玩家數
        playerNums = scanner.nextInt();
        scanner.nextLine();

        boardManager.loadScores(); // 遊戲開始時先載入排行榜

        for (int i = 1; i <= playerNums; i++) { // 建立多人玩家
            System.out.print("\n請輸入第 " + i + " 位玩家名稱: ");
            String playerName = scanner.nextLine();
            Player player = new Player(playerName);

            System.out.print("請選擇挑戰層級(level 1 ~ 10): "); // 難易度模式切換
            player.setLevel(scanner.nextInt());
            scanner.nextLine();
            playersList.add(player);
        }
        System.out.println("\n遊戲開始\n");
        for (Player p : playersList) { // 多人對戰模式
            Game game = new Game(p, p.getLevel());
            game.startGuess();
            boardManager.addPlayer(p);
        }

        boardManager.displayScoreBoard();
    }
}

class BoardManager { // 加入排行榜
    private String scoreFile = "scoreboard.txt";
    private List<Player> playerList = new ArrayList<>();

    // 讀取過去排行榜
    public void loadScores() {
        playerList.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(scoreFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(" ");
                if (data.length == 2) {
                    String name = data[0];
                    int score = Integer.parseInt(data[1]);
                    Player p = new Player(name);
                    p.setGuessCount(score);
                    playerList.add(p);
                }
            }
        } catch (IOException e) {
            System.out.println("排行榜載入失敗: " + e.getMessage());
        }
    }

    public void addPlayer(Player p) {
        boolean updated = false;

        for (Player existingPlayer : playerList) {
            if (existingPlayer.getName().equals(p.getName())) {
                if (p.getGuessCount() < existingPlayer.getGuessCount()) { // 只更新更好的成績
                    existingPlayer.setGuessCount(p.getGuessCount());
                }
                updated = true;
                break;
            }
        }

        if (!updated) {
            playerList.add(p);
        }

        playerList.sort(Comparator.comparingInt(Player::getGuessCount)); // 依猜測次數排序
        saveScores();
    }

    private void saveScores() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(scoreFile))) {
            for (Player p : playerList) {
                writer.write(p.getName() + " " + p.getGuessCount());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("無法存取排行榜: " + e.getMessage());
        }
    }

    public void displayScoreBoard() {
        System.out.println("===== 排行榜 =====");
        for (Player p : playerList) {
            System.out.println(p.getName() + " - " + p.getGuessCount() + " 次");
        }
    }
}
