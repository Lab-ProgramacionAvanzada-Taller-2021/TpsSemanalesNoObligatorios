package lanzamientodeaceitunas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class GestorArchivosOlivares {

	private String path;
	
	public GestorArchivosOlivares(String nombre) {
		path = System.getProperty("user.dir")+"\\"+nombre;
	}
	
	public List<Lanzamiento> leerArchivo(){
		
		Scanner scanner = null;
		List<Lanzamiento> lista = null;
		
		try {
			File pf = new File(path+".in");
			scanner = new Scanner(pf);
			scanner.useLocale(Locale.ENGLISH);
			
			lista = new ArrayList<Lanzamiento>();
			
			int cantLanzamientos = scanner.nextInt();
			
			//metodo 1 con scanner.nextInt solamente
			for(int i=0; i<cantLanzamientos; i++) {
				lista.add(new Lanzamiento(scanner.nextInt(), scanner.nextInt()));
			}
			
//			//metodo 2 con scanner.nextLine solamente
//			scanner.nextLine(); //para descartar el separador de linea del nextInt que acabo de leer y que no estorbe al usar scanner.nextLine a continuacion
//			for(int i=0; i<cantLanzamientos; i++) {
//				String linea = scanner.nextLine();
//				String[] campos = linea.split(" ");
//				lista.add(new Lanzamiento(Integer.valueOf(campos[0]), Integer.valueOf(campos[1])));
//			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LanzamientoNoValido e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(scanner != null)
				scanner.close();
		}
		
		return lista;
	}
	
	public void escribirArchivo(int mejorR2) {
		FileWriter file = null;
		PrintWriter printer = null;
		
		try {
			file = new FileWriter(path+".out");
			printer = new PrintWriter(file);
			
			printer.print(mejorR2);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			printer.close();
		}
	}
	
}
