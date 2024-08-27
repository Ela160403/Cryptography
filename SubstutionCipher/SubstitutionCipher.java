import java.util.Scanner;

public class SubstitutionCipher {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String SUBSTITUTION_KEY = "KLMNOPQRSTUVWXYZABCDEFGHIJ"; // Example

    public static String encrypt(String plaintext) {
        StringBuilder ciphertext = new StringBuilder();
        for (char c : plaintext.toUpperCase().toCharArray()) {
            if (Character.isLetter(c)) {
                int index = ALPHABET.indexOf(c);
                char substitutedChar = SUBSTITUTION_KEY.charAt(index);
                ciphertext.append(Character.isLowerCase(c) ? Character.toLowerCase(substitutedChar) : substitutedChar);
            } else {
                ciphertext.append(c);
            }
        }
        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext) {
        StringBuilder plaintext = new StringBuilder();
        for (char c : ciphertext.toUpperCase().toCharArray()) {
            if (Character.isLetter(c)) {
                int index = SUBSTITUTION_KEY.indexOf(c);
                char originalChar = ALPHABET.charAt(index);
                plaintext.append(Character.isLowerCase(c) ? Character.toLowerCase(originalChar) : originalChar);
            } else {
                plaintext.append(c);
            }
        }
        return plaintext.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get plaintext input from the user
        System.out.print("Enter the message to encrypt: ");
        String plaintext = scanner.nextLine();
        
        // Encrypt the plaintext
        String encryptedMessage = encrypt(plaintext);
        System.out.println("Encrypted message: " + encryptedMessage);
        
        // Decrypt the encrypted message
        String decryptedMessage = decrypt(encryptedMessage);
        System.out.println("Decrypted message: " + decryptedMessage);
        
        scanner.close();
    }
}
