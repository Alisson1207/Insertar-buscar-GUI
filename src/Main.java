import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Estudiante");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Form_principal().panel);
        frame.pack();
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}