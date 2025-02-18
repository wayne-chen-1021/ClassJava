public class Fibnocci {
    static int func_fib(int n) {
        if (n < 2) return n;
        else return func_fib(n-1) + func_fib(n-2);
    }
}
