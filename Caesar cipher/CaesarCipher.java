import java.util.*;

// Class containing basic utility methods for character operations
class Basic {
    // A string containing all uppercase alphabet characters
    String allChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    // Method to find the index of a given character in the alphabet string
    int indexOfChar(char c) {
        // Loop through the alphabet string to find the index of the character
        for (int i = 0; i < allChar.length(); i++) {
            if (allChar.charAt(i) == c) {
                return i; // Return the index if the character is found
            }
        }
        return -1; // Return -1 if the character is not found
    }

    // Method to get the character at a specific index in the alphabet string
    char charAtIndex(int pos) {
        return allChar.charAt(pos);
    }
}

// Class implementing the Caesar Cipher logic
class Caesar {
    Basic basic = new Basic(); // Create an instance of the Basic class

    // Method to encrypt the plain text using the Caesar Cipher
    String encrypt(String plainText, int key) {
        plainText = plainText.toUpperCase(); // Convert text to uppercase
        String cipherText = "";

        // Loop through each character in the plain text
        for (int i = 0; i < plainText.length(); i++) {
            int index = basic.indexOfChar(plainText.charAt(i)); // Get the index of the character

            // If the character is not in the alphabet, add it as is
            if (index == -1) {
                cipherText += plainText.charAt(i);
                continue;
            }

            // Encrypt the character using the key and add it to the cipher text
            cipherText += basic.charAtIndex((index + key) % 26);
        }
        return cipherText; // Return the encrypted text
    }

    // Method to decrypt the cipher text using the Caesar Cipher
    String decrypt(String cipherText, int key) {
        cipherText = cipherText.toUpperCase(); // Convert text to uppercase
        String decryptedText = "";

        // Loop through each character in the cipher text
        for (int i = 0; i < cipherText.length(); i++) {
            int index = basic.indexOfChar(cipherText.charAt(i)); // Get the index of the character

            // If the character is not in the alphabet, add it as is
            if (index == -1) {
                decryptedText += cipherText.charAt(i);
                continue;
            }

            // Decrypt the character using the key and add it to the decrypted text
            decryptedText += basic.charAtIndex((index - key + 26) % 26);
        }
        return decryptedText; // Return the decrypted text
    }

    // Method to perform a brute-force attack on the cipher text
    void bruteForce(String cipherText) {
        cipherText = cipherText.toUpperCase(); // Convert text to uppercase

        // Try all possible keys from 0 to 25
        for (int k = 0; k < 26; k++) {
            String decryptedText = "";
            int key = k;

            // Decrypt the text using the current key
            for (int i = 0; i < cipherText.length(); i++) {
                int index = basic.indexOfChar(cipherText.charAt(i));

                if (index == -1) {
                    decryptedText += cipherText.charAt(i);
                    continue;
                }

                decryptedText += basic.charAtIndex((index - key + 26) % 26);
            }

            // Print the decrypted text for the current key
            System.out.println("Decrypted Text Using key " + key + ": " + decryptedText);
        }
    }
}

// Main class to run the Caesar Cipher program
class CaesarCipher {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        String plainText, cipherText;
        int key;

        // Get the plain text input from the user
        System.out.println("Enter Plaintext message:");
        plainText = scn.nextLine();

        // Get the encryption key from the user
        System.out.println("Enter key for Encryption:");
        key = scn.nextInt();

        Caesar cipher = new Caesar(); // Create an instance of the Caesar class

        // Encrypt the plain text and display the cipher text
        cipherText = cipher.encrypt(plainText, key);
        System.out.println("Encrypted Ciphertext is: " + cipherText);

        // Decrypt the cipher text and display the plain text
        String decryptedText = cipher.decrypt(cipherText, key);
        System.out.println("Decrypted Ciphertext is: " + decryptedText);

        // Ask the user if they want to perform a brute-force attack
        System.out.println("Do you want to apply brute force on Ciphertext? Press 1, otherwise press any key:");
        int choice = scn.nextInt();

        // If the user chooses to perform a brute-force attack, do so
        if (choice == 1) {
            cipher.bruteForce(cipherText);
        }
    }
}
