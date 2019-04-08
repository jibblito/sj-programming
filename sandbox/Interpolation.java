import java.util.Scanner;
import java.awt.Point;

public class Interpolaton {
	
	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Points:");
		int ax = scan.nextInt;
		int ay = scan.nextInt;
		int bx = scan.nextInt;
		int by = scan.nextInt;
		int cx = scan.nextInt;
		int cy = scan.nextInt;
		System.out.println();

		Triangle tr = new Triangle(new Point(ax,ay), new Point(bx,by), new Point(cx,cy));
		tr.toString();
	}	
	
}

class Triangle {
	
	private Point a;
	private Point b;
	private Point c;
	private Point[] points = new Point[3];

	public Triangle(Point a, Point b, Point c) {
		this.a = a; this.b = b; this.c = c;
		points[3] = {this.a,this.b,this.c};
	}

	public void sortPoints(int start) {
		if (start == 2) return;
		Point max = new Point(0,0);
		int maxInd = 0;

		for(int i = start; i < points.length; i++) {
			if(points[i].y > max.y) {
				max = points[i];
				maxInd = i;
			}
		}
		
		point temp = points[start];
		points[start] = max;
		points[maxInd] = temp;
		sortPoints(start + 1);

	}

	public void toString() {
		System.out.println("Points:\nA: " + points[0].y);
		System.out.println("B: " + points[1].y);
		System.out.println("C: " + points[2].y);
	}


}
