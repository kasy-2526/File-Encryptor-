package Encrypt_decrypt;

import Encrypt_decrypt.Decryptor;
import Encrypt_decrypt.Encryptor;

import java.io.File;
import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Encryptor en = Encryptor.getEncrypter(true);
        Decryptor de = Decryptor.getDecrypter(true);


        int choices;
        System.out.println("\n\n#-------Welcome to FILE ENCRYPTION APP-----------#");

        System.out.println("\nPlease provide the Path of the Source file");
        String Path1=sc.nextLine();
        System.out.println("\nPlease provide the Path of the Destination file");
        String Path2=sc.nextLine();
        File src = new File(Path1);
        File dest=new File(Path2);
        System.out.println("\nEnter 1 to Encrypt the provided File");
        System.out.println("Enter 2 to Decrypt the provided FIle ");
          //  System.out.println("Enter 0 to Exit");

            System.out.println("Enter the choice");
            choices=sc.nextInt();
            switch(choices){
                case 1 :
                    en.encrypt(src, dest);

                    System.exit(0);


                case 2:
                    de.decrypt(dest, src);

                    System.exit(0);


                default:
                    System.out.println("Invalid Choice Entered");
                    break;

        }

    }
}
