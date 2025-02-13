import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class PasswordCheck {

    // Method to check if a password meets the criteria
    public static boolean isValidPassword(String password) {
        // Check length
        if (password.length() < 12) return false;
        
        // Check for spaces
        if (password.contains(" ")) return false;

        // Flags to track different criteria
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        // Check each character of the password
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else if (!Character.isLetterOrDigit(ch)) hasSpecial = true;
        }

        // Return true only if all criteria are met
        return hasUpper && hasLower && hasDigit && hasSpecial;
    }

    public static void main(String[] args) {
        try {
            // Reading passwords from a file
            File myFile = new File("Passwords.txt"); // Replace with your actual file name
            Scanner myReader = new Scanner(myFile);
            
            int validCount = 0; // Counter for valid passwords

            while (myReader.hasNextLine()) {
                String password = myReader.nextLine();
                
                // Check if the password is valid
                if (isValidPassword(password)) {
                    validCount++;
                }
            }
            
            myReader.close();
            
            // Output the number of valid passwords
            System.out.println("Number of valid passwords: " + validCount);

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }
}
