# Vigenère Cipher

The Vigenère Cipher is a method of encrypting alphabetic text by using a simple form of polyalphabetic substitution. The cipher uses a keyword, where each letter of the keyword determines how much each letter of the plaintext will be shifted. This is done by aligning the keyword repeatedly against the plaintext.

## How It Works

- **Plaintext**: The original message that you want to encrypt.
- **Keyword**: The key that is repeated to match the length of the plaintext. Each letter of the keyword corresponds to a shift value.
- **Ciphertext**: The encrypted message obtained after applying the Vigenère Cipher.

### Encryption Process

1. **Generate Key**: Extend the keyword to the length of the plaintext by repeating it.
2. **Shift Characters**: Each letter in the plaintext is shifted by a number of positions in the alphabet, determined by the corresponding letter in the keyword.
3. **Construct Ciphertext**: The shifted characters form the ciphertext.

### Decryption Process

1. **Use the Same Key**: The same key is used to decrypt the ciphertext.
2. **Reverse the Shift**: Subtract the corresponding shift value to retrieve the original characters.
3. **Retrieve Plaintext**: The result is the original plaintext.

## Example

Let's walk through an example to see how the Vigenère Cipher works.

### Example Details

| **Plaintext** | GEEKSFORTGEEKS |
|---------------|----------------|
| **Keyword**   | AYUSHAYUSHAYUS |
| **Key**       | AYUSHAYUSHAYUS |
| **Ciphertext**| GFKPGYUTVGFKPG |

### Step-by-Step Breakdown

1. **Align the Key with the Plaintext**:

    | **Plaintext** | G | E | E | K | S | F | O | R | T | G | E | E | K | S |
    |---------------|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
    | **Key**       | A | Y | U | S | H | A | Y | U | S | H | A | Y | U | S |
    | **Shift**     | 0 | 24| 20| 18| 7 | 0 | 24| 20| 18| 7 | 0 | 24| 20| 18|

2. **Encrypt the Plaintext**:

    - **G (shift 0)** = G → **G**
    - **E (shift 24)** = E → **F**
    - **E (shift 20)** = E → **K**
    - **K (shift 18)** = K → **P**
    - **S (shift 7)** = S → **G**
    - **F (shift 0)** = F → **F**
    - **O (shift 24)** = O → **Y**
    - **R (shift 20)** = R → **U**
    - **T (shift 18)** = T → **T**
    - **G (shift 7)** = G → **V**
    - **E (shift 0)** = E → **E**
    - **E (shift 24)** = E → **F**
    - **K (shift 20)** = K → **K**
    - **S (shift 18)** = S → **P**

    The resulting **Ciphertext** is **GFKPGYUTVGFKPG**.

3. **Decrypt the Ciphertext**:

    - **G (shift 0)** = G → **G**
    - **F (shift 24)** = F → **E**
    - **K (shift 20)** = K → **E**
    - **P (shift 18)** = P → **K**
    - **G (shift 7)** = G → **S**
    - **F (shift 0)** = F → **F**
    - **Y (shift 24)** = Y → **O**
    - **U (shift 20)** = U → **R**
    - **T (shift 18)** = T → **T**
    - **V (shift 7)** = V → **G**
    - **E (shift 0)** = E → **E**
    - **F (shift 24)** = F → **E**
    - **K (shift 20)** = K → **K**
    - **P (shift 18)** = P → **S**

    The resulting **Plaintext** is **GEEKSFORTGEEKS**.

## Code Implementation

Here's a sample implementation of the Vigenère Cipher in Java:

```java
import java.util.Scanner;

class VigenereCipher {
    static String generateKey(String str, String key) {
        StringBuilder newKey = new StringBuilder(key);
        int x = str.length();

        for (int i = 0; ; i++) {
            if (x == i) i = 0;
            if (newKey.length() == str.length()) break;
            newKey.append(newKey.charAt(i));
        }
        return newKey.toString();
    }

    static String cipherText(String str, String key) {
        StringBuilder cipher_text = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            int x = (str.charAt(i) + key.charAt(i)) % 26;
            x += 'A';
            cipher_text.append((char) x);
        }
        return cipher_text.toString();
    }

    static String originalText(String cipher_text, String key) {
        StringBuilder orig_text = new StringBuilder();

        for (int i = 0; i < cipher_text.length(); i++) {
            int x = (cipher_text.charAt(i) - key.charAt(i) + 26) % 26;
            x += 'A';
            orig_text.append((char) x);
        }
        return orig_text.toString();
    }

    static String LowerToUpper(String s) {
        StringBuilder str = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLowerCase(s.charAt(i))) {
                str.setCharAt(i, Character.toUpperCase(s.charAt(i)));
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the plaintext: ");
        String Str = scanner.nextLine();

        System.out.print("Enter the keyword: ");
        String Keyword = scanner.nextLine();

        String str = LowerToUpper(Str);
        String keyword = LowerToUpper(Keyword);

        String key = generateKey(str, keyword);
        String cipher_text = cipherText(str, key);

        System.out.println("Ciphertext: " + cipher_text);
        System.out.println("Original/Decrypted Text: " + originalText(cipher_text, key));
        
        scanner.close();
    }
}
```

## Conclusion

The Vigenère Cipher is a straightforward encryption technique that improves upon simple Caesar Ciphers by using a keyword to introduce polyalphabetic substitution. Its security depends on the secrecy and complexity of the keyword used.
