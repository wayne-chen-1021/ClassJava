import java.util.HashMap;
import java.util.Map;

public class Room {
    private String name;
    private String description;
    private Monster monster;
    private boolean hasPotion;
    private Map<String, Room> exits = new HashMap<>();

    public Room(String name, String description, Monster monster, boolean hasPotion) {
        this.name = name;
        this.description = description;
        this.monster = monster;
        this.hasPotion = hasPotion;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public Monster getMonster() { return monster; }
    public boolean hasPotion() { return hasPotion; }
    public void removePotion() { hasPotion = false; }
    public void setExit(String direction, Room room) { exits.put(direction, room); }
    public Room getExit(String direction) { return exits.get(direction); }
    public String getExitString() { return String.join(", ", exits.keySet()); }

    // 新增功能
    public boolean hasMonster() { return monster != null; }
    public void removeMonster() { monster = null; }
    public boolean hasExit(String direction) { return exits.containsKey(direction); }

    public String getFullDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append("👾 [ 遊戲開始！歡迎XX勇者！ ]\n");
        sb.append("你目前在: ").append(name).append("\n");
        if (hasMonster()) {
            sb.append("你看到：").append(monster.getName()).append("\n");
        } else {
            sb.append("這裡沒有怪物。\n");
        }
        sb.append("可用方向：").append(getExitString()).append("\n");
        if (hasPotion()) {
            sb.append("有一瓶發光的治療藥水躺在地上。\n");
        }
        return sb.toString();
    }
}