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
        /*if (n == 0){
            return 0;
        }
        long factorial = 1;
        for (int i = 1; i <= n; i++){
            factorial *= i;
        }
        return factorial;*/
        if (n <= 1){
            return n;
        }
        return n * factorial(n-1);
    }

    public static long fibonacci(int n){
        if (n <= 1){
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);

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

    public static long lookAndSay(int n){
        if (n <= 1){
            return n;
        }
        long result = 1;
        String newString = "";
        for (int i = 2; i <= n; i++ ){
            char[] chars;
            if (newString.equals("")){
                chars = ("1" + newString).toCharArray();
            } else {
                chars = ("" + newString).toCharArray();
            }

            int counter = 1;
            newString = "";
            for (int x = 0; x < chars.length; x++){
                if (x != (chars.length -1) && chars[x] == chars[x+1]) {
                    counter += 1;
                } else {
                    newString = newString + counter + chars[x];
                    counter = 1;
                }
            }
        }
        result = Long.parseLong(newString);
        return result;
    }

    public static String lookAndSay (String input){
        int counter = 1;
        char[] chars = input.toCharArray();
        String result = "";
        for (int i = 0; i < chars.length; i++) {
            if (i != (chars.length -1) && chars[i] == chars[i+1]){
                counter +=1;
            } else {
                result+= "" + counter + chars[i];
                counter = 1;
            }
        }

        return result;

    }

}
