public class SkillCommand implements Command {
    private String skillName;

    // 建構子，接受技能名稱
    public SkillCommand(String skillName) {
        this.skillName = skillName;
    }

    @Override
    public void execute(Player player, GameContext context) {
        Monster monster = context.getCurrentRoom().getMonster(); // 獲取當前房間的怪物
        if (monster == null) {
            System.out.println("這裡沒有怪物可以攻擊！");
            return;
        }

        // 檢查技能名稱是否為 Fireball
        if (!"Fireball".equalsIgnoreCase(skillName)) {
            System.out.println("無效的技能: " + skillName);
            return;
        }

        // 使用 Fireball 技能攻擊怪物
        int damage = 30; // Fireball 技能固定造成 30 點傷害
        System.out.println(player.getName() + " 使用技能 Fireball 對 " + monster.getName() + " 造成 " + damage + " 點傷害！");
        monster.takeDamage(damage);

        // 如果怪物死亡，移除怪物
        if (!monster.isAlive()) {
            System.out.println(monster.getName() + " 被擊敗了！");
            context.getCurrentRoom().removeMonster();
        }
    }
}