package Algorithm.Dynamic_Programming;

import java.util.Scanner;

public class fibonacci {
    public static int[] fibo_memo;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        fibo_memo = new int[100];   // 대략 크기를 100으로 지정

        System.out.println(fibo(n));
    }

    public static int fibo(int n) {
        if (n <= 1) {
            return n;
        }

        if (fibo_memo[n] != 0) {
            return fibo_memo[n];
        }

        return fibo_memo[n] = fibo(n-1 ) + fibo(n-2);
    }
}
