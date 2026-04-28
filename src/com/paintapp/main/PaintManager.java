package com.paintapp.main;

import com.paintapp.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PaintManager {
    private static final Scanner sc = new Scanner(System.in);
    private static final Random rand = new Random();

    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();

        System.out.println("=== CHƯƠNG TRÌNH QUẢN LÝ HÌNH HỌC ===");
        System.out.println("1. Tự nhập thông số");
        System.out.println("2. Sinh ngẫu nhiên (Random)");
        int choice = inputInt("Lựa chọn của bạn (1-2): ", 1, 2);

        if (choice == 1) {
            inputManually(shapes);
        } else {
            generateRandomly(shapes);
        }

        System.out.println("\n--- Danh sách các hình ---");
        for (Shape s : shapes) {
            System.out.printf("%-10s | Tâm: %-15s | Diện tích: %.2f\n",
                    s.getClass().getSimpleName(), s.getCenter(), s.getArea());
        }

        if (!shapes.isEmpty()) {
            Shape maxAreaShape = shapes.get(0);
            for (Shape s : shapes) {
                if (s.getArea() > maxAreaShape.getArea()) maxAreaShape = s;
            }
            System.out.println("\n=> Hình có diện tích lớn nhất: " + maxAreaShape.getClass().getSimpleName()
                    + " (S = " + String.format("%.2f", maxAreaShape.getArea()) + ")");
        }
    }

    private static void inputManually(List<Shape> shapes) {
        int n = inputInt("Bạn muốn nhập bao nhiêu hình? ", 1, 100);
        for (int i = 0; i < n; i++) {
            System.out.println("\nHình thứ " + (i + 1) + ":");
            System.out.println("0: Hình tròn, 1: Hình chữ nhật, 2: Hình tam giác");
            int type = inputInt("Chọn loại hình: ", 0, 2);

            double x = inputDouble("Nhập tọa độ X của tâm: ");
            double y = inputDouble("Nhập tọa độ Y của tâm: ");

            switch (type) {
                case 0:
                    double r = inputDouble("Nhập bán kính (phải > 0): ", 0.0001, Double.MAX_VALUE);
                    shapes.add(new Circle(new Point(x, y), r));
                    break;
                case 1:
                    double w = inputDouble("Nhập chiều rộng: ", 0.0001, Double.MAX_VALUE);
                    double h = inputDouble("Nhập chiều cao: ", 0.0001, Double.MAX_VALUE);
                    shapes.add(new Rectangle(new Point(x, y), w, h));
                    break;
                case 2:
                    System.out.println("Nhập 3 điểm cho Tam giác (điểm 1 đã lấy từ tọa độ tâm trên):");
                    double x2 = inputDouble("Tọa độ X điểm 2: ");
                    double y2 = inputDouble("Tọa độ Y điểm 2: ");
                    double x3 = inputDouble("Tọa độ X điểm 3: ");
                    double y3 = inputDouble("Tọa độ Y điểm 3: ");
                    shapes.add(new Triangle(new Point(x, y), new Point(x2, y2), new Point(x3, y3)));
                    break;
            }
        }
    }

    private static void generateRandomly(List<Shape> shapes) {
        int numberOfShapes = rand.nextInt(6) + 5;
        for (int i = 0; i < numberOfShapes; i++) {
            int type = rand.nextInt(3);
            double x = rand.nextInt(100);
            double y = rand.nextInt(100);
            if (type == 0) shapes.add(new Circle(new Point(x, y), 1 + rand.nextDouble() * 10));
            else if (type == 1) shapes.add(new Rectangle(new Point(x, y), 1 + rand.nextDouble() * 20, 1 + rand.nextDouble() * 20));
            else shapes.add(new Triangle(new Point(x, y), new Point(x + 10, y), new Point(x, y + 10)));
        }
        System.out.println("Đã sinh ngẫu nhiên " + numberOfShapes + " hình.");
    }


    private static int inputInt(String prompt, int min, int max) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(sc.nextLine());
                if (value >= min && value <= max) return value;
                System.out.println("Vui lòng nhập trong khoảng từ " + min + " đến " + max);
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập một số nguyên hợp lệ!");
            }
        }
    }

    private static double inputDouble(String prompt) {
        return inputDouble(prompt, -Double.MAX_VALUE, Double.MAX_VALUE);
    }

    private static double inputDouble(String prompt, double min, double max) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = Double.parseDouble(sc.nextLine());
                if (value >= min && value <= max) return value;
                System.out.println("Giá trị không hợp lệ (Phải từ " + min + " đến " + max + ")");
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập một số thực hợp lệ!");
            }
        }
    }
}