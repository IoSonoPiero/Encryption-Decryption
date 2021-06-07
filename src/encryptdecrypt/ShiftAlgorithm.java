package encryptdecrypt;

public class ShiftAlgorithm implements EncryptionMethod {
    @Override
    public String encrypt(String cypherText, int key) {
        // declare an array of chars, it will contain the encrypted characters
        char[] arrayOfChars = new char[cypherText.length()];

        int result = 0;
        int letter;

        // encrypt function
        // loop to convert lower chars
        for (int i = 0; i < cypherText.length(); i++) {
            if (cypherText.charAt(i) >= 'a' && cypherText.charAt(i) <= 'z') {
                letter = ((int) (cypherText.charAt(i) - 96));

                // calculate the rotation
                result = (letter % 26) + key;

                // if result is bigger than 'z' (26th letter),
                // reduce it to a number inside 1-26 always
                // with modulus operation
                while (result > 26) {
                    result = (result % 26);
                }

                arrayOfChars[i] = (char) (result + 96);
            } else {
                // char is outside the a-z set, don't encrypt
                arrayOfChars[i] = cypherText.charAt(i);
            }
        }

        // loop to convert higher chars
        for (int i = 0; i < cypherText.length(); i++) {
            if (cypherText.charAt(i) >= 'A' && cypherText.charAt(i) <= 'Z') {
                letter = ((int) (cypherText.charAt(i) - 64));

                // calculate the rotation
                result = (letter % 26) + key;

                // if result is bigger than 'Z' (26th letter),
                // reduce it to a number inside 1-26 always
                // with modulus operation
                while (result > 26) {
                    result = (result % 26);
                }

                arrayOfChars[i] = (char) (result + 64);
            }
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
        // loop to convert lower chars
        for (int i = 0; i < cypherText.length(); i++) {
            if (cypherText.charAt(i) >= 'a' && cypherText.charAt(i) <= 'z') {
                letter = ((int) (cypherText.charAt(i) - 96));

                // calculate the rotation
                result = (letter % 26) - key;

                // fix for negative results
                if (result < 'a') {
                    result = result + 26;
                }

                // if result is bigger than 'z' (26th letter),
                // reduce it to a number inside 1-26 always
                // with modulus operation
                while (result > 26) {
                    result = (result % 26);
                }

                arrayOfChars[i] = (char) (result + 96);
            } else {
                // char is outside the a-z set, don't encrypt
                arrayOfChars[i] = cypherText.charAt(i);
            }
        }

        // loop to convert higher chars
        for (int i = 0; i < cypherText.length(); i++) {
            if (cypherText.charAt(i) >= 'A' && cypherText.charAt(i) <= 'Z') {
                letter = ((int) (cypherText.charAt(i) - 64));

                // calculate the rotation
                result = (letter % 26) - key;

                // fix for negative results
                if (result < 'A') {
                    result = result + 26;
                }

                // if result is bigger than 'Z' (26th letter),
                // reduce it to a number inside 1-26 always
                // with modulus operation
                while (result > 26) {
                    result = (result % 26);
                }

                arrayOfChars[i] = (char) (result + 64);
            }
        }
        // set decrypted text
        return String.valueOf(arrayOfChars);
    }
}
