package lanzamientodeaceitunas;

import java.util.ArrayList;
import java.util.List;

public class Cuadratica extends Estrategia{

	@Override
	public int obtenerMejorR2(List<Lanzamiento> lista) {
		
		List<Lanzamiento> lista_clon = new ArrayList<>();
		for (Lanzamiento lanzamiento : lista) 
			lista_clon.add(lanzamiento);
		
		double mejorR = 0;
		int puntosOli=0,puntosRival=0, diferenciaDePuntosActual, diferenciaMaxima = 0;
		int cont=0;
		
		while(lista_clon.size()>0) {
		
			double distancia_maxima = getDistanciaMaxima(lista_clon);
			cont+=lista_clon.size();
			
			for (Lanzamiento lanzamiento : lista_clon) {
				cont++;
				
				if(lanzamiento.getDistancia() < distancia_maxima) {
					
					if (lanzamiento.esFavorable())
						puntosOli++;
					else
						puntosRival++;
					
					diferenciaDePuntosActual = puntosOli - puntosRival;
	
					if (diferenciaDePuntosActual > diferenciaMaxima) {
						mejorR = distancia_maxima;
						diferenciaMaxima = diferenciaDePuntosActual;
					}
				}
				
			}
			
			lista_clon.remove(lista_clon.size()-1);

		}
		
		System.out.println(cont);
		return (int) Math.pow(mejorR, 2);
	}

}
