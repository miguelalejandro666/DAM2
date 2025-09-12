package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class GestorMensajes {

	public ArrayList<Mensaje> mensajes = new ArrayList<Mensaje>();
	
    public void leerArchivo() throws IOException, FileNotFoundException {
        File archivo = new File("mensajes.txt");

        if (!archivo.exists()) {
            System.out.println("Archivo no encontrado.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;

           
            LocalDate fecha = null;
            LocalTime hora = null;
            String para = null;
            String de = null;
            String asunto = null;
            String contenido = null;

            StringBuilder contenidoBuilder = new StringBuilder();

            while ((linea = br.readLine()) != null) {
                linea = linea.trim();

                if (linea.equals("******************")) {
                    
                    if (fecha != null && hora != null && para != null && de != null && asunto != null && contenido != null) {
                        mensajes.add(new Mensaje(fecha, hora, para, de, asunto, contenido));
                    }

                    
                    fecha = null;
                    hora = null;
                    para = null;
                    de = null;
                    asunto = null;
                    contenido = null;
                    contenidoBuilder.setLength(0); 
                } else if (linea.startsWith("fecha:")) {
                    fecha = LocalDate.parse(linea.substring(6));
                } else if (linea.startsWith("hora:")) {
                    hora = LocalTime.parse(linea.substring(5));
                } else if (linea.startsWith("para:")) {
                    para = linea.substring(5);
                } else if (linea.startsWith("de:")) {
                    de = linea.substring(3);
                } else if (linea.startsWith("asunto:")) {
                    asunto = linea.substring(7);
                } else if (linea.startsWith("contenido:")) {
                    
                    contenidoBuilder.append(linea.substring(9));
                } else {
                    
                    if (contenidoBuilder.length() > 0) {
                        contenidoBuilder.append("\n").append(linea);
                    }
                }
         
                if (contenidoBuilder.length() > 0) {
                    contenido = contenidoBuilder.toString();
                }
            }

            if (fecha != null && hora != null && para != null && de != null && asunto != null && contenido != null) {
                mensajes.add(new Mensaje(fecha, hora, para, de, asunto, contenido));
            }
        }
    }

    public ArrayList<Mensaje> getMensajes() {
        return mensajes;
    }
}
