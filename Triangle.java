import java.util.Scanner;

public class Triangle {
    private final Point point1;
    private final Point point2;
    private final Point point3;
    private static double perimeter;
    private static double square;
    private String type = "arbitrary";;

    public Point getPoint1() {
        return point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public Point getPoint3() {
        return point3;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public String getType() {
        return type;
    }

    public double getSquare() {
        return square;
    }

    public Triangle() {
        point1 = new Point();
        point2 = new Point();
        point3 = new Point();
    }

    @Override
    public String toString() {
        return "Triangle: (" +
                point1 + "),(" +
                point2 + "),(" +
                point3 + ")";
    }

    public void setPoint() {
        System.out.println("Enter points:");
        Scanner scan = new Scanner(System.in);
        System.out.println("The first point:");
        int x = scan.nextInt();
        int y = scan.nextInt();
        point1.setX(x);
        point1.setY(y);
        System.out.println("The second point: ");
        x = scan.nextInt();
        y = scan.nextInt();
        point2.setX(x);
        point2.setY(y);
        System.out.println("The third point: ");
        x = scan.nextInt();
        y = scan.nextInt();
        point3.setX(x);
        point3.setY(y);
        if ((point1.getX() == point2.getX() && point1.getX() == point3.getX())||
                point1.getY() == point2.getY() && point1.getY() == point3.getY()){
            System.out.println("It is not a triangle");
        }
    }

    public void calculate() {
        double side1 = Math.sqrt(Math.pow((point1.getX() -
                point2.getX()), 2) +
                (Math.pow((point1.getY() -
                        point2.getY()), 2)));


        double side2 = Math.sqrt(Math.pow((point2.getX() -
                point3.getX()), 2) +
                (Math.pow((point2.getY() -
                        point3.getY()), 2)));


        double side3 = Math.sqrt(Math.pow((point1.getX() -
                point3.getX()), 2) +
                (Math.pow((point1.getY() -
                        point3.getY()), 2)));

        calculateThePerimeter(side1, side2, side3);
        calculateTheSquare(side1, side2, side3, perimeter);
        calculateTheType(side1, side2, side3);
    }

    public void calculateThePerimeter(double side1, double side2, double side3){
        perimeter = side1 + side2 + side3;
    }

    public void calculateTheSquare(double side1, double side2, double side3, double perimeter){
        square = Math.sqrt((perimeter / 2) * ((perimeter / 2) - side1) *
                (perimeter / 2 - side2) * (perimeter / 2 - side3));
    }

    public void calculateTheType(double side1, double side2, double side3){
        if ((side1 == side2) && (side2 == side3) &&
                (side1 == side3)) {
            type = "equilateral"; //равносторонний
        }
        if ((side1 == side2) || (side1 == side3) ||
                (side2 == side3)) {
            if (type.equals("arbitrary")) {
                type = "equally"; //равнобедренный
            }
        }
        if (Math.sqrt(Math.pow(side1, 2) + Math.pow(side2, 2)) == side3 ||
                Math.sqrt(Math.pow(side2, 2) + Math.pow(side3, 2)) == side1 ||
                Math.sqrt(Math.pow(side1, 2) + Math.pow(side3, 2)) == side2) {
            if (type.equals("arbitrary")) {
                type = "rectangular"; //прямоугольный
            } else {
                type = "equally and rectangular"; //равнобедренный и прямоугольный
            }
        }
    }
}

