package lanzamientodeaceitunas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class Lineal extends Estrategia {

	@Override
	public int obtenerMejorR2(List<Lanzamiento> lista) {

		TreeSet<Double> clavesRadio = new TreeSet<Double>();
		Map<Double, List<Lanzamiento>> mapa = new HashMap<Double, List<Lanzamiento>>();
		int cont=0;
		
		for (Lanzamiento lanzamiento : lista) {
			cont++;
			
			double radio = lanzamiento.getDistancia();
			clavesRadio.add(radio);

			if (mapa.get(radio) == null)
				mapa.put(radio, new ArrayList<>());
			mapa.get(radio).add(lanzamiento);

		}

		double mejorR = 0;
		int puntajeOli = 0, puntajeRival = 0, diferenciaDePuntosActual, diferenciaMaxima = 0;

		for (Double radio : clavesRadio) {

			for (Lanzamiento li : mapa.get(radio)) {
				cont++;
				
				if (li.esFavorable())
					puntajeOli++;
				else
					puntajeRival++;

			}

			diferenciaDePuntosActual = puntajeOli - puntajeRival;

			if (diferenciaDePuntosActual > diferenciaMaxima) {
				mejorR = radio;
				diferenciaMaxima = diferenciaDePuntosActual;
			}

		}

		System.out.println(cont);
		return (int) Math.pow(mejorR, 2);

	}

}
