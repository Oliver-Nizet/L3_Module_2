//Copyright © 2018 by Oliver Nizet

package intro_to_file_io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Copyright {
	public static void main(String[] args) {
		File f = new File("src");
		Copyright cr = new Copyright();
		cr.add(f);
	}

	Copyright() {

	}

	public void add(File f) {
		if (f.isFile()) {
			if (f.getName().endsWith(".java")) {
				String crm = "//Copyright © 2018 by Oliver Nizet\n\n";
				crm += readToString(f);
				writeFile(crm, f);
			}
		} else {
			for (File child : f.listFiles()) {
				add(child);
			}
		}
	}

	public static String readToString(File f) {
		StringBuilder sb = new StringBuilder();
		try {
			FileReader fr = new FileReader(f);
			int c = fr.read();
			while (c != -1) {
				sb.append((char) c);
				c = fr.read();

			}
			fr.close();
			return sb.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void writeFile(String content, File f) {
		try {
			FileWriter fw = new FileWriter(f);
			fw.write(content);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
