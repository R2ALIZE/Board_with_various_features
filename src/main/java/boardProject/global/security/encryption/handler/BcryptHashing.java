package boardProject.global.security.encryption.handler;

import boardProject.global.security.encryption.strategy.HashingStrategy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Component
public class BcryptHashing implements HashingStrategy {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public String generateHash(String plainText)
            throws NoSuchAlgorithmException, InvalidKeyException {
        return passwordEncoder.encode(plainText);
    }

    @Override
    public boolean verifyHash(String plainText, String hashed)
            throws NoSuchAlgorithmException, InvalidKeyException {

        return passwordEncoder.matches(plainText,hashed);
    }
}
