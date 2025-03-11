public class Mean {
    public float calNum(int upper) {
        return (float)(1+upper) * upper / 2 / upper;
    }
}

class RangeMean extends Mean {
    public float calNum(int lower, int upper) {
        float result = 0;
        float lowerSum = (lower - 1) * calNum(lower - 1);
        float upperSum = upper * calNum(upper);

        result = (upperSum - lowerSum) / (upper - lower +1);
        return result;
    }
}

class WeightMean extends Mean {
    public float calNum(int upper) {
        float sum = 0;
        int n = 0;
        for(int i=1; i <= upper; i++) {
            sum += i*i;
            n += i;
        }
        return (float)sum / n;
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