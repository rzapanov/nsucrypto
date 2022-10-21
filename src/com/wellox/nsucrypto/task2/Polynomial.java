package com.wellox.nsucrypto.task2;

import static com.wellox.nsucrypto.task2.Utils.N;
import static com.wellox.nsucrypto.task2.Utils.K;
import static com.wellox.nsucrypto.task2.Utils.deg;

public class Polynomial {

    private final int[] coeffs = new int[K];

    public Polynomial() {

    }

    public Polynomial(Polynomial another) {
        System.arraycopy(another.coeffs, 0, coeffs, 0, K);
    }

    public void add(Polynomial another) {
        for (int i = 0; i < K; ++i) {
            coeffs[i] = (coeffs[i] + another.coeffs[i]) % N;
        }
    }

    public int substitute(int x) {
        int f = 1;
        int r = 0;
        for (int i = 0; i < K; ++i) {
            r = (r + coeffs[i] * f) % N;
            f = (f * x) % N;
        }
        return r;
    }

    public void set(int i, int v) {
        coeffs[i] = v;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < K - 1; ++i) {
            if (coeffs[i] != 0) {
                builder.append(coeffs[i]);
                builder.append("*x^");
                builder.append(i);
                builder.append(" + ");
            }
        }

        if (coeffs[K - 1] != 0) {
            builder.append(coeffs[K - 1]);
            builder.append("*x^");
            builder.append(K - 1);
        }

        return builder.toString();
    }
}
