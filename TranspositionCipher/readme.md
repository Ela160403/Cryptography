### Transposition Cipher in Java

The transposition cipher is a method of encryption where the positions of the characters in the plaintext are shifted according to a regular system to form the ciphertext. Here's a Java program that demonstrates a simple transposition cipher, where the input is provided by the user.

### Explanation

The transposition cipher works by rearranging the characters of the plaintext based on a specific system. Here's a step-by-step breakdown of the encryption process used in the Java code:

1. **Grid Formation**:
   - Calculate the number of columns (`key`) and rows needed based on the length of the plaintext.
   - Create a 2D character array (grid) with the calculated number of rows and columns.
   - Fill the grid with characters from the plaintext. If the grid is not fully filled, pad it with spaces.

2. **Encryption**:
   - Read the characters column by column from the grid to form the encrypted text.

3. **User Input**:
   - The user provides the plaintext and the key (number of columns). The plaintext is then encrypted using the transposition cipher method.

### Markdown File (`README.md`)

```markdown
# Transposition Cipher in Java

## Overview

The Transposition Cipher is a method of encryption where the positions of the characters in the plaintext are shifted according to a regular system to form the ciphertext. This project demonstrates a simple implementation of the transposition cipher in Java.

## Code Explanation

### Encryption Process

1. **Grid Formation**:
    - Determine the number of columns (`key`) and rows based on the length of the plaintext.
    - Create a 2D grid and fill it with characters from the plaintext.
    - Pad the grid with spaces if necessary.

2. **Column Reading**:
    - Read characters column by column to form the encrypted text.

### Java Code

```java
import java.util.Scanner;

public class TranspositionCipher {
    public static String encrypt(String text, int key) {
        int numOfColumns = key;
        int numOfRows = (int) Math.ceil((double) text.length() / numOfColumns);
        char[][] grid = new char[numOfRows][numOfColumns];

        int index = 0;
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfColumns; j++) {
                if (index < text.length()) {
                    grid[i][j] = text.charAt(index++);
                } else {
                    grid[i][j] = ' ';
                }
            }
        }

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

        System.out.print("Enter the text to encrypt: ");
        String text = scanner.nextLine();
        System.out.print("Enter the key (number of columns): ");
        int key = scanner.nextInt();

        String encryptedText = encrypt(text, key);

        System.out.println("Encrypted Text: " + encryptedText);

        scanner.close();
    }
}
```

## Usage

1. **Compile the Java Program**:
    ```sh
    javac TranspositionCipher.java
    ```

2. **Run the Program**:
    ```sh
    java TranspositionCipher
    ```

3. **Follow the Prompts**:
    - Enter the text you want to encrypt.
    - Enter the key (number of columns for the grid).

## Example

- **Plaintext**: `HELLO WORLD`
- **Key**: `4`

### Grid Formation

| H | E | L | L |
|---|---|---|---|
| O | W | O | R |
| L | D |   |   |

### Encrypted Text

`HO L E W L D O R L`

## Conclusion

This implementation of the transposition cipher demonstrates how character rearrangement can be used for encryption. Modify the code to explore different variations and enhancements of the cipher.
```

Feel free to customize the markdown file further to fit your specific needs!