package aNext.first.feb21;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PAUL QI
 * 
 *  Given an array of words and a length L, format the text such that each line has exactly 
 *  L characters and is fully (left and right) justified.

	You should pack your words in a greedy approach; that is, pack as many words as you can in each line. 
	Pad extra spaces ' ' when necessary so that each line has exactly L characters.
	
	Extra spaces between words should be distributed as evenly as possible. 
	If the number of spaces on a line do not divide evenly between words, 
	the empty slots on the left will be assigned more spaces than the slots on the right.
	
	For the last line of text, it should be left justified and no extra space is inserted between words.
	
	For example,
	words: ["This", "is", "an", "example", "of", "text", "justification."]
	L: 16.
	
	Return the formatted lines as:
	[
	   "This    is    an",
	   "example  of text",
	   "justification.  "
	]
	Note: Each word is guaranteed not to exceed L in length.
	
	Corner Cases:
	A line other than the last line might contain only one word. What should you do in this case?
	In this case, that line should be left-justified.
 */

public class TextJustification68 {
	public static void main(String[] args){
		TextJustification68 test = new TextJustification68();
//		List<String> re = test.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
		List<String> re = test.fullJustify(new String[]{"a","b","c","d","e"}, 1);
		for(String s: re){
			System.out.println(s+s.length());
		}
	}
	
    public List<String> fullJustify(String[] words, int L) {
        List<String> re = new ArrayList<String>();
        int start = 0;
        int end = 0;
        int count = 0;
        while(end<words.length){
        	count += words[end++].length();
        	while(end< words.length && count<=L){	// at least into one time
        		count += words[end].length()+1;
        		if(count<=L){
        			end++;
        		}
        	}
        	StringBuffer sb = new StringBuffer();
        	if(end == words.length){
        		sb.append(words[start++]);
        		while(start<end){
        			sb.append(" "+words[start++]);
        		}
        		for(int i=sb.length()+1; i<=L; i++){
        			sb.append(" ");
        		}
        		re.add(sb.toString());
        	}
        	else{
        		count = count-(words[end].length()+(end-start));
        		if(end-start == 1){
        			int space = L-count;
        			sb.append(words[start]);
        			for(int i=0;i<space; i++){
        				sb.append(" ");
        			}
        			re.add(sb.toString());
        		}
        		else{
        			int dis = (L-count)/(end-start-1);
        			int extra = (L-count)%(end-start-1);
        			int begin = start;
        			while(start<end){
        				if(start == end-1){
        					sb.append(words[start]);
        				}
        				else{
        					sb.append(words[start]);
        					if(start<begin+extra){
        						for(int i=1; i<=dis+1; i++){
        							sb.append(" ");
        						}
        					}
        					else{
        						for(int i=1; i<=dis; i++){
        							sb.append(" ");
        						}
        					}
        				}
        				start++;
        			}
        			re.add(sb.toString());
        		}
        		start = end;
        		count = 0;
        	}
        }
        return re;
    }
}
