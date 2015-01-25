//Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if(points==null || points.length==0)
            return 0;
        Map<Double, Integer> map = new HashMap<Double, Integer>();
        int count=0;
        for(int i=0; i<points.length; i++){
            map.clear();
            int samePoint = 0, sameSlope = 1;
            for(int j=i+1; j<points.length; j++){
                double slope = Double.MAX_VALUE;
                if(points[i].x!=points[j].x){
                    slope = 1.0*(points[i].y-points[j].y)/(points[i].x-points[j].x);
                }else if(points[i].y==points[j].y){
                    samePoint++;
                    continue;
                }
                int tmp=0;
                if(slope==-0.0)
                	slope = 0.0;
                if(!map.containsKey(slope)){
                    tmp = 2;
                    map.put(slope, 2);
                }else{
                    tmp = map.get(slope)+1;
                    map.put(slope, tmp);
                }
                if(tmp>sameSlope)
                    sameSlope = tmp;
            }
            if(sameSlope+samePoint>count)
                count = sameSlope+samePoint;
        }
        return count;
    }
}
