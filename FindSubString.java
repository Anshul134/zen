package zen;
import java.util.*;

public class FindSubString {
	public StringBuilder findSub(StringBuilder str) {
		int len = str.length();
		
		Map<StringBuilder, Integer> mp = new HashMap<StringBuilder, Integer>();
		
		for (int i = 0; i < len; i++) { 
			StringBuilder s = new StringBuilder(""); 
	        //mp.put(s, new Integer(0) );
	        for (int j = i; j < len; j++) { 
	            s.append( str.charAt(j) ); 
	            System.out.println(s);
	            if(mp.get(s) != null) {
	            	//System.out.println(s + " " + mp.get(s) + " " +(s.equals(s.substring(i,  j) ) ) ) ;
	            	Integer val = mp.get(s);
	            	//System.out.println(s + " " + val);
	            	mp.remove(s);
	            	mp.put(s, val+1 ); 
	            }
	            else
	            	mp.put(s, new Integer(1) );
	        } 
	    } 
		
		
		
		StringBuilder s=new StringBuilder("");
		
		double maxVal = 0;
		for(Map.Entry m : mp.entrySet() ) {
			StringBuilder key  = (StringBuilder)m.getKey();
			double funcVal = Math.pow( key.length(), 2) * Math.pow((Integer)(m.getValue() ) - 1, 1/3) ;
			if(funcVal > maxVal) {
				s = (StringBuilder)m.getKey();
				maxVal = funcVal;
			}
		}
		
		System.out.println(mp.get(s));
	return s;	 
	}
}
