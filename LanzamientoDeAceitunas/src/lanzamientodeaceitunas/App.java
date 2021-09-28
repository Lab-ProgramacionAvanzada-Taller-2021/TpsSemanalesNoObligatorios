package lanzamientodeaceitunas;

public class App {

	public static void main(String[] args) throws Exception {
		
		GestorArchivosOlivares manager = new GestorArchivosOlivares("entrada");
		
		Partido partido = new Partido(manager.leerArchivo());
		partido.setEstrategia(new Cuadratica());
		partido.setEstrategia(new Lineal());
		
		manager.escribirArchivo(partido.obtenerMejorR2());
		
		//pruebaaaa
		
	}

	
	
}
