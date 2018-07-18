//Copyright © 2018 by Oliver Nizet

package intro_to_file_io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class CaesarDecrypt {
	public static void main(String[] args) {
		StringBuilder encrypted = new StringBuilder();
		try {
			FileReader fr = new FileReader("src/encrypted.txt");
			int c = fr.read();
			while (c != -1) {
				encrypted.append((char) c);
				c = fr.read();
			}
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String i = encrypted.toString();
		String k = JOptionPane.showInputDialog("Enter Key for Decryption");
		int ke = Integer.parseInt(k);
		if (ke > 26) {
			int t = ke / 26;
			ke = ke - (26 * t);
		}
		ke = 26 - ke;
		JOptionPane.showMessageDialog(null, (decrypt(i, ke)));
	}

	public static String decrypt(String in, int key) {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
		StringBuilder input = new StringBuilder(in);
		for (int i = 0; i < input.length(); i++) {
			input.setCharAt(i, shiftedAlphabet.charAt(alphabet.indexOf(input.charAt(i))));
		}
		return input.toString();
	}
}
