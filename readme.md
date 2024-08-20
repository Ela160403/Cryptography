

# Cryptography Concepts

Welcome to the Cryptography Concepts repository! This project provides an overview and implementation of various cryptographic concepts and algorithms. Cryptography is essential for securing communication and protecting data from unauthorized access. Here, you will find explanations, implementations, and practical applications of key cryptographic techniques.

## Table of Contents

- [Introduction](#introduction)
- [Symmetric Encryption](#symmetric-encryption)
  - [AES (Advanced Encryption Standard)](#aes-advanced-encryption-standard)
- [Asymmetric Encryption](#asymmetric-encryption)
  - [RSA (Rivest-Shamir-Adleman)](#rsa-rivest-shamir-adleman)
- [Hash Functions](#hash-functions)
  - [SHA-256 (Secure Hash Algorithm 256-bit)](#sha-256-secure-hash-algorithm-256-bit)
- [Digital Signatures](#digital-signatures)
  - [ECDSA (Elliptic Curve Digital Signature Algorithm)](#ecdsa-elliptic-curve-digital-signature-algorithm)
- [Implementation Examples](#implementation-examples)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Introduction

Cryptography is a branch of mathematics and computer science focused on securing information through various techniques. It involves encoding information so that only authorized parties can access or modify it. This repository explores fundamental cryptographic techniques used in securing data.

## Symmetric Encryption

Symmetric encryption uses the same key for both encryption and decryption. It is efficient for encrypting large amounts of data.

### AES (Advanced Encryption Standard)

AES is a widely used symmetric encryption algorithm that supports key sizes of 128, 192, and 256 bits. It is known for its security and performance.

- **Algorithm:** AES
- **Key Sizes:** 128, 192, 256 bits
- **Block Size:** 128 bits

#### Example

```java
// Java example for AES encryption
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AESEncryption {
    public static void main(String[] args) throws Exception {
        String plainText = "Hello, World!";
        SecretKey secretKey = KeyGenerator.getInstance("AES").generateKey();
        Cipher cipher = Cipher.getInstance("AES");
        
        // Encryption
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encrypted = cipher.doFinal(plainText.getBytes());
        
        // Decryption
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decrypted = cipher.doFinal(encrypted);
        
        System.out.println("Decrypted Text: " + new String(decrypted));
    }
}
```

## Asymmetric Encryption

Asymmetric encryption uses a pair of keys: a public key for encryption and a private key for decryption. It is commonly used for secure key exchange and digital signatures.

### RSA (Rivest-Shamir-Adleman)

RSA is a widely used asymmetric encryption algorithm that relies on the difficulty of factoring large numbers.

- **Algorithm:** RSA
- **Key Size:** 2048 bits (recommended)

#### Example

```java
// Java example for RSA encryption
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;

public class RSAEncryption {
    public static void main(String[] args) throws Exception {
        String plainText = "Hello, World!";
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(2048);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();
        
        Cipher cipher = Cipher.getInstance("RSA");
        
        // Encryption
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encrypted = cipher.doFinal(plainText.getBytes());
        
        // Decryption
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decrypted = cipher.doFinal(encrypted);
        
        System.out.println("Decrypted Text: " + new String(decrypted));
    }
}
```

## Hash Functions

Hash functions generate a fixed-size hash value from variable-sized input data. They are commonly used for data integrity and digital signatures.

### SHA-256 (Secure Hash Algorithm 256-bit)

SHA-256 is a cryptographic hash function that produces a 256-bit hash value. It is widely used in security protocols and applications.

- **Algorithm:** SHA-256
- **Hash Size:** 256 bits

#### Example

```java
// Java example for SHA-256 hash
import java.security.MessageDigest;

public class SHA256Hash {
    public static void main(String[] args) throws Exception {
        String text = "Hello, World!";
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(text.getBytes());
        
        // Convert hash to hexadecimal
        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        
        System.out.println("SHA-256 Hash: " + sb.toString());
    }
}
```

## Digital Signatures

Digital signatures provide authentication and integrity verification of messages and documents.

### ECDSA (Elliptic Curve Digital Signature Algorithm)

ECDSA is an asymmetric algorithm that uses elliptic curve cryptography for digital signatures. It offers a high level of security with relatively small key sizes.

- **Algorithm:** ECDSA
- **Curve:** P-256 (recommended)

#### Example

```java
// Java example for ECDSA signature
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;

public class ECDSASignature {
    public static void main(String[] args) throws Exception {
        String text = "Hello, World!";
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("EC");
        keyPairGen.initialize(256);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        
        Signature signer = Signature.getInstance("SHA256withECDSA");
        signer.initSign(keyPair.getPrivate());
        signer.update(text.getBytes());
        byte[] signature = signer.sign();
        
        // Verify signature
        Signature verifier = Signature.getInstance("SHA256withECDSA");
        verifier.initVerify(keyPair.getPublic());
        verifier.update(text.getBytes());
        boolean isVerified = verifier.verify(signature);
        
        System.out.println("Signature Verified: " + isVerified);
    }
}
```

## Implementation Examples

For detailed implementation examples and use cases, please refer to the [examples](examples) directory in this repository.

## Usage

To use the cryptographic functions provided in this repository, clone the repository and include the relevant files in your project. Make sure to follow best practices for cryptographic security.

## Contributing

Contributions to this repository are welcome! If you have any improvements, bug fixes, or new features, please submit a pull request or open an issue.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

