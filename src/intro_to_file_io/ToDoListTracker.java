package intro_to_file_io;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ToDoListTracker implements ActionListener {
	JFrame f;
	JPanel p;
	JButton b1;
	JButton b2;
	JButton b3;
	JButton b4;

	public static void main(String[] args) {
		ToDoListTracker tdlt = new ToDoListTracker();
	}

	ArrayList<String> td = new ArrayList<String>();

	ToDoListTracker() {
		f = new JFrame();
		p = new JPanel();
		b1 = new JButton();
		b2 = new JButton();
		b3 = new JButton();
		b4 = new JButton();
		f.add(p);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		b1.setText("Add Task");
		b2.setText("Remove Task");
		b3.setText("Save");
		b4.setText("Load");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		f.setVisible(true);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.pack();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == b1) {
			String i = JOptionPane.showInputDialog("Enter Task");
			td.add(i);
		}
		if (e.getSource() == b2) {
			String l = "";
			for (int i = 0; i < td.size(); i++) {
				l += ("#" + (i + 1) + ": " + td.get(i) + "\n");
			}
			String i = JOptionPane.showInputDialog("Enter Number For Task To Be Removed: \n" + l);
			int r = Integer.parseInt(i);
			td.remove(r - 1);
		}
		if (e.getSource() == b3) {
			File f = new File("src/toDo.txt");
			try {
				FileWriter fw = new FileWriter("src/toDo.txt");

				// fw.write(td);

				fw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource() == b4) {

		}
		System.out.println(td);
	}
}
