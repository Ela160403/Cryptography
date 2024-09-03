import java.util.Scanner;

class GFG {
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

    // This function returns the encrypted text generated with the help of the key
    static String cipherText(String str, String key) {
        StringBuilder cipher_text = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            // converting in range 0-25
            int x = (str.charAt(i) + key.charAt(i)) % 26;

            // convert into alphabets(ASCII)
            x += 'A';

            cipher_text.append((char) x);
        }
        return cipher_text.toString();
    }

    // This function decrypts the encrypted text and returns the original text
    static String originalText(String cipher_text, String key) {
        StringBuilder orig_text = new StringBuilder();

        for (int i = 0; i < cipher_text.length(); i++) {
            // converting in range 0-25
            int x = (cipher_text.charAt(i) - key.charAt(i) + 26) % 26;

            // convert into alphabets(ASCII)
            x += 'A';
            orig_text.append((char) x);
        }
        return orig_text.toString();
    }

    // This function will convert the lower case character to upper case
    static String LowerToUpper(String s) {
        StringBuilder str = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLowerCase(s.charAt(i))) {
                str.setCharAt(i, Character.toUpperCase(s.charAt(i)));
            }
        }
        return str.toString();
    }

    // Driver code
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input from the user
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
