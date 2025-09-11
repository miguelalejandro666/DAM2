package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.awt.event.ActionEvent;

public class nuevomensaje extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textDia;
    private JTextField textDe;
    private JTextField textPara;
    private JTextField textAsunto;
    private JTextArea textContenido;
    private JComboBox<String> comboBoxMes;
    private JComboBox<String> comboBoxAnio;
    private JComboBox<String> comboBoxHora;
    private JComboBox<String> comboBoxMinutos;
    
    private Controlador.Controlador controlador;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    nuevomensaje frame = new nuevomensaje();
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
    public nuevomensaje() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        controlador = new Controlador.Controlador();
        
        textDia = new JTextField();
        textDia.setBounds(79, 11, 46, 20);
        contentPane.add(textDia);
        textDia.setColumns(10);
        
        comboBoxMes = new JComboBox<String>();
        comboBoxMes.setModel(new DefaultComboBoxModel<String>(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
        comboBoxMes.setBounds(135, 10, 68, 22);
        contentPane.add(comboBoxMes);
        
        comboBoxAnio = new JComboBox<String>();
        comboBoxAnio.setModel(new DefaultComboBoxModel<String>(new String[] {"2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
        comboBoxAnio.setBounds(213, 10, 68, 22);
        contentPane.add(comboBoxAnio);
        
        JLabel lblFecha = new JLabel("Fecha:");
        lblFecha.setBounds(10, 14, 46, 14);
        contentPane.add(lblFecha);
        
        JLabel lblHora = new JLabel("Hora:");
        lblHora.setBounds(10, 45, 46, 14);
        contentPane.add(lblHora);
        
        comboBoxHora = new JComboBox<String>();
        comboBoxHora.setModel(new DefaultComboBoxModel<String>(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
        comboBoxHora.setBounds(79, 41, 46, 22);
        contentPane.add(comboBoxHora);
        
        comboBoxMinutos = new JComboBox<String>();
        comboBoxMinutos.setModel(new DefaultComboBoxModel<String>(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
        comboBoxMinutos.setBounds(135, 41, 46, 22);
        contentPane.add(comboBoxMinutos);
        
        JLabel lblDe = new JLabel("De:");
        lblDe.setBounds(10, 81, 46, 14);
        contentPane.add(lblDe);
        
        JLabel lblPara = new JLabel("Para: ");
        lblPara.setBounds(10, 113, 46, 14);
        contentPane.add(lblPara);
        
        JLabel lblAsunto = new JLabel("Asunto:");
        lblAsunto.setBounds(10, 149, 46, 14);
        contentPane.add(lblAsunto);
        
        textDe = new JTextField();
        textDe.setBounds(76, 78, 305, 20);
        contentPane.add(textDe);
        textDe.setColumns(10);
        
        textPara = new JTextField();
        textPara.setBounds(76, 110, 305, 20);
        contentPane.add(textPara);
        textPara.setColumns(10);
        
        textAsunto = new JTextField();
        textAsunto.setBounds(76, 146, 305, 20);
        contentPane.add(textAsunto);
        textAsunto.setColumns(10);
        
        textContenido = new JTextArea();
        textContenido.setBounds(76, 177, 305, 80);
        contentPane.add(textContenido);
        
        JLabel lblContenido = new JLabel("Contenido:");
        lblContenido.setBounds(10, 180, 56, 14);
        contentPane.add(lblContenido);
        
        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnCancel.setBounds(297, 268, 79, 23);
        contentPane.add(btnCancel);
        
        JButton btnOkay = new JButton("Okay");
        btnOkay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	

                int dia = Integer.parseInt(textDia.getText());
                int mes = Integer.parseInt((String) comboBoxMes.getSelectedItem());
                int anio = Integer.parseInt((String) comboBoxAnio.getSelectedItem());
                
                int hora = Integer.parseInt((String) comboBoxHora.getSelectedItem());
                int minutos = Integer.parseInt((String) comboBoxMinutos.getSelectedItem());
                
                String de = textDe.getText();
                String para = textPara.getText();
                String asunto = textAsunto.getText();
                String contenido = textContenido.getText();
                LocalDate fecha = LocalDate.of(anio, mes, dia);
                LocalTime tiempo = LocalTime.of(hora, minutos);
                
              if (dia < 1 || dia > 31) {
                controlador.agregarMensaje(fecha, tiempo, para, de, asunto, contenido);             

                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Pon bien el día.",
                        "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            	}
            }
           
            
        });
        btnOkay.setBounds(208, 268, 79, 23);
        contentPane.add(btnOkay);
        
        JLabel lblDia = new JLabel("Día:");
        lblDia.setBounds(135, 14, 30, 14);
        contentPane.add(lblDia);
        
        JLabel lblMes = new JLabel("Mes:");
        lblMes.setBounds(213, 14, 30, 14);
        contentPane.add(lblMes);
        
        JLabel lblAnio = new JLabel("Año:");
        lblAnio.setBounds(291, 14, 30, 14);
        contentPane.add(lblAnio);
        
        JLabel lblHora_1 = new JLabel("Hora:");
        lblHora_1.setBounds(135, 45, 30, 14);
        contentPane.add(lblHora_1);
        
        JLabel lblMinutos = new JLabel("Min:");
        lblMinutos.setBounds(191, 45, 30, 14);
        contentPane.add(lblMinutos);

    }
    
    public void setControlador(Controlador.Controlador controlador) {
        this.controlador = controlador;
    }
}
