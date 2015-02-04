package feb02_dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PAUL QI
 * Given two strings, S of length m and T of length n, 
 * find the longest strings which are substrings of both S and T.

	A generalisation is the k-common substring problem. Given the set of strings 
	S = \{S_1, ..., S_K\}, where |S_i|=n_i and \Sigma n_i = N. Find for each 2 \leq k \leq K, 
	the longest strings which occur as substrings of at least k strings.
 */

public class Longestcommonsubstring {
	// more fancy soultion is using suffix tree, and the time complexity will be O(n+m)
	
	// first DP solution, basically it's two dimension DP	O(n^2) time O(n^2) space
	public List<String> longestCommon(String s, String t){
		int[][] common =  new int[s.length()][t.length()];
		List<String> rs =  new ArrayList<String>();
		int z = 0;
		
		// LSSuff(S1..i, T1..j) = LSSuff(S1...i-1, Ti...j-1) + 1 if S[i] = T[j]
		//								else 0; 
		
		for(int i=0; i<s.length(); i++){
			for(int j=0; j<t.length(); j++){
				if(s.charAt(i) == t.charAt(j)){
					if(i == 0 || j == 0){
						common[i][j] = 1;
					}
					else{
						common[i][j] = common[i-1][j-1]+1;
					}
					
					if(common[i][j]>z){
						z = common[i][j];
						rs.clear();
						rs.add(s.substring(i-common[i][j]+1,i+1));
					}
					if(common[i][j] == z){
						rs.add(s.substring(i-common[i][j]+1,i+1));
					}
				}
				else{
					common[i][j] = 0;
				}
			}
		}
		return rs;
	}
	
	
	public static void main(String[] args){
		Longestcommonsubstring test = new Longestcommonsubstring();
//		List<String> rs =  test.longestCommon("abababab", "abac");
		List<String> rs =  test.longestCommon("ababc", "babca");
		for(String s: rs){
			System.out.print(s+" ");
		}
	}
}
