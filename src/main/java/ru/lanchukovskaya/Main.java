package ru.lanchukovskaya;

import ru.lanchukovskaya.key.KeysGenerator;
import ru.lanchukovskaya.key.PublicKey;
import ru.lanchukovskaya.key.SecretKey;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        KeysGenerator keysGenerator = new KeysGenerator();
        keysGenerator.keysGeneration();
        PublicKey publicKey = keysGenerator.getPublicKey();
        SecretKey secretKey = keysGenerator.getSecretKey();
        Coder coder = new Coder(publicKey);
        BigInteger message = BigInteger.valueOf(123);
        Decoder decoder = new Decoder(coder.getEncryptMessage(message), secretKey, publicKey);
        BigInteger decryptMessage = decoder.getDecryptMessage();
        if (decryptMessage.compareTo(message) == 0) {
            System.out.println("The message was correctly encrypted and decrypted!");
        } else {
            System.out.println("Some problems occurred while encrypting and decrypting the message...");
        }

    }
}
