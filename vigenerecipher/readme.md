# Vigenère Cipher

The Vigenère Cipher is a method of encrypting alphabetic text by using a polyalphabetic substitution technique. The cipher uses a keyword, where each letter of the keyword determines how much each letter of the plaintext will be shifted. This is done by aligning the keyword repeatedly against the plaintext.

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

| **Plaintext** | ELAVARASAN |
|---------------|------------|
| **Keyword**   | KEYWORDKEYW |
| **Key**       | KEYWORDKEYW |
| **Ciphertext**| HIJZVHSJBM |

### Step-by-Step Breakdown

1. **Align the Key with the Plaintext**:

    | **Plaintext** | E | L | A | V | A | R | A | S | A | N |
    |---------------|---|---|---|---|---|---|---|---|---|---|
    | **Key**       | K | E | Y | W | O | R | D | K | E | Y |
    | **Shift**     | 10| 4 | 24| 22| 14| 17| 3 | 10| 4 | 24|

2. **Encrypt the Plaintext**:

    - **E (shift 10)** = E → **H**
    - **L (shift 4)** = L → **P**
    - **A (shift 24)** = A → **Y**
    - **V (shift 22)** = V → **R**
    - **A (shift 14)** = A → **O**
    - **R (shift 17)** = R → **I**
    - **A (shift 3)** = A → **D**
    - **S (shift 10)** = S → **C**
    - **A (shift 4)** = A → **E**
    - **N (shift 24)** = N → **H**

    The resulting **Ciphertext** is **HPYROIDCZH**.

3. **Decrypt the Ciphertext**:

    - **H (shift 10)** = H → **E**
    - **P (shift 4)** = P → **L**
    - **Y (shift 24)** = Y → **A**
    - **R (shift 22)** = R → **V**
    - **O (shift 14)** = O → **A**
    - **I (shift 17)** = I → **R**
    - **D (shift 3)** = D → **A**
    - **C (shift 10)** = C → **S**
    - **E (shift 4)** = E → **A**
    - **H (shift 24)** = H → **N**

    The resulting **Plaintext** is **ELAVARASAN**.

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

    static String toUpperCase(String s) {
        return s.toUpperCase();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the plaintext: ");
        String plaintext = toUpperCase(scanner.nextLine());

        System.out.print("Enter the keyword: ");
        String keyword = toUpperCase(scanner.nextLine());

        String key = generateKey(plaintext, keyword);
        String cipherText = cipherText(plaintext, key);

        System.out.println("Ciphertext: " + cipherText);
        System.out.println("Original/Decrypted Text: " + originalText(cipherText, key));
        
        scanner.close();
    }
}
```

## Conclusion

The Vigenère Cipher is a straightforward encryption technique that enhances simple Caesar Ciphers by using a keyword to introduce polyalphabetic substitution. Its security depends on the secrecy and complexity of the keyword used.

---

Feel free to use and adjust the README content to fit your needs!
