package encryptdecrypt;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.System.exit;

class Utilities {

    // Operation: enc for encryption (default), dec for decryption
    private static String mode = "enc";

    // it contains the default algorithm
    private static String alg = "shift";

    // it contains the key, default = 0
    private static int key = 0;

    // it contains the plaintext, default is null
    private static String data = null;

    // it contains the input file, default is null
    private static String input = null;

    // it contains the output file, default is null
    private static String output = null;

    static String getAlgorithm(String[] args) {
        // get command-line arguments
        for (int i = 0; i < args.length; i += 2) {
            if ("-alg".equals(args[i])) {
                alg = args[i + 1];
            }
        }
        return alg;
    }

    public static String getMode(String[] args) {
        // get command-line arguments
        for (int i = 0; i < args.length; i += 2) {
            if ("-mode".equals(args[i])) {
                mode = args[i + 1];
            }
        }
        return mode;
    }

    public static String getData(String[] args) {
        // get command-line arguments
        for (int i = 0; i < args.length; i += 2) {
            switch (args[i]) {
                case "-data":
                    data = args[i + 1];
                    break;
                case "-in":
                    input = args[i + 1];
                    break;
                case "-out":
                    output = args[i + 1];
                    break;
            }
        }

        if (data == null && input != null) {
            // if the input file doesn't exist, generate an error message
            if (!(input == null) || input.length() == 0) {
                Path fileInput = Paths.get(input);
                if (!Files.exists(fileInput)) {
                    System.out.println("Error! Input file is not existent!");
                    exit(1);
                }
            }

            // if inputFileName is valid, read data into String
            if (!(input == null) || input.length() == 0) {
                try {
                    data = new String(Files.readAllBytes(Paths.get(input)));
                } catch (IOException e) {
                    System.out.println("Error! Cannot read file: " + e.getMessage());
                }
            }
        }

        return data;
    }

    public static int getKey(String[] args) {
        // get command-line arguments
        for (int i = 0; i < args.length; i += 2) {
            if ("-key".equals(args[i])) {
                key = Integer.parseInt(args[i + 1]);
            }
        }
        return key;
    }

    public static void printData(String data) {
        if (output != null) {
            File file = new File(output);
            try (PrintWriter printWriter = new PrintWriter(file)) {
                printWriter.print(data); // prints a string
            } catch (IOException e) {
                System.out.printf("Error! An exception occurs %s", e.getMessage());
            }
        } else {
            // print to standard output
            System.out.println(data);
        }
    }
}