package lanzamientodeaceitunas;

import java.util.List;

public class Partido {
	private List<Lanzamiento> lanzamientos;
	private Estrategia estrategia;

	public Partido(List<Lanzamiento> lista) {
		lanzamientos = lista;
	}

	public boolean agregar(Lanzamiento lanzamiento) {
		
		lanzamientos.add(lanzamiento);
		
		return true;
	}
	
	public int obtenerMejorR2() {
		return estrategia.obtenerMejorR2(lanzamientos);
	}

	public double obtenerDistanciaMaxima() {
		return estrategia.getDistanciaMaxima(lanzamientos);
	}
	
	public void setEstrategia(Estrategia estrategia) {
		this.estrategia = estrategia;
	}

	public String toString() {
		String ret = "";
		
		int ls = lanzamientos.size();
		for(int i=0; i<ls; i++) {
			ret = ret.concat(lanzamientos.get(i).toString());
			if(i < ls-1)
				ret = ret.concat(System.lineSeparator());
		}
		
		return ret;
	}
	
}
