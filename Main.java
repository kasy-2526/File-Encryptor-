import java.io.File;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Encryptor en = Encryptor.getEncrypter(false);  // false = keep original files
        Decryptor de = Decryptor.getDecrypter(false);  // false = keep original files

        System.out.println("\n\n#-------Welcome to FILE ENCRYPTION APP-----------#");
        
        System.out.println("\nChoose an option:");
        System.out.println("1. Encrypt a file");
        System.out.println("2. Decrypt a file");
        System.out.print("\nEnter your choice (1 or 2): ");
        
        int choice = sc.nextInt();
        sc.nextLine(); // consume the newline
        
        switch(choice) {
            case 1:
                System.out.print("\nEnter the path of the file to ENCRYPT: ");
                String encryptSource = sc.nextLine().trim().replace("\"", "");
                System.out.print("Enter the destination folder for encrypted file: ");
                String encryptDest = sc.nextLine().trim().replace("\"", "");
                
                File srcFile = new File(encryptSource);
                File destFolder = new File(encryptDest);
                
                System.out.println("\nLooking for: " + srcFile.getAbsolutePath());
                
                if (!srcFile.exists()) {
                    System.out.println("Error: Source file does not exist!");
                    System.out.println("Please check the path and try again.");
                    break;
                }
                
                if (!srcFile.isFile()) {
                    System.out.println("Error: Path is a folder, not a file!");
                    break;
                }
                
                en.encrypt(srcFile, destFolder);
                System.out.println("Encryption complete!");
                break;
                
            case 2:
                System.out.print("\nEnter the path of the file to DECRYPT: ");
                String decryptSource = sc.nextLine().trim().replace("\"", "");
                System.out.print("Enter the destination folder for decrypted file: ");
                String decryptDest = sc.nextLine().trim().replace("\"", "");
                
                File encryptedFile = new File(decryptSource);
                File outputFolder = new File(decryptDest);
                
                System.out.println("\nLooking for: " + encryptedFile.getAbsolutePath());
                
                if (!encryptedFile.exists()) {
                    System.out.println("Error: Encrypted file does not exist!");
                    System.out.println("Please check the path and try again.");
                    break;
                }
                
                de.decrypt(encryptedFile, outputFolder);
                System.out.println("Decryption complete!");
                break;
                
            default:
                System.out.println("Invalid choice! Please enter 1 or 2.");
                break;
        }
        
        sc.close();
    }
}

