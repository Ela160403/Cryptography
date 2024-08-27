# Caesar Cipher Java Implementation

## Introduction

The Caesar Cipher is a classic encryption technique that shifts each letter in the plaintext by a fixed number of positions in the alphabet. Named after Julius Caesar, who used this cipher to secure his messages, it is a type of substitution cipher where each letter is replaced by another letter a certain number of positions down the alphabet.

## Concept

### Encryption

To encrypt a message with the Caesar Cipher:
1. **Choose a Key:** This is the number of positions each letter in the plaintext will be shifted.
2. **Shift Letters:** Replace each letter in the plaintext by the letter that is a fixed number of positions down the alphabet. For example, with a key of 3:
   - 'A' becomes 'D'
   - 'B' becomes 'E'
   - 'Z' becomes 'C'

### Decryption

To decrypt a message:
1. **Reverse the Key:** Shift each letter in the ciphertext back by the key value used for encryption. For example, if the key was 3:
   - 'D' becomes 'A'
   - 'E' becomes 'B'
   - 'C' becomes 'Z'

### Example

**Encryption Example:**
- **Plaintext:** HELLO
- **Key:** 3
- **Ciphertext:** KHOOR

**Decryption Example:**
- **Ciphertext:** KHOOR
- **Key:** 3
- **Plaintext:** HELLO

## Java Implementation

This Java program demonstrates the Caesar Cipher encryption and decryption processes. It also includes a brute-force method to try all possible key values for decryption.

### Program Details

1. **Basic Class:**
   - **`indexOfChar(char c)`**: Finds the index of a character in the alphabet.
   - **`charAtIndex(int pos)`**: Retrieves a character from the alphabet based on an index.

2. **Caesar Class:**
   - **`encrypt(String plainText, int key)`**: Encrypts plaintext using the Caesar Cipher with a specified key.
   - **`decrypt(String cipherText, int key)`**: Decrypts ciphertext using the Caesar Cipher with a specified key.
   - **`bruteForce(String cipherText)`**: Attempts to decrypt the ciphertext using all possible keys (0 to 25) and prints the results.

3. **CaesarCipher Class:**
   - **Main Method:** Handles user input for plaintext, key, and performs encryption, decryption, and optional brute-force attack.

```

## Usage

1. **Compile the Program:** `javac CaesarCipher.java`
2. **Run the Program:** `java CaesarCipher`
3. **Follow the Prompts:** Enter the plaintext message and key for encryption. You can also choose to apply a brute-force attack on the ciphertext.

---
