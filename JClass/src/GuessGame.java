import java.util.Scanner;
import java.util.Random;

public class GuessGame {
    public static void main(String[] args) {
        Player p1 = new Player("Amy");
        Game game = new Game(p1, 5);
        game.start();
        
    }
}

class Player {
    private String playerName;
    private int guessNum = 0;
    private int guessCount = 0;
    private int level = 0;

    public Player(String name) {
        playerName = name;
    }
    public Player() {
        this("Player");
    }

    public String getName() {
        return playerName;
    }
    public int getGuessCount() {
        return guessCount;
    }
    public int getGuessNum() {
        return guessNum;
    }
    public int getLevel() {
        return level;
    }
    public void addGuessCount() {
        guessCount++;
    }
    public void setGuessNum(int num) {
        guessNum = num;
    }
}

class Game {
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    private Player player; 
    int level;

    public Game(Player player, int level) {
        this.player = player;
        this.level = level;
    }
    public Game(Player player) {
        this(player, 0);
    }

    public void start() {
        
        System.out.println(player.getName() + "， 歡迎來到猜數字遊戲! Level: " + level);
        int targetNum = randomGenerator(level);
        System.out.println("我已經選了一個 1 到 " + 100 + 10 * level + 1 + " 之間的數字，快來猜猜看吧！");
        while (player.getGuessNum() != targetNum) {
            System.out.print("請輸入你的猜測：");
            if (scanner.hasNextInt()) {
                player.setGuessNum(scanner.nextInt());
                
                // 增加猜測次數
                player.addGuessCount();

                // 根據猜測結果提供提示
                if (player.getGuessNum() < targetNum) {
                    System.out.println("猜的數字太小了！");
                } else if (player.getGuessNum() > targetNum) {
                    System.out.println("猜的數字太大了！");
                } else {
                    System.out.println("恭喜你！猜對了！");
                    System.out.println("你總共猜了 " + player.getGuessCount() + " 次！");
                }
            } else {
                System.out.println("請輸入有效的數字！");
                scanner.next();  // 清空錯誤輸入
            } 
        }
    }

    public int randomGenerator(int level) {
        int rangeNum = 100 + 10 * level + 1;
        return random.nextInt(rangeNum);
    }
}
