package Controlador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import modelo.GestorMensajes;
import modelo.Mensaje;

public class Controlador {
    
    private GestorMensajes gestor = new GestorMensajes();
    
    public ArrayList<Mensaje> todosMensajes() {
        return gestor.mensajes;
    }
    
    public void leerArchivo() throws FileNotFoundException, IOException{
        gestor.leerArchivo();
    }
    
    public void agregarMensaje(LocalDate fecha, LocalTime hora, String para, String de, String asunto, String contenido) {
        Mensaje nuevoMensaje = new Mensaje(fecha, hora, para, de, asunto, contenido);
        gestor.mensajes.add(nuevoMensaje);
    }
}
