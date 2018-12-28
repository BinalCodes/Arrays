import java.util.*;
/*
 * 
 * Find the k closest point to the origin (0,0)
 */
public class KClosetPoint {
	class Point{
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
		Point [] arrPoints = new Point[4];
		arrPoints[0] = new Point (-2,4);
		arrPoints [1] = new Point (-1,2);
		arrPoints [2] = new Point (0,3);
		arrPoints [3] = new Point (2,0);
		int k = 2; // indicates how many closest points to get
		System.out.println("K closes points to the origin are "+getKClosetPointsFrmOrigin(arrPoints));
		
	}

	public static void getKClosetPointsFrmOrigin(Point[] arrPoints, int k){
		PriorityQueue<Point> minHeapDist = new PriorityQueue<Point>(k, new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				return (Point) (o2.x - o1.x) ;
			}
				
		
		});
		double dist =0.0;
		for (int i = 0 ;i <arrPoints.length;i++) {
			dist = Math.pow(arrPoints[i].x, 2) + Math.pow(arrPoints[i].y, 2);
			minHeapDist.offer(dist);
		}
		
		
	}
}
