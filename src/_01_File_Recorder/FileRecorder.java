package _01_File_Recorder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.
	public static void main(String[] args) {
		Scanner inputMsg = new Scanner(System.in);
		System.out.println("Type a message to be saved in a file.");
		String s = inputMsg.next();
		try {
			FileWriter fw = new FileWriter("src/_01_File_Recorder/savefile.txt");
			
			fw.write(s);
			
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
//Copyright © 2019 Michael Xu