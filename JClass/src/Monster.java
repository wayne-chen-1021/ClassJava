public class Monster {
    private String name;
    private int hp;
    private int attack;

    public Monster(String name, int hp, int attack) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
    }

    public String getName() { return name; }
    public boolean isAlive() { return hp > 0; }
    public void takeDamage(int damage) {
        hp -= damage;
        if (hp < 0) hp = 0; // 確保 HP 不會低於 0
    }
    public int getAttack() { return attack; }
    public int getHp() { return hp; }

    // 新增方法：增加 HP
    public void heal(int amount) {
        hp += amount;
        System.out.println(name + " 恢復了 " + amount + " 點 HP，現在 HP: " + hp);
    }

    // 新增方法：增加攻擊力
    public void boostAttack(int amount) {
        attack += amount;
        System.out.println(name + " 的攻擊力提升了 " + amount + " 點，現在攻擊力: " + attack);
    }

    // 新增方法：反擊
    public void counterAttack(Player player) {
        if (isAlive()) {
            System.out.println(name + " 反擊了 " + player.getName() + "，造成 " + attack + " 點傷害！");
            player.takeDamage(attack); // 假設 Player 類別有 takeDamage 方法
        } else {
            System.out.println(name + " 已經死亡，無法反擊！");
        }
    }
}