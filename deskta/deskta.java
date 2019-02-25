import java.io.*;
import java.awt.image.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.lang.Math;

class deskta {
	public static void main(String[] args) {

		BufferedImage image = new BufferedImage(1920,1080, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();

		double re = 0;
		double gr = 0;
		double bl = 0;
		int x = 0;
		double y = 0;

		/*
		while(x < 1920) {
			double temp = (double)x/1920.0d;	
			y = temp*1080.0d;
			re = temp*255.0d;
			gr = temp*255.0d;
			bl = temp*255.0d;
			
			g.setColor(new Color((int)re,(int)gr,(int)bl));
			g.drawLine(0,(int)y,x,0);
			x+=1;
		}
		while(x >= 0) {
			double temp = (double)x/900.0d;	
			y = temp*1080.0d;
			re = (1.0d-temp)*255.0d;
			gr = (1.0d-temp)*255.0d;
			bl = (1.0d-temp)*255.0d;
			
			g.setColor(new Color((int)re,(int)gr,(int)bl));
			g.drawLine(x,1080,1920,(int)y);
			x-=1;
		}
		*/

		int divisor = 35;

		for(int i = 0; i < divisor + 1; i++) {
			for(int j = 0; j < divisor + 1; j++) {
				int ti = 1920/divisor;
				int tj = 1080/divisor;
				Quadrilateral tquad = new Quadrilateral(ti*i,tj*j,ti*i+1920/divisor,
									tj*j+1080/divisor, g);
				
				double perc = (double)(j+i)/(double)(divisor*2);
				if(i==j) System.out.println(perc*100.0d);

				tquad.fillRect(new Color((int)(255.0d*perc),(int)(255.0d*perc),(int)(255.0d*perc)));

				//tquad.fillGradient(new Color((int)(255.0d*perc),(int)(255.0d*perc),(int)(255.0d*perc)),new Color(255,255,255));
			}
		}

		Quadrilateral quad = new Quadrilateral(50,50,500,700, g);
		quad.details();
		quad.fillGradient(Color.RED,Color.YELLOW);
		Quadrilateral quad2 = new Quadrilateral(550,50,1050,700, g);
		quad2.details();
		quad2.fillGradient(Color.BLUE,Color.BLACK);
		g.setColor(Color.GREEN);
		
		Circle circ = new Circle(500,600,400,g);
		circ.drawCircle();

		for(int i = 0; i < 400; i++) {
			Circle c = new Circle(600,600,i,g);
			g.setColor(new Color((int)(Math.random()*255.0d),(int)(Math.random()*255.0d),(int)(Math.random()*255.0d)));
			c.drawCircle();
		}

		g.setColor(new Color(255,255,255));
		g.setFont(new Font("Courier", Font.ITALIC, 30));
		g.drawString("yeet",250,250);
		try {
			ImageIO.write(image, "jpg", new File("testjpeg.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void rectGradient(int x1,int y1, int x2, int y2, Graphics g) {
		

	}

}

class Circle {
	int x;
	int y;
	int radius;
	Graphics g;

	public Circle(int x, int y, int radius, Graphics g) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.g = g;
	}	

	public void drawCircle() {
		for(int i = 0; i <= radius; i++) {
			int xAdj = (int)Math.sqrt(Math.pow(radius,2)-Math.pow(i,2));
			g.drawLine(x+xAdj,y+i,x+xAdj,y+i);
			g.drawLine(x+i,y+xAdj,x+i,y+xAdj);
			g.drawLine(x+xAdj,y-i,x+xAdj,y-i);
			g.drawLine(x-i,y+xAdj,x-i,y+xAdj);
			g.drawLine(x-i,y-xAdj,x-i,y-xAdj);
			g.drawLine(x-xAdj,y-i,x-xAdj,y-i);
			g.drawLine(x-xAdj,y+i,x-xAdj,y+i);
			g.drawLine(x+i,y-xAdj,x+i,y-xAdj);
		}
	}
}

class Quadrilateral {
	int x;
	int y;
	int width;
	int height;
	Graphics g;

	public Quadrilateral(int x1, int y1, int x2, int y2, Graphics g) {
		this.x = x1;
		this.y = y1;
		this.width = x2 - x1;
		this.height = y2-y1;
		this.g = g;
	}

	public void details() {
		System.out.println(x + " " + y + " " + width + " " + height);
	}
	
	public void fillGradient(Color c1, Color c2) {
		int re1 = c1.getRed();
		int gr1 = c1.getGreen();
		int bl1 = c1.getBlue();
		int re2 = c2.getRed();
		int gr2 = c2.getGreen();
		int bl2 = c2.getBlue();
		double mr = re1;
		double mb = bl1;
		double mg = gr1;
		double rr = (re2-re1);
		double rg = (gr2-gr1);
		double rb = (bl2-bl1);

		int i = x;
		while(i <= x + width) {
			double temp = (double)(i-x)/(double)width;
			double yt = (double)y + temp*(double)height;
			mr = re1 + (temp * rr);
			mg = gr1 + (temp * rg);
			mb = bl1 + (temp * rb);

			g.setColor(new Color((int)mr,(int)mg,(int)mb));
			g.drawLine(i,y,i,y+height);
			i++;
		}
	}

	public void fillRect(Color c1) {
		int i = x;
		while(i <= x+width){
		g.setColor(c1);
		g.drawLine(i,y,i,y+height);
		i++;
		}
	}

}
