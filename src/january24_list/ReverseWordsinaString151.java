package january24_list;

/**
 * @author PAUL QI
 * 
 * Given an input string, reverse the string word by word.

	For example,
	Given s = "the sky is blue",
	return "blue is sky the".
	
	Clarification:
	What constitutes a word?
	A sequence of non-space characters constitutes a word.
	Could the input string contain leading or trailing spaces?
	Yes. However, your reversed string should not contain leading or trailing spaces.
	How about multiple spaces between two words?
	Reduce them to a single space in the reversed string.
 */

public class ReverseWordsinaString151 {
    
	public String reverseWords(String s) {
		StringBuffer newStr = new StringBuffer();
		int i = s.length()-1;
		while(i>=0&& s.charAt(i)==' ')i--;
		while(i>=0){
			int end = i;
			while(i>=0 && s.charAt(i)!=' ')i--;
			newStr.append(s.substring(i+1,end+1)+" ");
			while(i>=0 && s.charAt(i) == ' ')i--;
		}
		return newStr.length()==0? "":newStr.substring(0, newStr.length()-1).toString();
    }
	
	public static void main(String[] args){
		ReverseWordsinaString151 test = new ReverseWordsinaString151();
		System.out.println(test.reverseWords("       the sky   is   blue    "));
		System.out.println(test.reverseWords("blue"));
		System.out.println(test.reverseWords("blue       "));
	}
}
