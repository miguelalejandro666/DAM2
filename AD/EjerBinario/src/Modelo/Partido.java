package Modelo;

import java.time.LocalDate;

public class Partido {

	LocalDate fecha;
	String equipoLocal;
	String equipoVisitante;
	int golLocal;
	int golVisitante;
	String lugar;
	
	public Partido(LocalDate fecha, String equipoLocal, String equipoVisitante, int golLocal, int golVisitante, String lugar) {
		this.fecha = fecha;
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		this.golLocal = golLocal;
		this.golVisitante = golVisitante;
		this.lugar = lugar;
	}
	
	
 
	@Override
	public String toString() {
		return "Partido [fecha=" + fecha + ", equipoLocal=" + equipoLocal + ", equipoVisitante=" + equipoVisitante
				+ ", golLocal=" + golLocal + ", golVisitante=" + golVisitante + ", lugar=" + lugar + "]";
	}



	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getEquipoLocal() {
		return equipoLocal;
	}

	public void setEquipoLocal(String equipoLocal) {
		this.equipoLocal = equipoLocal;
	}

	public String getEquipoVisitante() {
		return equipoVisitante;
	}

	public void setEquipoVisitante(String equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}

	public int getGolLocal() {
		return golLocal;
	}

	public void setGolLocal(int golLocal) {
		this.golLocal = golLocal;
	}

	public int getGolVisitante() {
		return golVisitante;
	}

	public void setGolVisitante(int golVisitante) {
		this.golVisitante = golVisitante;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	
	
}