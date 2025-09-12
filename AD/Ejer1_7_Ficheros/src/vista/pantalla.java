package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.Controlador;
import modelo.GestorMensajes;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class pantalla extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Controlador controlador;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    pantalla frame = new pantalla();
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
    public pantalla() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        controlador = new Controlador();
        
        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnSalir.setBounds(297, 173, 104, 23);
        contentPane.add(btnSalir);
        
        JButton btnCargar = new JButton("Cargar mensaje");
        btnCargar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    controlador.leerArchivo();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Se han cargado en memoria " + controlador.todosMensajes().size() + " mensajes.",
                            "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        btnCargar.setBounds(10, 49, 170, 23);
        contentPane.add(btnCargar);
        
        JButton btnguardar = new JButton("Guardar mensaje");
        btnguardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        btnguardar.setBounds(231, 49, 170, 23);
        contentPane.add(btnguardar);
        
        JButton btnImprimir = new JButton("Imprimir mensaje");
        btnImprimir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              
            }
        });
        btnImprimir.setBounds(231, 98, 170, 23);
        contentPane.add(btnImprimir);
        
        JButton btnAnadir = new JButton("Añadir mensaje");
        btnAnadir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nuevomensaje frame = new nuevomensaje();
                frame.setControlador(controlador); 
                frame.setVisible(true);
            }
        });
        btnAnadir.setBounds(10, 98, 170, 23);
        contentPane.add(btnAnadir);

    }
}
