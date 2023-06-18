import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExamSeatingArrangement {
    private JFrame frame;
    private JLabel totalStudentsLabel;
    private JTextField totalStudentsTextField;
    private JButton arrangeButton;
    private JTextArea seatingArrangementTextArea;

    public ExamSeatingArrangement() {
        // Create the main frame
        frame = new JFrame("Exam Seating Arrangement");

        // Create the components
        totalStudentsLabel = new JLabel("Total Students:");
        totalStudentsTextField = new JTextField(10);
        arrangeButton = new JButton("Arrange");
        seatingArrangementTextArea = new JTextArea(20, 30);

        // Set up the layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.add(totalStudentsLabel);
        panel.add(totalStudentsTextField);
        panel.add(arrangeButton);

        // Add action listener to the arrange button
        arrangeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int totalStudents = Integer.parseInt(totalStudentsTextField.getText());

                // Perform seating arrangement
                String seatingArrangement = arrangeSeating(totalStudents);

                // Display the seating arrangement
                seatingArrangementTextArea.setText(seatingArrangement);
            }
        });

        // Create scroll pane for the seating arrangement text area
        JScrollPane scrollPane = new JScrollPane(seatingArrangementTextArea);

        // Set up the main frame
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private String arrangeSeating(int totalStudents) {
        StringBuilder seatingArrangement = new StringBuilder();

        // Perform your seating arrangement logic here
        // You can customize the logic based on your requirements

        // Example logic: Assign each student a seat number sequentially
        for (int i = 1; i <= totalStudents; i++) {
            seatingArrangement.append("Student ").append(i).append(": Seat ").append(i).append("\n");
        }

        return seatingArrangement.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ExamSeatingArrangement();
            }
        });
    }
}
