public class ExceptionPractice {
    
    // 修改 divide 方法，增加錯誤訊息
    static double divide(double d1, double d2) throws Exception {
        if (d2 == 0) {
            throw new Exception("Division by zero is not allowed.");
        } else {
            return d1 / d2;
        }
    }

    public static void main(String[] args) {
        try {
            double r1 = divide(4.0, 2.0);  // 使用 double 類型數字
            double r2 = divide(3.0, 0.0);  // 測試除數為零的情況
        } catch(Exception e) {
            String s = e.getMessage();  // 捕獲異常訊息
            System.out.println("Error: " + s);  // 輸出錯誤訊息
        } finally {
            System.out.println("我一定會被執行");
        }
    }
}
