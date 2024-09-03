# Playfair Cipher

The Playfair Cipher is a classical encryption technique that encrypts pairs of letters in the plaintext. It uses a keyword to create a 5x5 matrix of letters, which is used for substitution.

## How It Works

1. **Create the Key Matrix**: Construct a 5x5 matrix using the keyword. The matrix contains each letter of the alphabet exactly once, with 'I' and 'J' combined into a single letter.

2. **Prepare the Plaintext**: Convert the message to uppercase, remove non-alphabetic characters, replace 'J' with 'I', and split the message into pairs of letters. If a pair has duplicate letters, insert an 'X' between them.

3. **Encrypt the Pairs**: Use the matrix to encrypt each pair of letters based on their positions in the matrix.

4. **Combine the Encrypted Pairs**: The encrypted pairs are assembled to form the final ciphertext.

## Example

### Key Matrix

Let's use the keyword `KEYWORD` to create the matrix:

1. Remove duplicates and combine 'I' and 'J':
   ```
   KEYWORDABCFHILMNOPQRSTUVWXZ
   ```

2. Construct the 5x5 matrix:
   ```
   K E Y W O
   R A B C D
   F G H I/J L
   M N O P Q
   S T U V X
   ```

### Plaintext

Consider the plaintext: `HELLO WORLD`

1. Remove non-alphabetic characters and replace 'J' with 'I':
   ```
   HELLOWORLD
   ```

2. Split into pairs:
   ```
   HE LL OW OR LD
   ```

   (Note: Duplicate 'L' in `LL` is replaced by `LX`):
   ```
   HE LX OW OR LD
   ```

### Encryption Process

Using the matrix, we encrypt the pairs:

- **HE**: H is at (3,3) and E is at (1,2). Both are in different rows and columns. 
  - Substitute with letters at (3,2) and (1,3) → **GB**

- **LX**: L is at (3,5) and X is at (5,5). Both are in the same column.
  - Substitute with letters below each → **YX**

- **OW**: O is at (4,3) and W is at (1,4). Both are in different rows and columns.
  - Substitute with letters at (4,4) and (1,3) → **PQ**

- **OR**: O is at (4,3) and R is at (2,1). Both are in different rows and columns.
  - Substitute with letters at (4,1) and (2,3) → **MS**

- **LD**: L is at (3,5) and D is at (2,4). Both are in different rows and columns.
  - Substitute with letters at (3,4) and (2,5) → **PD**

### Ciphertext

Combining the encrypted pairs, the final ciphertext is:
```
GB YX PQ MS PD
```

## Conclusion

The Playfair Cipher provides a more secure method of encrypting text compared to simple substitution ciphers by using a keyword to introduce polyalphabetic substitution.
