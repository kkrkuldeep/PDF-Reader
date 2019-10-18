package PDF_Reader_21July18;

import java.io.*;
import java.io.RandomAccessFile;

public class Pdfdoc {

	private String filename;
	private RandomAccessFile raf;
	private PdfIndex pdi;
	private PdfObjects pdos;

	public Pdfdoc(String str) {
		filename = str;
	}

	public void readPdf() throws IOException {
	
		this.raf = new RandomAccessFile(filename, "r");
		pdi = new PdfIndex(raf);
		pdi.populateIndex();

		pdos = new PdfObjects(raf, pdi);
		pdos.populateObjects();
		
		raf.close();

	}

}
