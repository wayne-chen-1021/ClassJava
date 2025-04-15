public class MoveCommand implements Command {
    private String direction;

    // 建構子，接受移動方向
    public MoveCommand(String direction) {
        this.direction = direction;
    }

    @Override
    public void execute(Player player, GameContext context) {
        Room currentRoom = context.getCurrentRoom(); // 獲取當前房間
        Room nextRoom = currentRoom.getExit(direction); // 根據方向獲取下一個房間

        if (nextRoom != null) {
            context.setCurrentRoom(nextRoom); // 更新當前房間
            System.out.println("你移動到了 " + nextRoom.getName());
            System.out.println(nextRoom.getFullDescription()); // 顯示新房間的描述
        } else {
            System.out.println("這個方向沒有出口！");
        }
    }
}