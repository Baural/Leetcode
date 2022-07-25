package leetcode.week2;

/**
 * @author baur
 * @date on 25.07.2022
 */


public class fibonacciNumber {
    public int fib(int n) {
        int sum = 0;
        if (n == 0){
            return sum;
        } else if(n == 1){
            sum = 1;
            return sum;
        } if(n >1){
            sum = fib(n-1)+fib(n-2);
            return sum;
        }
        return sum;
    }
}
