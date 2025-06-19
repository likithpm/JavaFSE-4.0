public class Forecast {
    public static double futureValueRecursive(double presentValue, double rate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return (1 + rate) * futureValueRecursive(presentValue, rate, years - 1);
    }
    public static double futureValueIterative(double presentValue, double rate, int years) {
        double result = presentValue;
        for (int i = 0; i < years; i++) {
            result *= (1 + rate);
        }
        return result;
    }
    public static void main(String[] args) {
        double presentValue = 10000.0; 
        double annualGrowthRate = 0.08; 
        int years = 5;
        double futureValueRec = futureValueRecursive(presentValue, annualGrowthRate, years);
        System.out.printf("Future Value (Recursive) after %d years: %.2f\n", years, futureValueRec);
        double futureValueItr = futureValueIterative(presentValue, annualGrowthRate, years);
        System.out.printf("Future Value (Iterative) after %d years: %.2f\n", years, futureValueItr);
    }
}
