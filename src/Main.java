import interfaces.Drawable;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    private static Drawable[] shapes;
    public static void main(String[] args) {
        try {
            File readFrom = new File("input.txt");
            Scanner input = new Scanner(readFrom);
            PrintWriter writer = new PrintWriter("sumAreas.txt");
            writer.print("Sum Of Areas = ");
            double sum = 0;
            int size = input.nextInt();
            shapes = new Drawable[size];
            for (int i = 0; i < size; i++) {
                String shapeType = input.next();
                double value = input.nextDouble();
                switch (shapeType) {
                    case "circle":
                        shapes[i] = new Circle(value);
                        sum += ((Shape) shapes[i]).getArea();
                        break;
                    case "cube":
                        shapes[i] = new Cube(value);
                        sum += ((Shape) shapes[i]).getArea();
                        break;
                        default:
                            System.err.println("Invalid shape type "+ shapeType);
                            shapes[i] = null;
                            i--;
                }

            }
            writer.println(sum);
            writer.close();
            userInterface(shapes);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

    }
    public static void userInterface(Drawable[] shape) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.WHITE);
        JLabel titleLabel = new JLabel("OOP Project");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        frame.add(titleLabel, BorderLayout.NORTH);

        DrawingPanel panel = new DrawingPanel(shape);
        frame.add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

    }
}