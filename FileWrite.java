package zen;
import java.io.*;

public class FileWrite {
	
	public static void writeFile(long gbLength, String randDomain, FileWriter fw) throws Exception{
		
		for(long i=0;i<gbLength;i++) {
			String str="";
			int index = (int)(randDomain.length() * Math.random());
			str += randDomain.charAt(index);
			index = (int)(randDomain.length() * Math.random());
			str += randDomain.charAt(index);
			index = (int)(randDomain.length() * Math.random());
			str += randDomain.charAt(index);
			fw.write(str);
		}
	}
	
	public static StringBuilder readFileChars(FileReader fr, int charsReq) throws Exception{
		StringBuilder str= new StringBuilder("");
		BufferedReader br = new BufferedReader(fr);
		for(int i=0;i<charsReq;i++) {
			int ch = 0;
			if( (ch = br.read() ) != -1) {
				str.append( (char)ch );
			}
			else 
				break;
		}
		
		return str;
	}
	
	public static void main(String[] args) {
		FindSubString fss = new FindSubString();
		
		
		long gbLength = 1000000; //Number of characters in 1 GB
		int charsReq = 3000; //No. of chars to be read from file = 3000
		
		String fileDomain = "abcdefghijklmnopqrstuvxyz";
		try {
			FileWriter fw = new FileWriter("data.txt");
			writeFile(gbLength, fileDomain, fw);
			fw.close();
		}
		catch(Exception e ) {
			System.out.println(e);
		}
		System.out.println("File written successfully");
		StringBuilder reqString = new StringBuilder("");
		try {
			FileReader fr=new FileReader("data.txt");
			reqString = readFileChars(fr, charsReq);
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		StringBuilder answer = fss.findSub(new StringBuilder("asdasdadasd"));
		System.out.println(answer);
	}

}
