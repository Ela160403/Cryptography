import java.util.Scanner;

public class PlayfairCipher {

    private static final int MATRIX_SIZE = 5;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the key: ");
        String key = scanner.nextLine().toUpperCase().replaceAll("[^A-Z]", "");
        System.out.print("Enter the plaintext: ");
        String plaintext = scanner.nextLine().toUpperCase().replaceAll("[^A-Z]", "");
        
        String keyMatrix = generateKeyMatrix(key);
        System.out.println("Key Matrix: \n" + formatMatrix(keyMatrix));
        
        String formattedPlaintext = formatPlaintext(plaintext);
        String encryptedText = encrypt(formattedPlaintext, keyMatrix);
        String decryptedText = decrypt(encryptedText, keyMatrix);
        
        System.out.println("Encrypted Text: " + encryptedText);
        System.out.println("Decrypted Text: " + decryptedText);
    }

    private static String generateKeyMatrix(String key) {
        StringBuilder keyMatrix = new StringBuilder();
        boolean[] used = new boolean[26]; // Array to track used letters

        for (char ch : key.toCharArray()) {
            if (!used[ch - 'A']) {
                keyMatrix.append(ch);
                used[ch - 'A'] = true;
            }
        }

        for (char ch = 'A'; ch <= 'Z'; ch++) {
            if (ch != 'J' && !used[ch - 'A']) {
                keyMatrix.append(ch);
                used[ch - 'A'] = true;
            }
        }

        return keyMatrix.toString();
    }

    private static String formatMatrix(String keyMatrix) {
        StringBuilder matrix = new StringBuilder();
        for (int i = 0; i < keyMatrix.length(); i++) {
            matrix.append(keyMatrix.charAt(i)).append(' ');
            if ((i + 1) % MATRIX_SIZE == 0) {
                matrix.append('\n');
            }
        }
        return matrix.toString();
    }

    private static String formatPlaintext(String plaintext) {
        StringBuilder formattedText = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i++) {
            char ch = plaintext.charAt(i);
            formattedText.append(ch);
            if (i + 1 < plaintext.length() && ch == plaintext.charAt(i + 1)) {
                formattedText.append('X'); // Insert 'X' between duplicate letters
            }
        }
        if (formattedText.length() % 2 != 0) {
            formattedText.append('X'); // Append 'X' if the length is odd
        }
        return formattedText.toString();
    }

    private static String encrypt(String plaintext, String keyMatrix) {
        StringBuilder ciphertext = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i += 2) {
            char a = plaintext.charAt(i);
            char b = plaintext.charAt(i + 1);

            int[] pos1 = findPosition(a, keyMatrix);
            int[] pos2 = findPosition(b, keyMatrix);

            if (pos1[0] == pos2[0]) {
                ciphertext.append(keyMatrix.charAt((pos1[0] * MATRIX_SIZE + (pos1[1] + 1) % MATRIX_SIZE)));
                ciphertext.append(keyMatrix.charAt((pos2[0] * MATRIX_SIZE + (pos2[1] + 1) % MATRIX_SIZE)));
            } else if (pos1[1] == pos2[1]) {
                ciphertext.append(keyMatrix.charAt((((pos1[0] + 1) % MATRIX_SIZE) * MATRIX_SIZE) + pos1[1]));
                ciphertext.append(keyMatrix.charAt((((pos2[0] + 1) % MATRIX_SIZE) * MATRIX_SIZE) + pos2[1]));
            } else {
                ciphertext.append(keyMatrix.charAt((pos1[0] * MATRIX_SIZE) + pos2[1]));
                ciphertext.append(keyMatrix.charAt((pos2[0] * MATRIX_SIZE) + pos1[1]));
            }
        }
        return ciphertext.toString();
    }

    private static String decrypt(String ciphertext, String keyMatrix) {
        StringBuilder plaintext = new StringBuilder();
        for (int i = 0; i < ciphertext.length(); i += 2) {
            char a = ciphertext.charAt(i);
            char b = ciphertext.charAt(i + 1);

            int[] pos1 = findPosition(a, keyMatrix);
            int[] pos2 = findPosition(b, keyMatrix);

            if (pos1[0] == pos2[0]) {
                plaintext.append(keyMatrix.charAt((pos1[0] * MATRIX_SIZE + (pos1[1] + MATRIX_SIZE - 1) % MATRIX_SIZE)));
                plaintext.append(keyMatrix.charAt((pos2[0] * MATRIX_SIZE + (pos2[1] + MATRIX_SIZE - 1) % MATRIX_SIZE)));
            } else if (pos1[1] == pos2[1]) {
                plaintext.append(keyMatrix.charAt((((pos1[0] + MATRIX_SIZE - 1) % MATRIX_SIZE) * MATRIX_SIZE) + pos1[1]));
                plaintext.append(keyMatrix.charAt((((pos2[0] + MATRIX_SIZE - 1) % MATRIX_SIZE) * MATRIX_SIZE) + pos2[1]));
            } else {
                plaintext.append(keyMatrix.charAt((pos1[0] * MATRIX_SIZE) + pos2[1]));
                plaintext.append(keyMatrix.charAt((pos2[0] * MATRIX_SIZE) + pos1[1]));
            }
        }
        return plaintext.toString().replace("X", ""); // Remove padding 'X'
    }

    private static int[] findPosition(char ch, String keyMatrix) {
        int index = keyMatrix.indexOf(ch);
        return new int[] { index / MATRIX_SIZE, index % MATRIX_SIZE };
    }
}
