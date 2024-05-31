package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList {
	static /*
			 * Create a program with five buttons, add task, view tasks, remove task, save
			 * list, and load list.
			 *
			 * When add task is clicked: Create a JOptionPane to ask the user for a task and
			 * add it to an ArrayList
			 * 
			 * When the view tasks button is clicked: show all the tasks in the list
			 * 
			 * When the remove task button is clicked: Create a JOptionPane to prompt the
			 * user for which task to remove and take it off of the list.
			 * 
			 * When the save list button is clicked: Save the list to a file
			 * 
			 * When the load list button is clicked: Create a JOptionPane to Prompt the user
			 * for the location of the file and load the list from that file
			 * 
			 * When the program starts, it should automatically load the last saved file
			 * into the list.
			 */
	JFrame frame = new JFrame();
	static JPanel panel = new JPanel();
	static JButton addTask = new JButton();
	static JButton viewTask = new JButton();
	static JButton removeTask = new JButton();
	static JButton saveList = new JButton();
	static JButton loadList = new JButton();
	static ArrayList<String> arrString = new ArrayList<>();

	public static void main(String[] args) {
		frame.add(panel);
		panel.add(addTask);
		panel.add(viewTask);
		panel.add(removeTask);
		panel.add(saveList);
		panel.add(loadList);
		frame.show();
		frame.pack();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		addTask.setText("addTask");
		ActionListener aL = (ActionEvent e) -> {
			JButton source = (JButton) e.getSource();
			// System.out.println(source.getActionCommand());
			if (source == addTask) {
				// System.out.println("click");
				arrString.add(JOptionPane.showInputDialog("Add a task"));
				try {
					FileWriter fw = new FileWriter("src/_03_To_Do_List/todo.txt");
					for (int i = 0; i < arrString.size(); i++) {
						fw.write("\n" + arrString.get(i));
					}
					fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			} else if (source == viewTask) {
				try {
					BufferedReader fr = new BufferedReader(new FileReader("src/_03_To_Do_List/todo.txt"));

					String line = fr.readLine();
					while (line != null) {
						System.out.println(line);
						line = fr.readLine();
					}
					fr.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (source == removeTask) {
				String s = JOptionPane.showInputDialog("Remove a task");
				for (int i = 0; i < arrString.size(); i++) {
					if (arrString.get(i) == s) {
						arrString.remove(i);
					}
					try {
						FileWriter fw = new FileWriter("src/_03_To_Do_List/todo.txt");
						fw.write(arrString.toString());
						fw.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			} else if (source == saveList) {

			} else if (source == loadList) {

			}
		};
		addTask.addActionListener(aL);
		viewTask.addActionListener(aL);
		removeTask.addActionListener(aL);
	}
}
