public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        print9x9();
    }
    static void print9x9 () {
        int product = 0;
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                product = i*j;
                System.out.print(i + "x" + j + "= " + product + "\t");
                if (product == 24) {
                    continue;
                }
                if (product == 36) {
                    break;
                }
            }
            System.out.println("\n");
            //if (product == 36) break;
        }
    }
}
