import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.sql.*;

public class login {
    public JTextArea tituloLOGIN;
    public JTextPane tituloNombre;
    public JTextField nombreUsuario;
    public JTextPane tituloCotra;
    public JPasswordField contraseña;
    public JButton acceder;
    public JPanel panel1;


    public login() {
        acceder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String busqueda = nombreUsuario.getText().trim();
                String busacar2= contraseña.getPassword().toString();

                String url = "jdbc:mysql://localhost:3306/sistema_hospitalario";
                String user = "root";
                String password = "123456";

                String nombreIngresado = nombreUsuario.getText();
                String contraseñaIngresada = new String(contraseña.getPassword());
                String sql = "SELECT * FROM USUARIO WHERE username = ?";
                String sql2 = "SELECT * FROM USUARIO WHERE password = ?";

                try (Connection connection = DriverManager.getConnection(url, user, password)) {
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, busqueda);
                    ResultSet resultSet = statement.executeQuery();

                    if (resultSet.next()) {
                        String noombre = resultSet.getString("username");
                        String contraseña = resultSet.getString("password");
                        JOptionPane.showMessageDialog(panel1, "Login exitoso");
                        JFrame frame2 = new JFrame("REGISTRO");
                        frame2.setContentPane(new Registrar_Pacientes().panel2);
                        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame2.setSize(700, 700);
                        frame2.pack();
                        frame2.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(panel1, "Credenciales incorrectas");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(panel1, "Error al buscar el registro", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        });
    }
}

