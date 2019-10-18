package PDF_Reader_21July18;

import java.io.IOException;
import java.io.RandomAccessFile;

public class PdfObject {

	private RandomAccessFile file = null;
	private long position;
	private int storeLength;
	private StringBuilder so = new StringBuilder();

	public PdfObject(RandomAccessFile file, long position) throws IOException {
		this.file = file;
		this.position = position;
		populateObject();
		printObjects();
	}

	public void populateObject() throws IOException {

		String st;
		String endobj = "endobj";
		String startPoint = "%PDF";

		int size = 0;

		file.seek(position);

		while ((st = file.readLine()) != null) {
			if (st.startsWith(startPoint)) {
				break;
			}
			if (st.equals(endobj)) {
				so.append(st + "\n");
				size += st.length();
				storeLength = size;
				break;
			} else {
				size += st.length();
				so.append(st + "\n");

			}
		}
	}

	public void printObjects() {
		System.out.println(so);
		System.out.println(storeLength);
	}

}
