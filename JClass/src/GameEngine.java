import java.util.Scanner;

public class GameEngine {
    private GameContext context;
    private Scanner scanner = new Scanner(System.in);
    private boolean isFirstTurn = true; // 用於判斷是否為遊戲的第一回合

    public GameEngine(GameContext context) {
        this.context = context;
    }

    public void start() {
        while (context.getPlayer().isAlive()) {
            if (isFirstTurn) {
                // 遊戲一開始顯示房間的完整資訊
                System.out.println(context.getCurrentRoom().getFullDescription());
                isFirstTurn = false; // 設置為非第一回合
            } else {
                // 後續回合顯示玩家的狀態
                context.getPlayer().showStatus();
            }

            System.out.print("> ");
            String input = scanner.nextLine();
            Command command = CommandParser.parse(input);
            if (command != null) {
                command.execute(context.getPlayer(), context);
            } else {
                System.out.println("無效的指令。");
            }
        }
        System.out.println("你已死亡，遊戲結束。");
    }
}
