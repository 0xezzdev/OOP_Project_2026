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
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

    }
//    public static void userInterface() {
//        JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(800, 600);
//        frame.setResizable(false);
//        frame.setLocationRelativeTo(null);
//        frame.setBackground(Color.WHITE);
//
//        Graphics g
//        for( Drawable shape : shapes ) {
//            if(shape != null) {
//                shape.draw(,);
//            }
//        }
//
//    }
}