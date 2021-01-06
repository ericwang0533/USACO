import java.util.*;
import java.awt.Point;
import java.io.*;
public class stuck_in_a_rut {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> eastCows = new ArrayList<>();
        List<Integer> northCows = new ArrayList<>();
        int n = in.nextInt();
        int[] xs = new int[n];
        int[] ys = new int[n];
        for (int j = 0; j < n; j++) {
            if (in.next().charAt(0) == 'E') {
                eastCows.add(j);
            } else {
                northCows.add(j);
            }
            xs[j] = in.nextInt();
            ys[j] = in.nextInt();
        }
        eastCows.sort(Comparator.comparingInt(j -> ys[j]));
        northCows.sort(Comparator.comparingInt(j -> xs[j]));
        boolean[] isStopped = new boolean[n];
        int[] amtStopped = new int[n];
        for (int j : eastCows) {
            for (int k : northCows) {
                if (!isStopped[j] && !isStopped[k] && xs[k] > xs[j] && ys[j] > ys[k]) {
                    if (xs[k] - xs[j] > ys[j] - ys[k]) {
                        isStopped[j] = true;
                        amtStopped[k] += 1 + amtStopped[j];
                    } else if (ys[j] - ys[k] > xs[k] - xs[j]) {
                        isStopped[k] = true;
                        amtStopped[j] += 1 + amtStopped[k];
                    }
                }
            }
        }
        for (int j = 0; j < n; j++) {
            System.out.println(amtStopped[j]);
        }
    }
}
//public class stuck_in_a_rut {
//	public static BufferedReader br;
//	public static StringTokenizer st;
//	public static FastReader in = new FastReader();
//	public static PrintWriter out;
//	
//	public static int n = in.nextInt();
//	public static ArrayList<coord> north = new ArrayList<coord>();
//	public static ArrayList<coord> east = new ArrayList<coord>();
//	
//	public static int[] ans = new int[n];
//	
//	public static void main(String[] args) throws IOException{
//		out = new PrintWriter(System.out);
//		input();
//		// System.out.println();
//		check_norths();
//		// System.out.println(Arrays.toString(north.toArray()));
//		// System.out.println();
//		check_easts();
//		check_norths2();
//		
//		for(int i = 0; i < n; i++) {
//			out.println(ans[i]);
//		}
//		
//		// System.out.println();
//		 System.out.println(Arrays.toString(north.toArray()));
//		 System.out.println(Arrays.toString(east.toArray()));
//		out.close();
//	}
//	
//	public static void check_norths2() {
//		for(int i = 0; i < north.size(); i++) {
//			if(north.get(i).stoppedBy != -1) {
//				
//				if(east.get(north.get(i).arrOrder).stoppedBy != -1) {
//					
//					
//					
//				}
//				
//			}
//		}
//	}
//	
//	public static void check_easts() {
//		// TODO Auto-generated method stub
//		ListIterator iter = east.listIterator();
//		
//		while(iter.hasNext()) {
//			coord eastCoord = (coord) iter.next();
//			Point eastPt = eastCoord.point;
////			// System.out.println(cord.toString());
//			
//			ListIterator northItr = north.listIterator();
//			int ind = -1;
//			int arrOrder = -1;
//			int x = Integer.MAX_VALUE;
////			// System.out.println();
////			// System.out.println(eastCoord.toString());
//			while(northItr.hasNext()) {
//				coord northCoord = (coord) northItr.next();
//				Point northPt = northCoord.point;
//				Point northEnd = northCoord.end;
//				// System.out.println(northCoord.toString());
////				if(eastPt.x > northPt.x) {
////					break;
////				}
////				// System.out.println(northCoord.toString());
//				
//				if(northCoord.stoppedBy != -1) {
//					if(northEnd.y < eastPt.y || northEnd.x < eastPt.x) {
//						continue;
//					}
//				}
//				else {
//					if(northEnd.x > eastPt.y || northEnd.x < eastPt.x) {
//						continue;
//					}
//				}
//				
////				if((northEnd.y > eastPt.y) || (northEnd.x < eastPt.x ) ) {//|| eastCoord.stoppedBy != -1 || northCoord.stoppedBy != -1) {
////					continue;
////				}
////				if((northPt.y > eastPt.y) || (northPt.x < eastPt.x ) ) {//|| eastCoord.stoppedBy != -1 || northCoord.stoppedBy != -1) {
////					continue;
////				}
//				
////				// System.out.println(northCoord.toString());
////				// System.out.println("1");
//				
//				// check if this stops northPt
//				// interset pt is y of east and x of north
//				// check dist of (northx - eastx) vs (easty - northy)
//					// conditional on the lines to interesect ...
//				
////				// System.out.println("deltax: " + (northEnd.x - eastPt.x));
////				// System.out.println("deltay: " + (eastPt.y - northEnd.y));
//				if((northPt.x - eastPt.x) > (eastPt.y - northPt.y)) {
//					
////					if(north) {
////						
////					}
//					
////					// System.out.println("!");
//					if(northPt.x < x) {
//						x = northPt.x;
//						ind = northCoord.ind;
//						arrOrder = northCoord.arrOrder;
//					}
//				}
//			}
//			
//			if(ind != -1) {
//				ans[ind]++;			
//				if(north.get(arrOrder).stoppedBy != -1) {
//					ans[north.get(arrOrder).stoppedBy]++;
//				}
//				eastCoord.stoppedBy = ind;
//				eastCoord.end.x = x;
//				// System.out.println(eastCoord.toString());
//			}
//		}
//		
//		// System.out.println(Arrays.toString(ans));
//	}
//
//	public static void check_norths() {
//		// TODO Auto-generated method stub
//		ListIterator iter = north.listIterator();
//		
//		while(iter.hasNext()) {
//			coord northCoord = (coord) iter.next();
//			Point northPt = northCoord.point;
////			// System.out.println(cord.toString());
//			
//			ListIterator eastItr = east.listIterator();
//			int ind = -1;
//			int y = Integer.MAX_VALUE;
//			int arrOrder = -1;
////			// System.out.println();
//			while(eastItr.hasNext()) {
//				coord eastCoord = (coord) eastItr.next();
//				Point eastPt = eastCoord.point;
//				if(eastPt.x > northPt.x) {
//					break;
//				}
//				
//				if((eastPt.y < northPt.y)) { //|| eastCoord.stoppedBy != -1 || northCoord.stoppedBy != -1) {
//					continue;
//				}
//				
////				// System.out.println(eastCoord.toString());
////				// System.out.println("1");
//				
//				// check if this stops northPt
//				// interset pt is y of east and x of north
//				// check dist of (northx - eastx) vs (easty - northy)
//					// conditional on the lines to interesect ...
//				
////				// System.out.println("deltax: " + (northPt.x - eastPt.x));
////				// System.out.println("deltay: " + (eastPt.y - northPt.y));
//				if((northPt.x - eastPt.x) < (eastPt.y - northPt.y)) {
////					// System.out.println("!");
//					if(eastPt.y < y) {
//						y = eastPt.y;
//						ind = eastCoord.ind;
//						arrOrder = eastCoord.arrOrder;
//					}
//				}
//			}
//			
//			if(ind != -1) {
//				ans[ind]++;			
//				northCoord.stoppedBy = ind;
//				northCoord.end.y = y;
//				northCoord.arrOrder = arrOrder;
//			}
//		}
//		
////		// System.out.println(Arrays.toString(ans));
//	}
//
//	public static void input() {
//		// TODO Auto-generated method stub
//		int counterN = 0;
//		int counterE = 0;
//		for(int i = 0; i < n; i++) {
//			if(in.next().charAt(0) == 'N') {
//				north.add(new coord('N', in.nextInt(), in.nextInt(), i, counterN));				
//				counterN++;
//			}
//			else {
//				east.add(new coord('E', in.nextInt(), in.nextInt(), i, counterE));								
//				counterE++;
//			}
////			// System.out.println(coords[i].toString());
//		}
//		
//		Collections.sort(north, new sortByX());
//		Collections.sort(east, new sortByX());
//		
//		//dbg
//		for(int i = 0; i < north.size(); i++) {
//			// System.out.println(north.get(i).toString());
//		}
//
//		for(int i = 0; i < east.size(); i++) {
//			// System.out.println(east.get(i).toString());
//		}
//	}
//
//	static class coord{
//		char direct;
//		Point point;
//		int ind;
//		int stoppedBy;
//		Point end;
//		int arrOrder;
//		
//		public coord(char direct, int x, int y, int ind, int arrOrder) {
//			this.direct = direct;
//			this.ind = ind;
//			point = new Point(x, y);
//			end = new Point(point);
//			stoppedBy = -1;
//			this.arrOrder = arrOrder;
//		}
//		
//		public String toString() {
//			return arrOrder + ": " +  ind + ": " + direct + " (" + point.x + ", " + point.y + ") stoppedBy: " + stoppedBy + " at (" + end.x + ", " + end.y + ")";
//		}
//	}
//	
//	static class sortByX implements Comparator<coord>{
//		public int compare(coord o1, coord o2) {
//			// TODO Auto-generated method stub
//			if(o1.point.x < o2.point.x) {
//				return -1;
//			}
//			else if(o1.point.x > o2.point.x){
//				return 1;
//			}
//			else {
//				if(o1.point.y < o2.point.y) {
//					return -1;
//				}
//				else if(o1.point.y > o2.point.y) {
//					return 1;
//				}
//				else {
//					return 0;						
//				}
//			}
//			
//		}
//		
//	}
//	
//	static class FastReader{
//		public FastReader() {
//			br = new BufferedReader(new InputStreamReader(System.in));
//		}
//		String next() {
//			while(st == null || !st.hasMoreElements()) {
//				try {
//					st = new StringTokenizer(br.readLine());
//				}
//				catch(IOException e) {
//					e.printStackTrace();
//				}
//			}
//			return st.nextToken();
//		}
//		int nextInt() {
//			return Integer.parseInt(next());
//		}
//		double nextDouble() {
//			return Double.parseDouble(next());
//		}
//		long nextLong() {
//			return Long.parseLong(next());
//		}
//		String nextLine() {
//			String str = "";
//			try {
//				str = br.readLine();
//			}
//			catch(IOException e) {
//				e.printStackTrace();
//			}
//			return str;
//		}
//	}
//}
