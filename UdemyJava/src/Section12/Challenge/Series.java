package src.Section12.Challenge;

public class Series {

    public static long nSum(int n){
        return (n * (n+1)) / 2;
        /*long sum = 0;
        for (long i = 0; i <= n; i++){
            sum += i;
        }
        return sum;*/
    }

    public static long factorial(int n){
        if (n == 0){
            return 0;
        }
        long factorial = 1;
        for (int i = 1; i <= n; i++){
            factorial *= i;
        }
        return factorial;
    }

    public static int fibonacci(int n){
        if (n <= 1){
            return n;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }

        /*
        if (n <= 1){
            return n;
        }
        long nMinus1 = 1;
        long nMinus2 = 0;
        long fib = 0;
        for (int i = 1; i < n; i++){
            fib = nMinus1 + nMinus2;
            nMinus2 = nMinus1;
            nMinus1 = fib;
        }
        return fib;
         */
    }

}
