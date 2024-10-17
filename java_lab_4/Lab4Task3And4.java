public class Lab4Task3And4 {
    public static void main(String[] args) {
        // Тестирование методов класса Point
        Point point1 = new Point(3, 4);
        Point point2 = new Point(6, 8);

        System.out.println("Координаты точки 1: " + point1);
        System.out.println("Координаты точки 2: " + point2);
        System.out.println("Расстояние точки 1 от начала координат: " + point1.distanceFromOrigin());
        System.out.println("Расстояние между точками: " + point1.distanceTo(point2));
        System.out.println("Угол между точкой 1 и точкой 2: " + Math.toDegrees(point1.angleFromOrigin(point2)) + " градусов");

        Point topLeft = new Point(0, 5);
        Point bottomRight = new Point(5, 0);
        System.out.println("Находится ли точка 1 внутри прямоугольника: " + point1.isInRectangle(topLeft, bottomRight));

        Point circleCenter = new Point(0, 0);
        double circleRadius = 5;
        System.out.println("Находится ли точка 1 внутри окружности: " + point1.isInCircle(circleCenter, circleRadius));

        System.out.println();

        // Тестирование методов класса Point3D
        Point3D point3D1 = new Point3D(1, 2, 3);
        Point3D point3D2 = new Point3D(4, 5, 6);

        System.out.println("Координаты точки 3D 1: " + point3D1);
        System.out.println("Координаты точки 3D 2: " + point3D2);
        System.out.println("Расстояние точки 3D 1 от начала координат: " + point3D1.distanceFromOrigin());
        System.out.println("Угол между точкой 3D 1 и точкой 3D 2: " + Math.toDegrees(point3D1.angleFromOrigin(point3D2)) + " градусов");

        Point3D corner1 = new Point3D(0, 0, 0);
        Point3D corner2 = new Point3D(5, 5, 5);
        System.out.println("Находится ли точка 3D 1 внутри параллелепипеда: " + point3D1.isInBox(corner1, corner2));

        Point3D sphereCenter = new Point3D(0, 0, 0);
        double sphereRadius = 5;
        System.out.println("Находится ли точка 3D 1 внутри сферы: " + point3D1.isInSphere(sphereCenter, sphereRadius));
    }
}
