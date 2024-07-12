import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    public JTextArea tituloCedula;
    public JTextField cedula;


    public Registrar_Pacientes() {
        Registar_paciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cedulatr = cedula.getText();
                int historialcli = Integer.parseInt(historialClinico.getText());
                String nombrestr = nombre.getText();
                String apellidostr = apellido.getText();
                String telefonostr = telefono.getText();
                int edadstr = Integer.parseInt(edad.getText());
                String descripcionstr = descripcion.getText();

                REGISTRO ingreso = new REGISTRO(cedulatr, historialcli, nombrestr, apellidostr, telefonostr, edadstr, descripcionstr);
                String url = "jdbc:mysql://localhost:3306/sistema_hospitalario";
                String user = "root";
                String password = "123456";

                String sql = "INSERT INTO PACIENTE (cedula, n_historial_clinico, nombre,apellido, telefono, edad,descripcion_enfermedad ) VALUES(?,?,?,?,?,?,?)";

                try (Connection connection = DriverManager.getConnection(url, user, password)) {
                    PreparedStatement cadenaPreparada = connection.prepareStatement(sql);

                    cadenaPreparada.setString(1, ingreso.getCedula());
                    cadenaPreparada.setInt(2, ingreso.getN_historial_clinico());
                    cadenaPreparada.setString(3, ingreso.getNombre());
                    cadenaPreparada.setString(4, ingreso.getApellido());
                    cadenaPreparada.setString(5, ingreso.getTelefono());
                    cadenaPreparada.setInt(6, ingreso.getEdad());
                    cadenaPreparada.setString(7, ingreso.getDescripcion());

                    cadenaPreparada.executeUpdate();

                    JFrame frame3 = new JFrame("BUSQUEDA DE PACIENTE");
                    frame3.setContentPane(new Busqueda_de_Pacientes().panel3);
                    frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame3.setSize(700, 700);
                    frame3.pack();
                    frame3.setVisible(true);

                    JOptionPane.showMessageDialog(panel2, "Se ha registrado el paciente con exito");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(panel2, "Error al registrar el paciente", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        });
    }
}

