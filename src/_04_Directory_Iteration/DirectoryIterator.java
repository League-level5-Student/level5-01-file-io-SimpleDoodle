package _04_Directory_Iteration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

import javax.swing.JFileChooser;

public class DirectoryIterator {
	public static void main(String[] args) {
		/*
		 * The following is an example of how to list all of the files in a directory.
		 * Once the program is running, the directory is chosen using the JFileChooser.
		 */
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File directory = jfc.getSelectedFile();
			File[] files = directory.listFiles();
			if (files != null) {
				// for (File file : files) {
				fileSearch(directory);
				// }
			}
		}

		/*
		 * Your task is to write a program that iterates through the src folder of this
		 * current Java Project. For every .java file it finds, the program will add a
		 * (non-legally binding) copyright statement at the bottom. Be aware of possible
		 * directories inside of directories. (e.g //Copyright © 2019 FirstName
		 * LastName)
		 */
	}

	static void fileSearch(File files) {
		for (File f : files.listFiles()) {
			if (f.isDirectory()) {
				fileSearch(f);
			} else {
				String fileName = f.getAbsolutePath();
				//System.out.println(fileName);
				if (fileName.contains(".java")) {
					try {
					FileWriter fw = new FileWriter(fileName, true);
					// fw.write("//Copyright © 2019 Michael Xu");
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				

			}
		}
	}
}
