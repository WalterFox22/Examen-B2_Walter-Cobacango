import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registrar_Pacientes {
    public JTextArea tituloHisrorial;
    public JTextArea tituloNombre;
    public JTextArea tituloApellido;
    public JTextArea tituloTelefono;
    public JTextArea tituloEdad;
    public JTextArea tituloDescripcion;
    public JPanel panel2;
    public JTextPane tituloRegistro;
    public JTextField historialClinico;
    public JTextField nombre;
    public JTextField apellido;
    public JTextField telefono;
    public JTextField edad;
    public JTextField descripcion;
    public JButton Registar_paciente;
    public JButton buscar_paciente;


    public Registrar_Pacientes() {
        Registar_paciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
