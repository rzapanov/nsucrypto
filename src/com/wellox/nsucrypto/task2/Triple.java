package com.wellox.nsucrypto.task2;

public class Triple {
    public final int i;
    public final int x;
    public final int y;

    public Triple(int i, int x, int y) {
        this.i = i;
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return i + " " + x + " " + y;
    }
}
