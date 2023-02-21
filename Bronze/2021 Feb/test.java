public class test {
    public static void main(String[] args){
        // 1 1 2 3 5 8 13 21 34 

        System.out.println(fib(4));

    }

    // recursion with memoization

    static int fib(int n){
        System.out.println(n);

        if(n <= 1){
            return n;
        }

        return(fib(n-1) + fib(n-2));
    }


    // func declaration returns some sort of date type (usually integer)) (takes some sort of paramter)
        // check if break 

        // do some magic 

        // call itself again
}
