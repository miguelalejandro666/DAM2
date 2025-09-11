package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;
import javax.swing.JList;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import Modelo.GestorPartidos;
import Modelo.Partido;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Pantalla extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEquipoLocal;
	private JTextField txtEquipoVisitante;
	private JTextField txtGolLocal;
	private JTextField txtGolVisitante;
	private JTextField txtLugar;
	private JTextField txtFecha;
	private JTable table;
	private GestorPartidos gestor = new GestorPartidos();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla frame = new Pantalla();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Pantalla() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 442, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtEquipoLocal = new JTextField();
		txtEquipoLocal.setBounds(103, 21, 321, 20);
		contentPane.add(txtEquipoLocal);
		txtEquipoLocal.setColumns(10);
		
		txtEquipoVisitante = new JTextField();
		txtEquipoVisitante.setBounds(103, 52, 321, 20);
		contentPane.add(txtEquipoVisitante);
		txtEquipoVisitante.setColumns(10);
		
		txtGolLocal = new JTextField();
		txtGolLocal.setBounds(103, 83, 321, 20);
		contentPane.add(txtGolLocal);
		txtGolLocal.setColumns(10);
		
		txtGolVisitante = new JTextField();
		txtGolVisitante.setBounds(103, 114, 321, 20);
		contentPane.add(txtGolVisitante);
		txtGolVisitante.setColumns(10);
		
		txtLugar = new JTextField();
		txtLugar.setBounds(103, 145, 321, 20);
		contentPane.add(txtLugar);
		txtLugar.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(103, 176, 105, 20);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);
		
		JButton btnAnadir = new JButton("Añadir");
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String equipoLocal = txtEquipoLocal.getText().trim();
                String equipoVisitante = txtEquipoVisitante.getText().trim();
                String golLocalStr = txtGolLocal.getText().trim();
                String golVisitanteStr = txtGolVisitante.getText().trim();
                String lugar = txtLugar.getText().trim();
                String fechaStr = txtFecha.getText().trim();
                int golLocal, golVisitante;
                LocalDate fecha;
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                
                if (equipoLocal.isEmpty() || equipoVisitante.isEmpty() || golLocalStr.isEmpty() || golVisitanteStr.isEmpty() || lugar.isEmpty() || fechaStr.isEmpty()) {
                    JOptionPane.showMessageDialog(Pantalla.this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    golLocal = Integer.parseInt(golLocalStr);
                    golVisitante = Integer.parseInt(golVisitanteStr);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Pantalla.this, "Los goles deben ser números enteros", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    fecha = LocalDate.parse(fechaStr, formatter);
                } catch (DateTimeParseException ex) {
                    JOptionPane.showMessageDialog(Pantalla.this, "La fecha debe tener formato AAAA-MM-DD", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Partido partido = new Partido(fecha, equipoLocal, equipoVisitante, golLocal, golVisitante, lugar);
                gestor.getPartidos().add(partido);
          
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.addRow(new Object[]{equipoLocal, equipoVisitante, golLocal, golVisitante, lugar, fecha});
         
                txtEquipoLocal.setText("");
                txtEquipoVisitante.setText("");
                txtGolLocal.setText("");
                txtGolVisitante.setText("");
                txtLugar.setText("");
                txtFecha.setText("");
			}
		});
		btnAnadir.setBounds(103, 218, 89, 23);
		contentPane.add(btnAnadir);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestor.guardarPartidos();
				JOptionPane.showMessageDialog(Pantalla.this, "Partidos guardados correctamente en partidos.dat", "Guardar", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnGuardar.setBounds(335, 218, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestor.cargarPartidos();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0); 
				for (Partido p : gestor.getPartidos()) {
					model.addRow(new Object[]{
						p.getEquipoLocal(),
						p.getEquipoVisitante(),
						p.getGolLocal(),
						p.getGolVisitante(),
						p.getLugar(),
						p.getFecha()
					});
				}
				JOptionPane.showMessageDialog(Pantalla.this, "Partidos cargados correctamente desde partidos.dat", "Cargar", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnCargar.setBounds(218, 218, 89, 23);
		contentPane.add(btnCargar);
		
		JLabel lblEquipoLocal = new JLabel("Equipo Local");
		lblEquipoLocal.setBounds(10, 24, 73, 14);
		contentPane.add(lblEquipoLocal);
		
		JLabel lblEquipoVisitante = new JLabel("Equipo visitante");
		lblEquipoVisitante.setBounds(10, 55, 83, 14);
		contentPane.add(lblEquipoVisitante);
		
		JLabel lblGolLocal = new JLabel("Gol local");
		lblGolLocal.setBounds(10, 86, 83, 14);
		contentPane.add(lblGolLocal);
		
		JLabel lblGolVisitante = new JLabel("Gol visitante");
		lblGolVisitante.setBounds(10, 117, 83, 14);
		contentPane.add(lblGolVisitante);
		
		JLabel lblLugar = new JLabel("Lugar");
		lblLugar.setBounds(10, 148, 83, 14);
		contentPane.add(lblLugar);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 179, 83, 14);
		contentPane.add(lblFecha);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 266, 408, 102);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Equipos Locales", "Equipos Visitantes", "Goles Locales", "Goles Visitantes", "Lugar", "Fecha"
			}
		));
		scrollPane.setViewportView(table);

	}
}