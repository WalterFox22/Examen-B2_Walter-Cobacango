import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Busqueda_de_Pacientes {
    public JTextArea tituloBusqueda;
    public JTextArea ingresoCedula;
    public JTextField cedula;
    public JButton buscar;
    public JLabel mostrar;
    public JButton regresoLogin;
    public JButton regresarRegistro;


    public Busqueda_de_Pacientes() {
        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
