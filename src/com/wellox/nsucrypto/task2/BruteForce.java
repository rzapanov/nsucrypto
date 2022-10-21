package com.wellox.nsucrypto.task2;

import java.util.ArrayList;
import java.util.Arrays;

import static com.wellox.nsucrypto.task2.Utils.*;

public class BruteForce {

    public void run(Triple[] triples) {
        Polynomial p = new Polynomial();

        p.set(deg, 1);

        ArrayList<Polynomial> polynomials = new ArrayList<>();

        p.set(0, 275);
        p.set(1, 97);

        System.out.println(Arrays.stream(triples).anyMatch(triple -> gcd(p.substitute(triple.x), N) != 1));

        for (int i = 0; i < N; ++i) {
            p.set(0, i);
            for (int j = 0; j < N; ++j) {
                p.set(1, j);

                boolean b = Arrays.stream(triples).anyMatch(triple -> gcd(p.substitute(triple.x), N) != 1);

                if (b) {
                    polynomials.add(new Polynomial(p));
                }

            }
        }


        System.out.println(polynomials.size());
        System.out.println(polynomials.get(123));
    }
}
