package encryptdecrypt;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {

        // if arguments are not in pair, then one of the arguments is missing so show an error message.
        if (args.length % 2 != 0 || args.length == 0) {
            System.out.println("Error! At least one parameter is missing!");
            exit(1);
        }

        // Operation: enc for encryption (default), dec for decryption
        String mode = Utilities.getMode(args);

        // it contains the algorithm, default = shift
        String alg = Utilities.getAlgorithm(args);

        // it contains the plaintext, default is null
        String data = Utilities.getData(args);

        // it contains the key, default = 0
        int key = Utilities.getKey(args);

        Encryption encryption = new Encryption();
        switch (alg) {
            case "shift":
                encryption.setMethod(new ShiftAlgorithm());
                break;
            case "unicode":
                encryption.setMethod(new UnicodeAlgorithm());
                break;
        }

        switch (mode) {
            case "enc":
                Utilities.printData(encryption.encrypt(data, key));
                break;
            case "dec":
                Utilities.printData(encryption.decrypt(data, key));
                break;
        }
    }
}