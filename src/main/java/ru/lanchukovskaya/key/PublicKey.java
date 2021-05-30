package ru.lanchukovskaya.key;

import java.math.BigInteger;

public class PublicKey {

    private final BigInteger N;
    private final BigInteger C;

    public PublicKey(BigInteger N, BigInteger C) {
        this.N = N;
        this.C = C;
    }

    public BigInteger getN() {
        return N;
    }

    public BigInteger getC() {
        return C;
    }
}
