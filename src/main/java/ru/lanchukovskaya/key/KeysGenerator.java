package ru.lanchukovskaya.key;

import java.math.BigInteger;
import java.security.SecureRandom;

public class KeysGenerator {
    private static final int LENGTH = 1024;
    private final SecureRandom rand;
    private PublicKey publicKey;
    private SecretKey secretKey;
    private BigInteger p;
    private BigInteger q;

    public KeysGenerator() {
        rand = new SecureRandom();
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public SecretKey getSecretKey() {
        return secretKey;
    }

    public void keysGeneration() {
        BigInteger N = generateN();
        BigInteger F = generateF();
        BigInteger C = generateC(F);
        BigInteger D = generateD(C, F);
        publicKey = new PublicKey(N, C);
        secretKey = new SecretKey(D, p, q);
    }

    private BigInteger generateD(BigInteger C, BigInteger F) {
        return C.modInverse(F);
    }

    private BigInteger generateC(BigInteger F) {
        BigInteger C = generatePrimeNumber();
        while (!C.gcd(F).equals(BigInteger.ONE)) {
            C = generatePrimeNumber();
        }
        return C;
    }

    private BigInteger generateF() {
        BigInteger newP = p.subtract(BigInteger.ONE);
        BigInteger newQ = q.subtract(BigInteger.ONE);
        return newP.multiply(newQ);
    }

    private BigInteger generateN() {
        p = generatePrimeNumber();
        q = generatePrimeNumber();
        return p.multiply(q);
    }

    private BigInteger generatePrimeNumber() {
        return BigInteger.probablePrime(LENGTH, rand);
    }
}
