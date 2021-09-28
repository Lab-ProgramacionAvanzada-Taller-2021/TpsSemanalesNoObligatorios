package lanzamientodeaceitunas;

import java.util.List;

public abstract class Estrategia {

	public abstract int obtenerMejorR2(List<Lanzamiento> lista);
	
	protected double getDistanciaMaxima(List<Lanzamiento> lista) {
		
		double max=0;
		
		for (Lanzamiento lanzamiento : lista) {
			double distancia = lanzamiento.getDistancia();
			if(distancia > max)
				max=distancia;
		}
		
		return max;
	}
	
}
