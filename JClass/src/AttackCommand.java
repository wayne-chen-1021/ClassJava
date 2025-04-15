public class AttackCommand implements Command {
    @Override
    public void execute(Player player, GameContext context) {
        Room currentRoom = context.getCurrentRoom(); // 獲取當前房間
        Monster monster = currentRoom.getMonster(); // 獲取房間中的怪物

        if (monster == null || !monster.isAlive()) {
            System.out.println("這裡沒有怪物可以攻擊！");
            return;
        }

        // 玩家攻擊怪物
        int playerAttack = player.getAttack();
        monster.takeDamage(playerAttack);
        System.out.println(player.getName() + " 攻擊了 " + monster.getName() + "，造成了 " + playerAttack + " 點傷害！");

        // 如果怪物死亡
        if (!monster.isAlive()) {
            System.out.println(monster.getName() + " 被擊敗了！");
            currentRoom.removeMonster(); // 移除房間中的怪物
            return;
        }

        // 怪物反擊玩家
        int monsterAttack = monster.getAttack();
        player.takeDamage(monsterAttack);
        System.out.println(monster.getName() + " 反擊了 " + player.getName() + "，造成了 " + monsterAttack + " 點傷害！");
    }
}