//Copyright © 2018 by Oliver Nizet

package intro_to_file_io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class CaesarEncrypt {
	public static void main(String[] args) {
		String i = JOptionPane.showInputDialog("Enter Message to Encrypt");
		String k = JOptionPane.showInputDialog("Enter Key for Encryption");
		int ke = Integer.parseInt(k);
		if (ke > 26) {
			int t = ke / 26;
			ke = ke - (26 * t);
		}
		File f = new File("src/encrypted.txt");
		try {
			FileWriter fw = new FileWriter("src/encrypted.txt");

			fw.write(encrypt(i, ke));

			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String encrypt(String in, int key) {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
		StringBuilder input = new StringBuilder(in);
		for (int i = 0; i < input.length(); i++) {
			input.setCharAt(i, shiftedAlphabet.charAt(alphabet.indexOf(input.charAt(i))));
		}
		return input.toString();
	}
}
