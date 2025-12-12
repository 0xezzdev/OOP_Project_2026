import interfaces.Drawable;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class DrowController {
    private static Drawable[] shapes;
    private static double totalSum = 0;

    public static void drawShapes(File file) {
        calculateSumOfAreas(file);
        userInterface();
    }

    public static void userInterface() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(true);
        frame.setLayout(new BorderLayout());
        frame.setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel("OOP Project by: Ezzeldeen");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        frame.add(titleLabel, BorderLayout.NORTH);

        DrawingPanel panel = new DrawingPanel(shapes);

        JScrollPane scrollPane = new JScrollPane(panel);

        scrollPane.getVerticalScrollBar().setUnitIncrement(20);

        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setSize(1000, 700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static boolean saveSumToTextFile(File inputFile) {
        try {
            PrintWriter writer = new PrintWriter("sumAreas.txt");
            writer.print("Sum Of Areas = ");
            writer.println(calculateSumOfAreas(inputFile));
            writer.close();
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    public static double calculateSumOfAreas(File inputFile) {
        try {
            Scanner input = new Scanner(inputFile);
            totalSum = 0;
            if (input.hasNextInt()) {
                int size = input.nextInt();
                shapes = new Drawable[size];
                for (int i = 0; i < size; i++) {
                    String shapeType = input.next();
                    double value = input.nextDouble();
                    switch (shapeType) {
                        case "circle":
                            shapes[i] = new Circle(value);
                            totalSum += ((Shape) shapes[i]).getArea();
                            break;
                        case "cube":
                            shapes[i] = new Cube(value);
                            totalSum += ((Shape) shapes[i]).getArea();
                            break;
                        default:
                            System.err.println("Invalid shape type " + shapeType);
                            shapes[i] = null;
                            i--;
                    }

                }
                return totalSum;
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Cannot read file: " + e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }
}