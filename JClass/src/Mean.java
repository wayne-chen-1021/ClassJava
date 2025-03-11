public class Mean {
    public int calNum(int upper) {
        return (1+upper) * upper / 2 / upper;
    }
}

class RangeMean extends Mean {
    public int calNum(int lower, int upper) {
        int result = 0;
        int lowerSum = lower * calNum(lower - 1);
        int upperSum = upper * calNum(upper);

        result = (lowerSum + upperSum) / (upper - lower +1);
        return result;
    }
}

class WeightMean extends Mean {
    public int calNum(int upper) {
        int sum = 0, n = 0, result = 0;
        for(int i=1; i <= upper; i++) {
            sum += i*i;
        }
        n = (1+upper) * upper / 2;
        result = sum / n;
        return result;

    }
}

class MeanTest {
    public static void main(String[] args) {
        Mean mean = new Mean();
        RangeMean rangMean = new RangeMean();
        WeightMean weightMean = new WeightMean();

        System.out.println("1 to 10 of mean: " + mean.calNum(10));
        System.out.println("10 to 20 of range mean: " + rangMean.calNum(10, 20));
        System.out.println("1 to 10 of weight mean: " + weightMean.calNum(10));
    }
}