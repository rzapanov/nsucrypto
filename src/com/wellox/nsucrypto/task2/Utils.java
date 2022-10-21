package com.wellox.nsucrypto.task2;

public class Utils {

    public static final int N = 2022;
    public static final int K = 17;
    public static final int deg = 16;

    public static int gcd(int a, int b) {
        while (b != 0) {
            a %= b;
            int x = a;
            a = b;
            b = x;
        }
        return a;
    }

    public static int pow(int a, int n, int mod) {
        int res = 1;
        while (n != 0) {
            if ((n & 1) != 0)
                res = (res * a) % mod;
            a = (a * a) % mod;
            n >>>= 1;
        }
        return res;
    }
}
