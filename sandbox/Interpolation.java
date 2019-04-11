import java.util.Scanner;
import java.awt.Point;

public class Interpolation {
	
	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Points:");
		int ax = scan.nextInt();
		int ay = scan.nextInt();
		float av = scan.nextFloat();
		int bx = scan.nextInt();
		int by = scan.nextInt();
		float bv = scan.nextFloat();
		int cx = scan.nextInt();
		int cy = scan.nextInt();
		float cv = scan.nextFloat();
		System.out.println();

		Triangle tr = new Triangle(new Pair(new Point(ax,ay),av),new Pair(new Point(bx,by),bv),new Pair(new Point(cx,cy),cv));
		tr.catString();
		tr.sortPoints(0);
		tr.catString();
	}	
	
}

class Triangle {
	
	private Pair a;
	private Pair b;
	private Pair c;
	private Pair[] pairs = new Pair[3];

	public Triangle(Pair a, Pair b, Pair c) {
		this.a = a; this.b = b; this.c = c;
		pairs = new Pair[]{this.a,this.b,this.c};
	}

	public void sortPoints(int start) {
		if (start == 2) return;
		Pair max = new Pair(new Point(0,0),0.0f);
		int maxInd = 0;
		for(int i = start; i < pairs.length; i++) {
			if(pairs[i].getPoint().y > max.getPoint().y) {
				max = pairs[i];
				maxInd = i;
			}
		}

		Pair temp = pairs[start];
		pairs[start] = max;
		pairs[maxInd] = temp;
		sortPoints(start + 1);
	}

	public void catString() {
		System.out.println("A: " + pairs[0].getPoint().y + " " +pairs[0].getVal());
		System.out.println("B: " + pairs[1].getPoint().y + " " + pairs[1].getVal());
		System.out.println("C: " + pairs[2].getPoint().y + " " + pairs[2].getVal());
	}


}

class Pair {
	private Point p;
	private float val;	

	public Pair(Point p, Float val) {
		this.p = p;
		this.val = val;
	}

	public Point getPoint() {
		return p;
	}
	public void setPoint(Point p) {
		this.p = p;
	}

	public Float getVal() {
		return val;
	}
}


