package com.wellox.nsucrypto;

import com.wellox.nsucrypto.task2.BruteForce;
import com.wellox.nsucrypto.task2.Triple;
import com.wellox.nsucrypto.task2.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Main {

    static final int n = 2022;


    private static class Poly {

    }

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("C:\\Users\\USER\\Downloads\\data_round2.txt");

        Scanner scanner = new Scanner(file);
        scanner.nextLine(); // drop line

        Triple[] triples = Stream.of(scanner)
                .map(x -> new Iterator<String>() {
                    @Override
                    public boolean hasNext() {
                        return x.hasNext();
                    }

                    @Override
                    public String next() {
                        return x.nextLine();
                    }
                })
                .map(x -> (Iterable<String>) () -> x)
                .flatMap(x -> StreamSupport.stream(x.spliterator(), false))
                .map(x -> x.split(","))
                .map(x -> new Triple(Integer.parseInt(x[0]), Integer.parseInt(x[1]), Integer.parseInt(x[2])))
                .toArray(Triple[]::new);


        new BruteForce().run(triples);
    }
}
