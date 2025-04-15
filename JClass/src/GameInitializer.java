public class GameInitializer {
    public static GameContext init() {
        Room forest = new Room("森林入口", "你站在茂密森林的邊緣", new Monster("哥布林", 30, 8), true);
        Room temple = new Room("神殿大廳", "光線從破碎的石窗灑落", new Monster("亡靈戰士", 50, 12), false);
        forest.setExit("north", temple);
        temple.setExit("south", forest);
        Player player = new Player("勇者", 100, 15);
        return new GameContext(player, forest);
    }
}
