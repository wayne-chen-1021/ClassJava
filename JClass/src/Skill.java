public interface Skill {
    String getName(); // 獲取技能名稱
    void use(Player player, Monster monster); // 使用技能
}