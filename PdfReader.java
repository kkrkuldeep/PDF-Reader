package PDF_Reader_21July18;

import java.io.IOException;
import java.util.Scanner;

public class PdfReader {

	public static void main(String[] args) throws IOException {

		Scanner sn = new Scanner(System.in);

		System.out.println("Enter the path of your file : ");
		String str = sn.next();
		sn.close();

		Pdfdoc pdoc = new Pdfdoc(str);
		pdoc.readPdf();
	}
}

// 			Output: C:\Users\kkrku\Desktop\hello.txt
