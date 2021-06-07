package encryptdecrypt;

public interface EncryptionMethod {
    String encrypt(String cypherText, int key);
    String decrypt(String cypherText, int key);
}
