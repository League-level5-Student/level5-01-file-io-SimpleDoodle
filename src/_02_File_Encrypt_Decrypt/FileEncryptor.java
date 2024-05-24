package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information
	 * in such a way that only authorized parties can access it and
	 * those who are not authorized cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message
	 * down based on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user.
	 * Use the key to shift each letter in the users input and save the final result to a file.
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Type a message to be encoded in a file.");
		String s = scan.next();
		System.out.println("Type a number to shift the letters.");
		int key = scan.nextInt();
		char[] charArray = s.toCharArray();
		StringBuilder decryptedMsg = new StringBuilder();
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] - key >= 97) {
				charArray[i] = charArray[i] -= key;
			}
			else if(charArray[i] >= 97){
				int tempInt = (123 - (key - (charArray[i] - 97)));
				charArray[i] = (char) (tempInt);
			}
			else if(charArray[i] - key >= 65) {
				charArray[i] = charArray[i] -= key;
			}
			else if(charArray[i] == 32) {
			}
			else {
				int tempInt = (91 - (key - (charArray[i] - 65)));
				charArray[i] = (char) (tempInt);
			}
			decryptedMsg.append(charArray[i]);
		}
		try {
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/encrypted.txt");
			fw.write(decryptedMsg.toString());
			fw.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
