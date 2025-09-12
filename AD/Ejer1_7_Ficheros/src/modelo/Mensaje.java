package modelo;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Mensaje {

	LocalDate fecha;
	LocalTime hora;
	String para;
	String de;
	String asunto;
	String contenido;
	
	
	@Override
	public String toString() {
		return "fecha:" + fecha + "\n hora:" + hora + "\n para:" + para + "\n de:" + de + "\n asunto:" + asunto
				+ "\n contenido:" + contenido + ".";
	}


	public Mensaje(LocalDate fecha, LocalTime hora, String para, String de, String asunto, String contenido) {
	
		this.fecha = fecha;
		this.hora = hora;
		this.para = para;
		this.de = de;
		this.asunto = asunto;
		this.contenido = contenido;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public LocalTime getHora() {
		return hora;
	}


	public void setHora(LocalTime hora) {
		this.hora = hora;
	}


	public String getPara() {
		return para;
	}


	public void setPara(String para) {
		this.para = para;
	}


	public String getDe() {
		return de;
	}


	public void setDe(String de) {
		this.de = de;
	}


	public String getAsunto() {
		return asunto;
	}


	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}


	public String getContenido() {
		return contenido;
	}


	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
	
}
