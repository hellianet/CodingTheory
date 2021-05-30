package ru.lanchukovskaya;

import ru.lanchukovskaya.key.PublicKey;

import java.math.BigInteger;

public class Coder {

    private final PublicKey publicKey;

    public Coder(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

    public BigInteger getEncryptMessage(BigInteger message) {
        return message.modPow(publicKey.getC(), publicKey.getN());
    }
}
