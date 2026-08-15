import java.awt.event.*;
import javax.swing.*;

public class gui {
    public static void main(String[] args) {

        // Create window
        JFrame frame = new JFrame("My Window");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create button
        JButton btn = new JButton("Click Mdfgete");

        // Create label (to show message)
        JLabel label = new JLabel("");

        // What happens when button is clicked
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("I AM CLICKED");
            }
        });

        // Add button and label to window
        JPanel panel = new JPanel();
        panel.add(btn);
        panel.add(label);
        frame.add(panel);

        // Show window
        frame.setVisible(true);
    }
}