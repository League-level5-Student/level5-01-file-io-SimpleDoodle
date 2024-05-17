package _02_File_Encrypt_Decrypt;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileDecryptor {
	/*
	 * Decryption is the process of taking encoded or encrypted text or other data
	 * and converting it back into text that you or the computer can read and
	 * understand.
	 *
	 * The shift cipher is decrypted by using using the key and shifting back up, at
	 * the end of our encryption example we had our alphabet as:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 *
	 * If we shift it back up by 4 based on the key we used the alphabet is
	 * decrypted:
	 *
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 *
	 * "Lipps Asvph" returns to "Hello World"
	 * 
	 * Create a program that opens the file created by FileEncryptor and decrypts
	 * the message, then display it to the user in a JOptionPane.
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Type in the key for the encrypted message");
		StringBuilder decryptedMsg = new StringBuilder();
		int key = scan.nextInt();
		try {
			FileReader fr = new FileReader("src/_02_File_Encrypt_Decrypt/encrypted.txt");
			int encryptChar = fr.read();
			while (encryptChar != -1) {
				if (encryptChar + key <= 122 && encryptChar + key > 90) {
					encryptChar = encryptChar += key;
				} else if (encryptChar + key <= 90) {
					encryptChar = encryptChar += key;
				} else {
					int tempInt = ((encryptChar - 26) + key);
				}
				decryptedMsg.append((char) encryptChar);
				encryptChar = fr.read();
			}
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(decryptedMsg);
	}
}
