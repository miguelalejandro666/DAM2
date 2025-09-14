package Ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejer5 {
	public static void main(String[] args) {
		try {
			// 1. List running processes
			ProcessBuilder pbList = new ProcessBuilder("tasklist");
			Process proces = pbList.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(proces.getInputStream()));
			String linea;
			while ((linea = reader.readLine()) != null) {
				if (linea.toLowerCase().contains("notepad.exe")) {
					ProcessBuilder pbEliminar = new ProcessBuilder("taskkill", "/F", "/IM", "notepad.exe");
					Process processElimanar = pbEliminar.start();
					BufferedReader kReader = new BufferedReader(new InputStreamReader(processElimanar.getInputStream()));
					String killLinea;
					while ((killLinea = kReader.readLine()) != null) {
						System.out.println(killLinea);
					}
					kReader.close();
					break;
				}
			}
			reader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}