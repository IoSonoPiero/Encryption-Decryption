package encryptdecrypt;

public class UnicodeAlgorithm implements EncryptionMethod {

    @Override
    public String encrypt(String cypherText, int key) {
        // declare an array of chars, it will contain the encrypted characters
        char[] arrayOfChars = new char[cypherText.length()];

        int result = 0;
        int letter;

        // encrypt function
        // loop to convert chars
        for (int i = 0; i < cypherText.length(); i++) {

            // convert char to int (set 0-65535)
            letter = (int) cypherText.charAt(i);

            // calculate the rotation
            result = (letter % 65536) + key;

            // if result is bigger than 65535
            // reduce it to a number inside 0-65535
            // always using modulus operation
            while (result > 65536) {
                result = (result % 65536);
            }

            // the resulting character, "reconverted" to 0-65535 set
            arrayOfChars[i] = (char) (result + 65536);

        }
        // set encrypted text
        return String.valueOf(arrayOfChars);
    }

    @Override
    public String decrypt(String cypherText, int key) {
        // declare an array of chars, it will contain the encrypted characters
        char[] arrayOfChars = new char[cypherText.length()];

        int result = 0;
        int letter;

        // encrypt function
        // loop to convert chars
        for (int i = 0; i < cypherText.length(); i++) {

            // convert char to int (set 0-65535)
            letter = (int) cypherText.charAt(i);

            // calculate the rotation
            result = (letter % 65536) - key;

            // if result is bigger than 65535
            // reduce it to a number inside 0-65535
            // always using modulus operation
            while (result > 65536) {
                result = (result % 65536);
            }

            // the resulting character, "reconverted" to 0-65535 set
            arrayOfChars[i] = (char) (result - 65536);

        }
        // set encrypted text
        return String.valueOf(arrayOfChars);
    }
}
