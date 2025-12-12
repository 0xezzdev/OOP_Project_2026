import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.*;

public class ProjectInterface extends JFrame {

    private JLabel selectedFileLabel;
    private File currentFile = null;

    public ProjectInterface() {
        setTitle("Project Launcher - Ezzeldeen");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JLabel titleLabel = new JLabel("Shape Generator Project", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridBagLayout());

        JPanel filePanel = new JPanel(new FlowLayout());
        JButton chooseFileBtn = new JButton("Select Input File (.txt)");
        selectedFileLabel = new JLabel("No file selected");
        selectedFileLabel.setForeground(Color.RED);

        filePanel.add(chooseFileBtn);
        filePanel.add(selectedFileLabel);

        centerPanel.add(filePanel);
        add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton drawBtn = new JButton("Draw Shapes");
        JButton saveBtn = new JButton("Save Sum Of Areas");

        drawBtn.setPreferredSize(new Dimension(120, 40));
        saveBtn.setPreferredSize(new Dimension(150, 40));

        bottomPanel.add(drawBtn);
        bottomPanel.add(saveBtn);
        add(bottomPanel, BorderLayout.SOUTH);


        chooseFileBtn.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setCurrentDirectory(new File("."));
            fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));

            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                currentFile = fileChooser.getSelectedFile();
                selectedFileLabel.setText(currentFile.getName());
                selectedFileLabel.setForeground(new Color(0, 150, 0));
            }
        });

        drawBtn.addActionListener(e -> {
            if (currentFile != null && currentFile.exists()) {
                DrawController.drawShapes(currentFile);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Please select a input file first!",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        saveBtn.addActionListener(e -> {
            if (currentFile != null&&currentFile.exists()) {

                boolean isSaved = DrawController.saveSumToTextFile(currentFile);

                if (isSaved) {
                    JOptionPane.showMessageDialog(this, "sumAreas.txt saved successfully");
                } else {
                    JOptionPane.showMessageDialog(this, "Error to save file", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(this,
                        "Please select a input file first!",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ProjectInterface().setVisible(true);
        });
    }
}