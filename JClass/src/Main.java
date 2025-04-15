public class Main {
    public static void main(String[] args) {
        GameContext context = GameInitializer.init();
        GameEngine engine = new GameEngine(context);
        engine.start();
    }
}
