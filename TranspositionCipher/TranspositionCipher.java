import java.util.Scanner;

public class TranspositionCipher {

    // Method to perform encryption using the transposition cipher
    public static String encrypt(String text, int key) {
        // Calculate the number of columns and rows for the grid
        int numOfColumns = key;
        int numOfRows = (int) Math.ceil((double) text.length() / numOfColumns);
        char[][] grid = new char[numOfRows][numOfColumns];

        // Fill the grid with characters from the text
        int index = 0;
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfColumns; j++) {
                if (index < text.length()) {
                    grid[i][j] = text.charAt(index++);
                } else {
                    grid[i][j] = ' '; // Fill empty cells with spaces
                }
            }
        }

        // Read columns and build the encrypted text
        StringBuilder encryptedText = new StringBuilder();
        for (int col = 0; col < numOfColumns; col++) {
            for (int row = 0; row < numOfRows; row++) {
                encryptedText.append(grid[row][col]);
            }
        }

        return encryptedText.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User input for text and key
        System.out.print("Enter the text to encrypt: ");
        String text = scanner.nextLine();
        System.out.print("Enter the key (number of columns): ");
        int key = scanner.nextInt();

        // Perform encryption
        String encryptedText = encrypt(text, key);

        // Output the encrypted text
        System.out.println("Encrypted Text: " + encryptedText);

        scanner.close();
    }
}