package es;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class ProcesoSecundario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
		System.out.println("Hola");
			ProcessBuilder pb = new ProcessBuilder("java","es.Programa");
			pb.directory(new File("bin"));
			
			
			
			pb.redirectError(new File("errores.txt"));
		Process proces = pb.start();
		
		OutputStream os = proces.getOutputStream();
		String nombre = "Iker\n";
		os.write(nombre.getBytes());
		os.flush();
		
		long id = proces.pid();
		System.out.println("ID: " + id);
		
		InputStream is = proces.getInputStream();
		BufferedReader bis = new BufferedReader(new InputStreamReader(is));
	String Linea = "";
		while ((Linea = bis.readLine()) != null) {
			System.out.println(Linea);
		}

		


		} catch (IOException e) {
			// TODO Auto-generated catch block


		} 
		
		System.exit(-4);

	}

}
