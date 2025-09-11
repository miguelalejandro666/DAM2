package Ejercicios;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Ejer2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
		System.out.println("Hola");
			ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "tasklist");	
		Process proces = pb.start();
		
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
