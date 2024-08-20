import java.util.Scanner;

public class passwordStrength {

    public static String checkPasswordStrength(String password) {
        int n = password.length();
        
        boolean hasLower = false, hasUpper = false, hasDigit = false, hasSpecial = false;
        
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                hasLower = true;
            } else if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (isSpecialCharacter(c)) {
                hasSpecial = true;
            }
        }

        if (n >= 8 && hasLower && hasUpper && hasDigit && hasSpecial) {
            return "Strong Password";
        } else if (n >= 6 && ((hasLower || hasUpper) && hasDigit)) {
            return "Medium Strength Password";
        } else {
            return "Weak Password";
        }
    }

    private static boolean isSpecialCharacter(char c) {
        String specialCharacters = "!@#$%^&*()-+";
        return specialCharacters.indexOf(c) >= 0;
    }

    public static void passwordStrength(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        String strength = checkPasswordStrength(password);
        System.out.println("Password: " + password);
        System.out.println("Strength: " + strength);

        scanner.close();
    }
}
