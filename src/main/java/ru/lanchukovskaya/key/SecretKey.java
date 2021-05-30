package ru.lanchukovskaya.key;

import java.math.BigInteger;

public class SecretKey {
    private final BigInteger d;
    private final BigInteger p;
    private final BigInteger q;

    public SecretKey(BigInteger d, BigInteger p, BigInteger q) {
        this.d = d;
        this.p = p;
        this.q = q;
    }

    public BigInteger getD() {
        return d;
    }

    public BigInteger getP() {
        return p;
    }

    public BigInteger getQ() {
        return q;
    }
}
