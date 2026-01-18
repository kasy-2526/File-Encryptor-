# SafeBytes - File Encryption Tool

A lightweight Java-based file encryption and decryption tool that secures your files by encrypting their contents and hiding the original filename.

---

##  Features

- **Encrypt any file** - Secures file contents using bitwise encryption
- **Decrypt files** - Restores files to their original state with original filename
- **Batch processing** - Encrypt/decrypt entire folders at once
- **Filename hiding** - Encrypted files get random names (e.g., `aB3xK9mNpQ.encrypted`)
- **Original file preservation** - Keeps your source files safe (configurable)
- **Cross-platform** - Works on Windows, Linux, and macOS

---

## Prerequisites

- **Java JDK 11 or higher** installed on your system
- [Download Java JDK](https://www.oracle.com/java/technologies/downloads/)

Verify installation:
```bash
java --version
```

---

## Quick Start

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/SafeBytes.git
cd SafeBytes
```

### 2. Compile

```bash
javac *.java
```

### 3. Run

```bash
java Main
```

---

##  Usage

### Encrypting a File

```
#-------Welcome to FILE ENCRYPTION APP-----------#

Choose an option:
1. Encrypt a file
2. Decrypt a file

Enter your choice (1 or 2): 1

Enter the path of the file to ENCRYPT: C:\Documents\secret.pdf
Enter the destination folder for encrypted file: C:\Documents\encrypted

Looking for: C:\Documents\secret.pdf
Encrypting...
1 files are encrypted
Encryption complete!
```

**Result:** Your file is now saved as something like `aB3xK9mNpQ.encrypted`

### Decrypting a File

```
Enter your choice (1 or 2): 2

Enter the path of the file to DECRYPT: C:\Documents\encrypted\aB3xK9mNpQ.encrypted
Enter the destination folder for decrypted file: C:\Documents\restored

Looking for: C:\Documents\encrypted\aB3xK9mNpQ.encrypted
Decryting...
1 files are decrytped
Decryption complete!
```

**Result:** Your original file `secret.pdf` is restored!

---

## Project Structure

```
SafeBytes/
├── Main.java        # Entry point - handles user interaction
├── Encryptor.java   # Handles file encryption logic
├── Decryptor.java   # Handles file decryption logic
└── README.md        # Documentation
```

---

## How It Works

### Encryption Process

1. **Read** the source file
2. **Store** the original filename in the encrypted file header
3. **Apply** bitwise NOT operation to each byte of content
4. **Save** with a random filename + `.encrypted` extension

### Encrypted File Structure

```
┌─────────────────────────────────────────────────────────┐
│ Byte 0:         Length of original filename (N)        │
│ Bytes 1 to N×2: Original filename encoded as bytes     │
│ Remaining:      Encrypted file content                 │
└─────────────────────────────────────────────────────────┘
```

### Decryption Process

1. **Read** the filename length from the first byte
2. **Extract** the original filename from the header
3. **Apply** bitwise NOT to restore original content
4. **Save** with the original filename

### The Algorithm

```java
// Encryption & Decryption (same operation - bitwise NOT)
data[i] = (byte) ~data[i];
```

Since `~~x = x`, applying NOT twice returns the original value.

---

##  Configuration

### Keep or Delete Original Files

In `Main.java`, you can configure whether to keep or delete original files:

```java
// Keep original files (safe mode)
Encryptor en = Encryptor.getEncrypter(false);
Decryptor de = Decryptor.getDecrypter(false);

// Delete original files after processing
Encryptor en = Encryptor.getEncrypter(true);
Decryptor de = Decryptor.getDecrypter(true);
```

---

##  Security Notice

> **Important:** This tool uses a simple bitwise NOT algorithm for educational purposes. It is NOT cryptographically secure and should NOT be used for sensitive data protection.

For production use, consider:
- AES (Advanced Encryption Standard)
- RSA encryption
- Java's `javax.crypto` package

---






