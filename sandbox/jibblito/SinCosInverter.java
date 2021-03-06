import java.util.Scanner;

public class SinCosInverter {
	
	static String version = "1.0";

	public static void main(String[] args) 	{
		String input;
		Scanner scan = new Scanner(System.in);
		System.out.println("SIN/COS INVERTER VERSION " + version + " BY RORY HIBBLER");
		System.out.println("Enter sin/cos equation in format Asin:cosB(x-C)+D: ");
		input = scan.nextLine();
		
		Equation eq = new Equation(input);
		Equation eqInv = eq.getInverse();
		System.out.println("Input: "+ eq.getParsedEq());
		System.out.print("Result after inversion: " + eqInv.getParsedEq());
		}
}

class Equation {
	boolean identity; // For this boolean, FALSE value = sin, TRUE value = cos
	float amplitude = 1;
	float stretch = 1;
	float xShift = 0;
	float yShift = 0;
	String parsedEq;
	
	public Equation(String equation) {
		
		int stLim = 0;
		int endLim = 0;
		
		if(equation.contains("sin")) {
			identity = false;
			endLim = equation.indexOf("sin");
		} else if(equation.contains("cos")) {
			identity = true;
			endLim = equation.indexOf("cos");
		} else throw new IllegalArgumentException("Equation must be entered in format Asin:cosB(x-C)+D");
			
		String amp = "";
		for(int i = stLim; i < endLim; i++) {
			amp += equation.charAt(i); 
		}
		if(amp.length() > 0) amplitude = Float.parseFloat(amp);
		
		stLim = endLim + 3;
		endLim = equation.indexOf("(");
		String stre = "";
		for(int i = stLim; i < endLim; i++) {
			stre += equation.charAt(i);
		}
		if(stre.length() > 0) stretch = Float.parseFloat(stre);

		stLim = endLim + 2;
		endLim = equation.indexOf(")");
		String xS = "";
		for(int i = stLim; i < endLim; i++) {
			xS += equation.charAt(i);
		}
		if(xS.length() > 0) xShift = Float.parseFloat(xS) * -1.0f;
		
		stLim = endLim + 1;
		endLim = equation.length();
		String yS = "";
		for(int i = stLim; i < endLim; i++) {
			yS += equation.charAt(i);
		}
		if(yS.length() > 0) yShift = Float.parseFloat(yS);
		
		parsedEq = buildEquation(identity,amplitude,stretch,xShift,yShift);
		
 	}
	 
	String buildEquation(boolean ident,float amp,float stre,float xS,float yS) {
		String s = ""+amp;
		if(ident) s+="cos";
		else s+="sin";
		s+="+"+stre+"(x";
		if(xS<=0) s+="+";
		if(xS==0) s+=xS+")";
		else s+=-1*xS + ")";
		if(yS>=0) s+="+";
		s+=yS;
		return s;
	}

	public String getParsedEq() {
		return parsedEq;
	}
	
	public Equation getInverse() {
		Float deltaPeriod = 3.14f/(2.0f*stretch);
		if(identity) {
			String newEq = buildEquation(false,amplitude,stretch,xShift-deltaPeriod,yShift);
			return new Equation(newEq);
		} else {
			String newEq = buildEquation(true,amplitude,stretch,xShift+deltaPeriod,yShift);
			return new Equation(newEq);
		}
	}
	
}
