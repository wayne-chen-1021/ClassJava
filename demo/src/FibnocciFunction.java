public class FibnocciFunction {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        System.out.printf("Fibnocci Series n:10 => %d\n", func_fib(10));
    }
    static int func_fib(int n) {
        if (n <= 1)
            return n;
        return func_fib(n - 1) + func_fib(n - 2);
    }
}
