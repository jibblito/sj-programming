import java.util.Scanner;
import java.awt.Point;
import java.awt.Graphics;

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

		FloatPoint a = new FloatPoint(ax,ay);
		FloatPoint b = new FloatPoint(bx,by);
		FloatPoint c = new FloatPoint(cx,cy);

		System.out.println("\nSection 1: Input-based");
		Line linAB = new Line(a,b);
		Line linBC = new Line(b,c);
		Line linAC = new Line(a,c);
		System.out.println(linAB.getEquation());
		System.out.println(linBC.getEquation());
		System.out.println(linAC.getEquation());

		System.out.println("\nSection 2: Triangle Object");
		Triangle tr = new Triangle(new Pair(a,av),new Pair(b,bv),new Pair(c,cv));
		System.out.println(tr.catString());
		tr.sortPoints(0);
		System.out.println(tr.catString());
		
	}	
	
}

class Triangle {
	
	private Pair a, b, c;
	private Line linAB, linBC, linAC;
	private Pair[] pairs = new Pair[3];

	public Triangle(Pair a, Pair b, Pair c) {
		this.a = a; this.b = b; this.c = c;
		pairs = new Pair[]{this.a,this.b,this.c};
		this.generateLines();
	}

	public void sortPoints(int start) {
		if (start == 2) return;
		Pair max = new Pair(new FloatPoint(0,0),0.0f);
		int maxInd = 0;
		for(int i = start; i < pairs.length; i++) {
			if(pairs[i].getPoint().y >= max.getPoint().y) {
				max = pairs[i];
				maxInd = i;
			}
		}

		Pair temp = pairs[start];
		pairs[start] = max;
		pairs[maxInd] = temp;
		sortPoints(start + 1);
		generateLines();
	}

	public String catString() {
		String ret = "A: " +pairs[0].catPair()+"\nB: " +pairs[1].catPair()+ "\nC: " +pairs[2].catPair();
		ret += "\nAB: " +linAB.getEquation()+ "\nBC: " +linBC.getEquation()+ "\nAC: " +linAC.getEquation();
		return ret;
	

	public void generateLines() {
		linAB = new Line(pairs[0].getPoint(),pairs[1].getPoint());
		linBC = new Line(pairs[1].getPoint(),pairs[2].getPoint());
		linAC = new Line(pairs[0].getPoint(),pairs[2].getPoint());
	}

	public void drawPoint(Pair pair, Float val,Graphics g) {
		FloatPoint p = pair.getPoint();
		g.drawLine((int)p.x,(int)p.y,(int)p.x,(int)p.y);
	}

	public Line[] getLines() {
		return new Line[]{linAB,linBC,linAC};
	}

}

class Pair {
	private FloatPoint p;
	private float val;	

	public Pair(FloatPoint p, Float val) {
		this.p = p;
		this.val = val;
	}

	public FloatPoint getPoint() {
		return p;
	}
	public void setPoint(FloatPoint p) {
		this.p = p;
	}

	public Float getVal() {
		return val;
	}

	public void drawPoint(Graphics g) {
		g.drawLine((int)p.x,(int)p.y,(int)p.x,(int)p.y);
	}

	public String catPair() {
		return "x: "+p.x+" y: "+p.y+" val: "+val;
	}

}

class Line {
	
	FloatPoint a;
	FloatPoint b;
	float slope;
	int intercept;

	public Line(FloatPoint a, FloatPoint b) {
		this.a = a;
		this.b = b;
		this.generateEquation();
	}


	void generateEquation() {
		try { slope = (a.y-b.y)/(a.x-b.x);
		} catch (ArithmeticException ae) { System.out.println("Errar!"); }
		intercept = (int)(a.y-slope*a.x);	
	}

	public String getEquation() {
		return "y=" +slope+ "x+" +intercept;
	}
	
	public int getX(int y) {
		return (int)((float)(y-intercept)/slope);
	}

	public int getY(int x) {
		return (int)(slope*(float)x)+intercept;
	}
	
}

class FloatPoint {
	
	public float x, y;

	public FloatPoint(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public FloatPoint(int x, int y) {
		this.x = (float)x;
		this.y = (float)y;
	}

}
