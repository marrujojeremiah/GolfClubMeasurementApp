import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GolfClubMeasurementApp {
    public static void main(String[] args){
        SwingUtilities.invokeLater((new Runnable() {
            public void run() {
                new GolfClubMeasurementApp().createAndShowGUI();

            }
        }));
    }
private void createAndShowGUI() {
    // Creating Frame
    JFrame frame = new JFrame("Golf Club Measurement App");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);
    frame.setLayout(new BorderLayout());

    // Creating the input panel
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(3, 2));

    //Creating and add text to the panel
    JLabel heightLabel = new JLabel("Height (inches):");
    JTextField heightField = new JTextField();
    JLabel wristLabel = new JLabel("Wrist-to-floor(inches):");
    JTextField wristField = new JTextField();
    JButton calculateButton = new JButton("Calculate");
    JLabel resultLabel = new JLabel("Club Length");

    panel.add(heightLabel);
    panel.add(heightField);
    panel.add(wristLabel);
    panel.add(wristField);
    panel.add(calculateButton);
    panel.add(resultLabel);

    // Adding the action listener to the button (for button clicks)
    calculateButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            try {
                double height = Double.parseDouble(heightField.getText());
                double wrist = Double.parseDouble(wristField.getText());
                double clubLength = calculateClubLength(height, wrist);
                resultLabel.setText("Club Length: " + clubLength + "inches");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please Enter a Valid Number:");
            }

        }
    });

    // Adding Panel to the frame
    frame.add(panel, BorderLayout.CENTER);

    //Display for the frame
    frame.setVisible(true);
}

// Formula for demonstration
 private double calculateClubLength(double height, double wrist){
        return (height + wrist) / 2;


}

}
