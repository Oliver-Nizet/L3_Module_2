package intro_to_file_io;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	JLabel l;

	public static void main(String[] args) {
		ToDoListTracker tdlt = new ToDoListTracker();
	}

	ArrayList<String> td = new ArrayList<String>();

	ToDoListTracker() {
		loads();
		f = new JFrame();
		p = new JPanel();
		b1 = new JButton();
		b2 = new JButton();
		b3 = new JButton();
		b4 = new JButton();
		l = new JLabel();
		f.add(p);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		p.add(l);
		b1.setText("Add Task");
		b2.setText("Remove Task");
		b3.setText("Save");
		b4.setText("Load");
		for (String as : td) {
			l.setText(l.getText() + as + "\n");
		}
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
				for (String h : td) {
					fw.write(h + "\n");
				}
				fw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource() == b4) {
			loads();
		}
		for (String as : td) {
			l.setText(l + as + "\n");
		}
	}

	private void loads() {
		StringBuilder ld = new StringBuilder();
		try {
			FileReader fr = new FileReader("src/toDo.txt");
			int c = fr.read();
			while (c != -1) {
				ld.append((char) c);
				c = fr.read();
			}
			fr.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		String[] array = ld.toString().split("\n");
		td.clear();
		for (String li : array) {
			td.add(li);
		}
	}
}
