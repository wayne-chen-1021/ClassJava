public class FireballSkill implements Skill {
    @Override
    public String getName() {
        return "Fireball";
    }

    @Override
    public void use(Player player, Monster monster) {
        int damage = 30;
        System.out.println(player.getName() + " 使用技能 " + getName() + " 對 " + monster.getName() + " 造成爆擊 " + damage + " 點傷害！");
        monster.takeDamage(damage);
    }
}