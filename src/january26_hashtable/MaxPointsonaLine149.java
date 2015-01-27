package january26_hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author PAUL QI 
 * Given n points on a 2D plane, find the maximum number of
 * points that lie on the same straight line.
 */

public class MaxPointsonaLine149 {
	public int maxPoints(Point[] points) {
		if(points.length<3){
			return points.length;
		}
		
		int result = 2;
		for(int i=0; i<points.length-2; i++){
			Map<Double,Integer> scope = new HashMap<Double, Integer>();
			int max = 0;
			int same = 1;
			for(int j=i+1; j<points.length; j++){      //[(0,0),(1,1),(0,0)]
				if(points[i].x == points[j].x && points[i].y == points[j].y){
					same++;
				}
				else if(points[i].x == points[j].x){
					if(scope.containsKey(Double.MAX_VALUE)){
						int num = scope.get(Double.MAX_VALUE);
						scope.put(Double.MAX_VALUE, ++num);
						max = Math.max(max, num);
					}
					else{
						scope.put(Double.MAX_VALUE, 1);
						max = Math.max(max, 1);
					}
				}
				else{
					double scop = (double)(points[j].y-points[i].y)/(points[j].x - points[i].x);
					if(scop == -0.0){
						scop = 0.0;
					}
					if(scope.containsKey(scop)){
						int num = scope.get(scop);
						scope.put(scop,++num);
						max = Math.max(max, num);
					}
					else{
						scope.put(scop, 1);
						max = Math.max(max, 1);
					}
				}
			}
			result = Math.max(result, max+same);
		}
		return result;
	}
	
	public static void main(String[] args){
		MaxPointsonaLine149 test = new MaxPointsonaLine149();
		System.out.println(test.maxPoints(new Point[]{new Point(4,0), new Point(4,-1), new Point(4,3)}));
	}
}


class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}