# 🗝️ Vigenère Cipher

The **Vigenère Cipher** is a classic encryption technique that enhances the simple Caesar Cipher by using a keyword to shift the letters in the plaintext. This method provides a more secure way of encoding messages.

## 📜 How It Works

- **Plaintext**: The original message that you want to encrypt.
- **Keyword**: A sequence of letters used to determine the shift for each letter in the plaintext.
- **Ciphertext**: The encrypted message generated after applying the Vigenère Cipher.

### ✨ Encryption Process

1. **Generate Key**: Extend the keyword so that it matches the length of the plaintext.
2. **Shift Characters**: Shift each letter in the plaintext according to the corresponding letter in the extended keyword.
3. **Construct Ciphertext**: Combine the shifted characters to form the ciphertext.

### 🔓 Decryption Process

1. **Use the Same Key**: The same keyword is used for decryption.
2. **Reverse the Shift**: Subtract the shift values to retrieve the original characters.
3. **Retrieve Plaintext**: The resulting text is the original plaintext.

## 📝 Example

Here’s an example to illustrate how the Vigenère Cipher works.

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
    - **V (shift 22)** = V → **T**
    - **A (shift 14)** = A → **O**
    - **R (shift 17)** = R → **I**
    - **A (shift 3)** = A → **D**
    - **S (shift 10)** = S → **C**
    - **A (shift 4)** = A → **E**
    - **N (shift 24)** = N → **H**

    The resulting **Ciphertext** is **HIJZVHSJBM**.

3. **Decrypt the Ciphertext**:

    - **H (shift 10)** = H → **E**
    - **I (shift 4)** = I → **L**
    - **J (shift 24)** = J → **A**
    - **Z (shift 22)** = Z → **V**
    - **V (shift 14)** = V → **A**
    - **H (shift 17)** = H → **R**
    - **S (shift 3)** = S → **A**
    - **J (shift 10)** = J → **S**
    - **B (shift 4)** = B → **A**
    - **M (shift 24)** = M → **N**

    The resulting **Plaintext** is **ELAVARASAN**.

## 🎯 Conclusion

The Vigenère Cipher is an elegant method of encrypting text that uses a keyword to provide polyalphabetic substitution. By using a repeating keyword, it offers improved security over simple substitution ciphers.

---
