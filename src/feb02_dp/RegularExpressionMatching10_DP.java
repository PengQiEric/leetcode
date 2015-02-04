package feb02_dp;


public class RegularExpressionMatching10_DP {
	public boolean isMatch(String s, String p) {
		
		boolean[][] result = new boolean[s.length()+1][p.length()+1];
		result[0][0] = true;
		for(int i=1; i<=s.length(); i++){
			result[i][0] = false;
		}
		for(int j=1; j<=p.length(); j++){
			if(j>1 && p.charAt(j-1) == '*'){
				result[0][j] = result[0][j-2];
			}
		}
		
			for(int j=1; j<=p.length(); j++){ // it's so important that we fill each column from left to right
				for(int i=1; i<=s.length(); i++){ 
					if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.'){
						result[i][j] = result[i-1][j-1];
					}
					else if(p.charAt(j-1) == '*'&& j>1 && (s.charAt(i-1) == p.charAt(j-2)|| p.charAt(j-2)=='.') ){
						result[i][j] = result[i][j-2] 	// * means empty string
								|| result[i-1][j] ;		// * means more than one character
					}
					else if(j>1 && p.charAt(j-1) == '*'){
						result[i][j] = result[i][j-2];
					}
			}
		}
		return result[s.length()][p.length()];
	}
	
	public static void main(String[] args){
		RegularExpressionMatching10_DP test = new RegularExpressionMatching10_DP();
		System.out.println(test.isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c"));
		System.out.println(test.isMatch("aaaaaaaaaaaaac", "a*a*a*a*a*a*a*a*a*a*c"));
	}
}
