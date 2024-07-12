import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Busqueda_de_Pacientes {
    public JTextArea tituloBusqueda;
    public JTextArea ingresoCedula;
    public JTextField cedula;
    public JButton buscar;
    public JLabel mostrar;
    public JButton regresoLogin;
    public JButton regresarRegistro;
    public JPanel panel3;


    public Busqueda_de_Pacientes() {
        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String busqueda = cedula.getText().trim();
                String url = "jdbc:mysql://localhost:3306/sistema_hospitalario";
                String user = "root";
                String password = "123456";

                String sql = "SELECT * FROM PACIENTE WHERE cedula = ?";

                try (Connection connection = DriverManager.getConnection(url, user, password);
                     PreparedStatement statement = connection.prepareStatement(sql)) {

                    statement.setString(1, busqueda);
                    ResultSet resultSet = statement.executeQuery();

                    if (resultSet.next()) {
                        String cedulatr = resultSet.getString("cedula");
                        int historialcli = resultSet.getInt("historialcli");
                        String nombrestr = resultSet.getString("nombre");
                        String apellidostr = resultSet.getString("apellido");
                        String telefonostr = resultSet.getString("telefono");
                        int edadstr = resultSet.getInt("edad");
                        String descripcionstr = resultSet.getString("descripcion");

                        mostrar.setText("<html>cedula: " + cedulatr + "<br>historia: " + historialcli +
                                "<br>Nombre: " + nombrestr + "<br>Apellido : " + apellidostr +
                                "<br>telefono: " + telefonostr + "<br>edad: " + edadstr + "<br>Descripcion de la consulta: " + descripcionstr +"</html>");
                    } else {
                        mostrar.setText("No se encontró ningún registro con la placa proporcionada.");
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(panel3, "Error al buscar el registro", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        regresoLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("LOGIN");
                frame.setContentPane(new login().panel1);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(700, 700);
                frame.pack();
                frame.setVisible(true);
            }
        });
        regresarRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame2 = new JFrame("REGISTRO");
                frame2.setContentPane(new Registrar_Pacientes().panel2);
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.setSize(700, 700);
                frame2.pack();
                frame2.setVisible(true);
            }
        });
    }
}
