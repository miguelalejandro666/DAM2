package Ejercicios;

import java.io.IOException;

public class Ejer1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			Process proceso = Runtime.getRuntime().exec("notepad");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
