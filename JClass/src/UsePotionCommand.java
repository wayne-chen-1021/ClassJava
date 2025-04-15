public class UsePotionCommand implements Command {
    @Override
    public void execute(Player player, GameContext context) {
        Room currentRoom = context.getCurrentRoom(); // 獲取當前房間

        // 檢查房間內是否有藥水
        if (currentRoom.hasPotion()) {
            int healAmount = 20; // 假設藥水恢復 20 點 HP
            player.heal(currentRoom, healAmount); // 恢復玩家的 HP
            currentRoom.removePotion(); // 移除房間內的藥水
            System.out.println("你使用了一瓶藥水，恢復了 " + healAmount + " 點 HP！");
        } else {
            System.out.println("這個房間內沒有藥水可以使用！");
        }
    }
}