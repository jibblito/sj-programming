public class SinCosInverter {
	public static void main(String[] args) {

	}

	
}

class Equation {
	boolean identity; // For this boolean, FALSE value = sin, TRUE value = cos
	float amplitude;
	float stretch;
	float xShift;
	float yShift;
	
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
		amplitude = Float.parseFloat(amp); 
		
		stLim = endLim + 3;
		endLim = equation.indexOf("(");

		String stre = "";
		for(int i = stLim; i < endLim; i++) {
			stre += equation.charAt(i);
		}
		stretch = Float.parseFloat(stre);

		stLim = endLim + 2;
		endLim = equation.indexOf(")");

		String xS = "";
		for(int i = stLim; i < endLim; i++) {
			xS += equation.charAt(i);
		}
		xShift = Float.parseFloat(xS) * -1.0f;

		stLim = endLim + 1;
		endLim = equation.length();
		
		String yS = "";
		for(int i = stLim; i < endLim; i++) {
			yS += equation.charAt(i);
		}
		yShift = Float.parseFloat(yS);
	}

	public void printEqn() {
		System.out.print(amplitude);
		identity ? System.out.print("cos"); : System.out.print("sin");
		System.out.print(stretch + "(x + " + xShift + ") +" + yShift);
	}
}