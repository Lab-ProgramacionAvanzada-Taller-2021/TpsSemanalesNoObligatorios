package lanzamientodeaceitunas;

import static java.lang.Math.*;

public class Lanzamiento {
	private double x;
	private double y;

	public Lanzamiento(double x, double y) throws LanzamientoNoValido {
		if(x==0 || x>abs(40000) || y>abs(40000))
			throw new LanzamientoNoValido("Lanzamiento no válido");
		
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	public boolean esFavorable() {
		return x>0;
	}
	
	public double getDistancia() {
		return sqrt(pow(x, 2)+pow(y, 2));
	}
	
	public String toString() {
		return String.format("%.0f", x)+"\t"+String.format("%.0f", y);
	}
}
