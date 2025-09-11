package Modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class GestorPartidos {
	private ArrayList<Partido> partidos = new ArrayList<Partido>();
	private File fichero = new File("partidos.dat");

	public ArrayList<Partido> getPartidos() {
		return partidos;
	}

	public void guardarPartidos() {
		try (DataOutputStream dataOS = new DataOutputStream(new FileOutputStream(fichero))) {
			for (Partido p : partidos) {
				dataOS.writeUTF(p.getFecha().toString());
				dataOS.writeUTF(p.getEquipoLocal());
				dataOS.writeUTF(p.getEquipoVisitante());
				dataOS.writeInt(p.getGolLocal());
				dataOS.writeInt(p.getGolVisitante());
				dataOS.writeUTF(p.getLugar());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void anadirPartido(Partido p) {
		partidos.add(p);
	}

	public void cargarPartidos() {
		partidos.clear();
		if (!fichero.exists())
			return;
		try (DataInputStream dataIS = new DataInputStream(new FileInputStream(fichero))) {
			while (dataIS.available() > 0) {
				String fechaStr = dataIS.readUTF();
				String equipoLocal = dataIS.readUTF();
				String equipoVisitante = dataIS.readUTF();
				int golLocal = dataIS.readInt();
				int golVisitante = dataIS.readInt();
				String lugar = dataIS.readUTF();
				Partido p = new Partido(java.time.LocalDate.parse(fechaStr), equipoLocal, equipoVisitante, golLocal,
						golVisitante, lugar);
				partidos.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}