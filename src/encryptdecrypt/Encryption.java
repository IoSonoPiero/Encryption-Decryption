package encryptdecrypt;

class Encryption {
    private EncryptionMethod method;

    public void setMethod(EncryptionMethod method) {
        this.method = method;
    }

    public String encrypt(String cypherText, int key) {
        return this.method.encrypt(cypherText, key);
    }

    public String decrypt(String cypherText, int key) {
        return this.method.decrypt(cypherText, key);
    }
}
