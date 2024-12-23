package boardProject.global.security.encryption.handler;

import boardProject.global.security.encryption.key.hmac.HmacKey;
import boardProject.global.security.encryption.strategy.HashingStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Component
@RequiredArgsConstructor
public class HmacSha256Hashing implements HashingStrategy {

    private final HmacKey hmacKey;


    public String generateHash(String message)
            throws NoSuchAlgorithmException, InvalidKeyException {

       SecretKey secretKey = hmacKey.getHmacKey();

        Mac mac = Mac.getInstance(hmacKey.getKeyAlgorithm());
        mac.init((Key) hmacKey);

        byte[] hash = mac.doFinal(message.getBytes());

        return Base64.getEncoder().encodeToString(hash);
    }




    public boolean verifyHash(String message,String hmacHash)
            throws NoSuchAlgorithmException, InvalidKeyException {

        String generatedHmac = generateHash(message);

        return generatedHmac.equals(hmacHash);
    }
}
