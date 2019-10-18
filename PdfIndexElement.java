package PDF_Reader_21July18;

import java.util.StringTokenizer;

public class PdfIndexElement {

	private long position;
	private int revision;
	private char state;

	public PdfIndexElement(String str) {

		StringTokenizer token = new StringTokenizer(str, " ");

		position=Long.parseLong(token.nextToken());
		revision=Integer.parseInt(token.nextToken());
		state=token.nextToken().charAt(0);
		
	}
	
	public String toString() {
		String str=new String();
		str=str+"Position => "+this.position+"\t"+" Revision=> "+this.revision+"\t"+" State=> "+this.state+"\t"+"\n";
		 return str;
	}
	
	public long getPosition() {
		return this.position;
	}
	
	
}
