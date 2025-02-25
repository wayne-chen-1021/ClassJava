public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        print9x9();
        System.out.println("");
    }
    static void print9x9 () {
        int product = 0;
        outloop1: // 為for迴圈增加標籤
        for (int i = 1; i < 10; i++) {
            outloop2:
            for (int j = 1; j < 10; j++) {
                product = i*j;
                if (product == 24) {
                    continue outloop2; // 跳出標籤名為<outloop2>的迴圈
                }
                System.out.printf("%d x %d = %2d\t",i, j, product); //相同用法：System.out.print(i + " x " + j + " = " + product + "\t");
                if (product == 36) {
                    break outloop1;
                }
            }
            System.out.println("");
        }
    }
}
