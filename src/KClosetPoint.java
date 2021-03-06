import java.util.*;
/*
 * 
 * Find the k closest point to the origin (0,0)
 */
public class KClosetPoint {
	static class Point{
		int x,y;
		Point (int x, int y){
			this.x = x;
			this.y = y;
		}
		public double getDistance() {
			return (Math.pow(x, 2) + Math.pow(y, 2));
		}
	}
	public static void main(String[] args) {
		Point[] arrPoints = new Point[4];
		arrPoints[0] = new Point (-2,4);
		arrPoints [1] = new Point (-1,2);
		arrPoints [2] = new Point (0,3);
		arrPoints [3] = new Point (2,0);
		int k = 2; // indicates how many closest points to get
		List<Point> ans = getKClosetPointsFrmOrigin(arrPoints,k);
		for(Point p : ans) {
			System.out.println("K closest points to the origin are "+p.x +" y "+p.y);
		}
	}

	public static List<Point> getKClosetPointsFrmOrigin(Point[] arrPoints, int k){
		PriorityQueue<Point> minHeapDist = new PriorityQueue<Point>(k, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				double d1 = getDistance(o1.x,o1.y);
				double d2 = getDistance (o2.x,o2.y);
				return  (d2-d1 >0)? 1:-1;
			}
				
		
		});
		double dist =0.0;
		for (int i = 0 ;i <arrPoints.length;i++) {
			//dist = Math.pow(arrPoints[i].x, 2) + Math.pow(arrPoints[i].y, 2);
			minHeapDist.offer(arrPoints[i]);
			if(i >=k) {
				minHeapDist.poll();
			}
		}
		List<Point> ans = new ArrayList<Point>();
		for(Point p : minHeapDist) {
			ans.add(p);
		}
		return ans;
		
	}
	public static double getDistance(int x, int y) {
		return Math.pow(x*x, 2) + Math.pow(y*y, 2);
	}
}
