package javau;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class Files {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("D:" + File.separator + "helloword.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OutputStream o = new FileOutputStream(file);
		String s = "I love You";
		o.write(s.getBytes());
		o.close();
		OutputStream oo = new FileOutputStream(file, true);
		String ss = "LvTingYu";
		oo.write(ss.getBytes());
		oo.close();
		InputStream in = new FileInputStream(file);
		byte[] b = new byte[1024];
		int temp = 0;
		int count = 0;
		while ((temp = in.read()) != -1) {
			b[count++] = (byte) temp;
		}
		System.out.println(new String(b));
		in.close();
		Writer out = new FileWriter(file, true);
		String str = "not at all";
		out.write(str);
		out.close();
		char[] ch = new char[100];
		Reader r = new FileReader(file);
		int count1 = r.read(ch);
		r.close();
		System.out.println(new String(ch, 0, count1));
	}
}
