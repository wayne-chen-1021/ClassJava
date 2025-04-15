public class LookCommand implements Command {
    @Override
    public void execute(Player player, GameContext context) {
        Room currentRoom = context.getCurrentRoom(); // 獲取當前房間

        // 顯示房間描述
        System.out.println("【房間】：" + currentRoom.getName());
        System.out.println("【描述】：" + currentRoom.getDescription());

        // 顯示房間中的怪物資訊
        Monster monster = currentRoom.getMonster();
        if (monster != null && monster.isAlive()) {
            System.out.println("【怪物】：" + monster.getName() + " (HP: " + monster.getHp() + ")");
        } else {
            System.out.println("這裡沒有怪物。");
        }

        // 顯示房間中的物品資訊
        if (currentRoom.hasPotion()) {
            System.out.println("【道具】：治療藥水");
        } else {
            System.out.println("【道具】：無");
        }
    }
}