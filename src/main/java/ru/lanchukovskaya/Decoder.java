package ru.lanchukovskaya;

import ru.lanchukovskaya.key.PublicKey;
import ru.lanchukovskaya.key.SecretKey;

import java.math.BigInteger;

public class Decoder {
    private final BigInteger encryptedMessage;
    private final SecretKey secretKey;
    private final PublicKey publicKey;

    public Decoder(BigInteger encryptedMessage, SecretKey secretKey, PublicKey publicKey) {
        this.encryptedMessage = encryptedMessage;
        this.secretKey = secretKey;
        this.publicKey = publicKey;
    }

    public BigInteger getDecryptMessage() {
        return encryptedMessage.modPow(secretKey.getD(), publicKey.getN());
    }
}
