import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Form_buscar {
    private JLabel lb_titulo;
    private JTextField tf_buscarcedula;
    private JButton bt_buscar;
    private JLabel lb_subtitulo;
    public JPanel panel;
    public JLabel lb_resultado;

    public Form_buscar() {
        bt_buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/estudiante";
                String user = "root";
                String password = "123456789";

                String cedula = tf_buscarcedula.getText();

                String sql = "SELECT * FROM estudiantes WHERE cedula = ?";

                try (Connection connection = DriverManager.getConnection(url, user, password);
                     PreparedStatement statement = connection.prepareStatement(sql)) {

                    statement.setString(1, cedula);

                    ResultSet resultSet = statement.executeQuery();

                    if (resultSet.next()) {
                        String nombre = resultSet.getString("nombre");
                        float b1 = resultSet.getFloat("b1");
                        float b2 = resultSet.getFloat("b2");

                        lb_resultado.setText("<html>Cédula: " + cedula + "<br>Nombre: " + nombre + "<br>B1: " + b1 + "<br>B2: " + b2 + "</html>");
                    } else {
                        lb_resultado.setText("No se encontraron datos para la cédula: " + cedula);
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                    lb_resultado.setText("Error al buscar datos: " + ex.getMessage());
                }
            }
        });
    }
}
