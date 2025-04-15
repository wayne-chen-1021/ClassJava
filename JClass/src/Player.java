public class Player {
    private String name;
    private int hp;
    private int attack;
    private int killCount = 0;
    private int totalDamage = 0;
    private Skill skill; // 固定技能：Fireball

    public Player(String name, int hp, int attack) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.skill = new FireballSkill(); // 初始化火球術
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void takeDamage(int dmg) {
        hp -= dmg;
        if (hp < 0) hp = 0;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public void addKill() {
        killCount++;
    }

    public void addDamage(int dmg) {
        totalDamage += dmg;
    }

    public int getKillCount() {
        return killCount;
    }

    public int getTotalDamage() {
        return totalDamage;
    }

    public String getName() {
        return name;
    }

    // 普通攻擊
    public void attack(Monster monster) {
        monster.takeDamage(attack);
        addDamage(attack);
        System.out.println(name + " 攻擊了 " + monster.getName() + " 造成 " + attack + " 點傷害！");
    }

    // 使用技能攻擊
    public void useSkill(Monster monster) {
        if (skill != null) {
            int damage = skill.use(monster);
            addDamage(damage);
            System.out.println(name + " 使用技能 " + skill.getName() + " 對 " + monster.getName() + " 造成 " + damage + " 點傷害！");
        } else {
            System.out.println("你沒有技能可以使用！");
        }
    }

    // 使用藥水
    public void heal(Room currentRoom, int heal) {
        if (currentRoom.hasPotion()) {
            hp += heal;
            currentRoom.removePotion(); // 移除房間內的藥水
            System.out.println(name + " 使用了治療藥水，恢復了 " + heal + " 點生命！");
        } else {
            System.out.println("這個房間內沒有藥水可以使用！");
        }
    }

    // 顯示狀態
    public void showStatus() {
        System.out.println("=== 狀態更新 ===");
        System.out.println("你的 HP：" + hp);
        //System.out.println("總傷害：" + totalDamage + "，擊殺數：" + killCount);
    }
}
