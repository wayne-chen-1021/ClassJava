/*  2025/03/11 第一次作業
    請設計三個 Java 類別：MeanCalculator、RangeMeanCalculator 和 WeightedMeanCalculator，以計算不同類型的平均值。
    與之前的版本不同，本題要求使用 Composition (組合) 而非 繼承 (Inheritance)，並且適當地使用 final 來保護不可變的方法或屬性。

    MeanCalculator 負責計算從 1 到 upper 的平均值。
    RangeMeanCalculator 內部包含 MeanCalculator (使用 Composition)，計算 lower 到 upper 的平均值。
    WeightedMeanCalculator 內部包含 MeanCalculator (使用 Composition)，計算一組數值的 加權平均數。
 */
package com.homework;

class MeanCalculator {
    public final float calNum(int upper){   //使用 final 來保護calNum方法避免被覆寫
        return (float)(1 + upper) * upper / 2 / upper;
    }
}

class RangeMeanCalculator {
    private MeanCalculator meanCal = new MeanCalculator(); // Composition
    public float calNum(int lower, int upper) {
        float result = 0;
        /*  使用Composition：RangeMeanCalculator內部包含MeanCalculator之
            物件meanCal，故使用的是meanCal的calNum方法而非透過繼承而來   */
        float lowerSum = (lower-1) * meanCal.calNum(lower - 1);
        float upperSum = upper * meanCal.calNum(upper);
        result = (float)(upperSum - lowerSum) / (upper - lower +1);
        return result;
    }
}

class WeightedMeanCalculator { // 權重為數字本身
    private MeanCalculator meanCal = new MeanCalculator(); // Composition
    public float calNum(int upper) {
        float sum = 0;
        int n = 0;
        for(int i=1; i <= upper; i++) {
            sum += i*i;
            n += i;
        }
        return (float)sum / n;
    }
    public void showInfo() {
        System.out.println("use meanCal.calNum(10)" + meanCal.calNum(10));
    }
}

class work1TestDriver {
    public static void main(String[] args) {
        MeanCalculator meanCal = new MeanCalculator();
        RangeMeanCalculator rangMeanCal = new RangeMeanCalculator();
        WeightedMeanCalculator weightMeanCal = new WeightedMeanCalculator();

        System.out.println("平均值 1 to 10 : " + meanCal.calNum(10));
        System.out.println("範圍平均值 5 to 10 : " + rangMeanCal.calNum(5, 10));
        System.out.println("權重平均值 1 to 10 : " + weightMeanCal.calNum(10));
    }
}