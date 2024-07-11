import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Form_insertar {
    public JPanel panel;
    private JTextField tf_cedula;
    private JLabel lb_titulo;
    private JLabel lb_nombre;
    private JTextField tf_nombre;
    private JLabel lb_b1;
    private JTextField tf_b1;
    private JLabel lb_b2;
    private JTextField tf_b2;
    private JLabel lb_cedula;
    private JButton bt_ingresar;

    public Form_insertar() {
        bt_ingresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/estudiante";
                String user = "root";
                String password = "123456789";

                String cedula = tf_cedula.getText();
                String nombre = tf_nombre.getText();
                float b1 = Float.parseFloat(tf_b1.getText());
                float b2 = Float.parseFloat(tf_b2.getText());

                String sql = "INSERT INTO estudiantes (cedula, nombre, b1, b2) VALUES (?, ?, ?, ?)";

                try (Connection connection = DriverManager.getConnection(url, user, password);
                     PreparedStatement statement = connection.prepareStatement(sql)) {

                    statement.setString(1, cedula);
                    statement.setString(2, nombre);
                    statement.setFloat(3, b1);
                    statement.setFloat(4, b2);

                    int rowsInserted = statement.executeUpdate();

                    if (rowsInserted > 0) {
                        System.out.println("Datos insertados correctamente");
                    } else {
                        System.out.println("No se han insertado datos");
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                    System.out.println("Error al insertar datos: " + ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Registro");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Form_insertar().panel);
        frame.pack();
        frame.setSize(550, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
