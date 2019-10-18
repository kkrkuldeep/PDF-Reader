package PDF_Reader_21July18;

import java.io.*;

public class PdfIndex {

	private pdfObjectIndex index;
	private RandomAccessFile file = null;
	private long refindexpos;

	public pdfObjectIndex getIndex() {
		return index;
	}

	public void setIndex(pdfObjectIndex index) {
		this.index = index;
	}

	public PdfIndex(RandomAccessFile file) throws IOException {
		this.file = file;
		this.refindexpos = getxref();
		this.index = new pdfObjectIndex(file, refindexpos);
	}

	public long getxref() throws IOException {

		long refindex = 0;
		String st;
		String xref = "startxref";

		while ((st = file.readLine()) != null) {
			if (st.equals(xref)) {
				while ((st = file.readLine()) != null) {
					if (st.trim().isEmpty() == false) {
						refindex = Long.valueOf(st);
						break;
					}
				}
				break;
			}
		}
		return refindex;
	}

	public void populateIndex() throws IOException {
		index.populateObjIdx();
		index.printIndex();
	}

}
