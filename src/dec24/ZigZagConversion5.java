package dec24;

import com.sun.media.jai.opimage.RescaleCRIF;

/**
 * @author Paul Qi
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility)
 * 	P   A   H   N
 * 	A P L S I I G
 * 	Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */

public class ZigZagConversion5 {
	/*
	 * A	 G    
	 * B   F H
	 * C E	 I
	 * D	 K
	 * 
	 * A	   I
	 * B	 H J
	 * C   G   K
	 * D F     L N
	 * E       M
	 * 	P   A   H   N
	 * 	A P L S I I G
	 * 	Y   I   R
	 * every nRows*2-2 is a group, and then the group repeats again and again. But based on this rule, 
	 * I think I need some containers to hold those characters.
	 */
	//precondition: nRows >= 2
	public static String convert(String s, int nRows){
		if(nRows == 1){
			return s;
		}
		StringBuffer result= new StringBuffer();
		for(int i=0; i<nRows; i++){
			if(i==0 || i==(nRows-1)){
				for(int j=i;j<s.length(); j+=nRows*2-2){
					result.append(s.charAt(j));
				}
			}
			else{
				for(int j=i;j<s.length();j+=nRows*2-2){
					result.append(s.charAt(j));
					// nRows*2-i-2
					if((j+ nRows*2-2-(2*i-1+2) +1)<s.length()){
						result.append(s.charAt(j+ nRows*2-2-(2*i-1+2) +1));
					}
				}
			}
		}
		return result.toString();
	}
	
	public static void main(String[] args){
		System.out.println(convert("PAYPALISHIRING", 3));
		System.out.println(convert("AB", 1));
		System.out.println(convert("ABCD", 2));
		System.out.println(convert("ABCDEF", 4));
	}
}
