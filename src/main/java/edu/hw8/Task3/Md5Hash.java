package edu.hw8.Task3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Hash {

    private final int hex = 0xff;

    public Md5Hash() {

    }

    public String get(String source) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(source.getBytes());
            byte[] digest = md.digest();
            return bytesToHex(digest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b & hex));
        }
        return builder.toString();
    }
}
