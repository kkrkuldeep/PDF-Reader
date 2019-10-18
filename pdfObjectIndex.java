package PDF_Reader_21July18;

import java.io.*;
import java.util.*;

public class pdfObjectIndex {

	private RandomAccessFile file = null;
	private long xrefindex;
	private ArrayList<PdfIndexElement> idxlist = new ArrayList<PdfIndexElement>();

	public pdfObjectIndex(RandomAccessFile file, long xrefindex) throws IOException {
		this.file = file;
		this.xrefindex = xrefindex;
	}

	public void populateObjIdx() throws IOException {

		String st;
		String countindex = null;

		int count;
		
		file.seek(this.xrefindex);
		st = file.readLine();
		while ((st = file.readLine()) != null) {
			if (st.trim().isEmpty() == false) {
				countindex = st;
				break;
			}
		}
		StringTokenizer token = new StringTokenizer(countindex);

		token.nextToken();
		count = Integer.parseInt(token.nextToken()); // return how many objects are there in a pdf file

		for (int i = 0; i < count; i++) {
			while ((st = file.readLine()) != null) {
				if (st.trim().isEmpty() == false) {
					PdfIndexElement pidx = new PdfIndexElement(st);
					idxlist.add(pidx);
					break;
				}
			}
		}
	}

	public void printIndex() {
		for (int i = 0; i < idxlist.size(); i++) {
			System.out.println(idxlist.get(i));
		}
	}
	
	public ArrayList<PdfIndexElement> getList(){
		return idxlist;
	}

}
