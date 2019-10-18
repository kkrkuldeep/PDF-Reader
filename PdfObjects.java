package PDF_Reader_21July18;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class PdfObjects {

	private PdfIndex pdi;
	private pdfObjectIndex poi;
	private RandomAccessFile file;
	private ArrayList<PdfObject> objectList=new ArrayList<PdfObject>();

	public PdfObjects(RandomAccessFile file, PdfIndex pdi) {
		this.file = file;
		this.pdi = pdi;
		poi = this.pdi.getIndex();
	}

	public void populateObjects() throws IOException {

		ArrayList<PdfIndexElement> indexes;
		indexes = poi.getList();

		for (int i = 0; i < indexes.size(); i++) {
			
			long position = indexes.get(i).getPosition();
			PdfObject pdo = new PdfObject(file, position);
			objectList.add(pdo);
		}
		
		
	}

}
