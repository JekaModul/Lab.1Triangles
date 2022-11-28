package  bsu.lab1.main;
import bsu.lab1.triangle.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] types = new String[]{"arbitrary", "equilateral", "equally",
                "rectangular", "equally and rectangular"};
        ArrayList<Triangle> trianglesType = new ArrayList<>();

        System.out.println("Enter count of triangles: ");
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();

        Triangle[] triangles = createTriangle(count);

        //считаем периметр и площадь
        calculatePerimeterAndSquare(triangles);

        //для каждого типа создаём ArrayList
        //находим все нужные данные
        createAndFind(triangles, trianglesType, types);
    }

    private static void calculatePerimeterAndSquare(Triangle[] triangles) {
        for (Triangle triangle : triangles) {
            triangle.calculate();
            System.out.println("---------------------------------------" + '\n'
                    + triangle + '\n' + "Perimeter: " + triangle.getPerimeter()
                    + '\n' + "Square: " + triangle.getSquare() + " " + triangle.getType());
            System.out.println("---------------------------------------" + '\n');
        }
    }

    public static Triangle[] createTriangle(int count){
        Triangle[] triangles = new Triangle[count];
        for (int i = 0; i < count; i++) {
            triangles[i] = new Triangle();
        }

        for (int i = 0; i < count; i++) {
            triangles[i].setPoint();
        }
        return triangles;
    }

    public static void createAndFind(Triangle[] triangles, ArrayList<Triangle> trianglesType,
                                     String[] types){
        int index = 0;
        while (index < 4) {
            for (Triangle triangle : triangles) {
                if (triangle.getType().equals(types[index])) {
                    trianglesType.add(triangle);
                }
                if (index == 2 && triangle.getType().equals(types[1])||
                        index == 2 && triangle.getType().equals(types[4])){
                    trianglesType.add(triangle);
                }
                if (index == 3 && triangle.getType().equals(types[4])){
                    trianglesType.add(triangle);
                }
            }

            if (trianglesType.size() != 0) {
                findMaxMin(trianglesType, types[index]);
            }
            index++;
            trianglesType.clear();
        }
    }

    public static void findMaxMin(ArrayList<Triangle> trianglesType, String type) {

        double MaxPer = 0;
        Triangle end = new Triangle();
        for (Triangle triangle : trianglesType) {
            if (triangle.getPerimeter() > MaxPer) {
                MaxPer = triangle.getPerimeter();
                end = triangle;
            }
        }
        if (!trianglesType.isEmpty()) {
            end.calculate();
            System.out.println("Max perimeter of " + type + " type: " +
                    end + '\n' + end.getPerimeter());
        }

        double MinPer = end.getPerimeter();
        Triangle end0 = new Triangle();
        for (Triangle triangle : trianglesType) {
            if (triangle.getPerimeter() <= MinPer) {
                MinPer = triangle.getPerimeter();
                end0 = triangle;
            }
        }

        if (!trianglesType.isEmpty()){
            end0.calculate();
            System.out.println("Min perimeter of " + type + " type: " +
                    end0 + '\n' + end0.getPerimeter());
        }

        double MaxSquare = 0;
        for (Triangle triangle : trianglesType) {
            if (triangle.getSquare() > MaxSquare) {
                MaxSquare = triangle.getSquare();
                end = triangle;
            }
        }

        if (!trianglesType.isEmpty()) {
            end.calculate();
            System.out.println("Max square of " + type + " type: " +
                    end + '\n' + end.getSquare());
        }

        double MinSquare = end0.getSquare();
        for (Triangle triangle : trianglesType) {
            if (triangle.getSquare() <= MinSquare) {
                MinSquare = triangle.getSquare();
                end0 = triangle;
            }
        }

        if (!trianglesType.isEmpty()) {
            end0.calculate();
            System.out.println("Min square of " + type + " type: " +
                    end0 + '\n' + end0.getSquare());
        }
        System.out.println("------------------------------");
    }
}
