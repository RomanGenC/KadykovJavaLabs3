import java.util.ArrayList;

public class Lab4Task1 {
    public static void main(String[] args) {
        Drawing drawing = new Drawing();

        drawing.addShape(new Circle(5));
        drawing.addShape(new Square(4));
        drawing.addShape(new Triangle(6, 3));

        System.out.println("Общая площадь: " + drawing.getTotalArea());
        drawing.printAllShapes();
        drawing.countShapes();

        drawing.popShape();
        System.out.println("После удаления одной фигуры:");
        drawing.printAllShapes();
        drawing.countShapes();
    }
}

abstract class Shape {
    private String name;

    public Shape(String name) {this.name = name;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public abstract double getArea();

    public void printInfo(){
        System.out.println("Фигура: " + name + ", Площадь: " + getArea());
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }

    public double getRadius() {return radius;}
    public void setRadius(double radius) {this.radius = radius;}

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

class Square extends Shape {
    private double side;

    public Square(double side) {
        super("Square");
        this.side = side;
    }

    public double getSide() {return side;}
    public void setSide(double side) {this.side = side;}

    @Override
    public double getArea() {
        return side * side;
    }
}

class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        super("Triangle");
        this.base = base;
        this.height = height;
    }

    public double getBase() {return base;}
    public void setBase(double base) {this.base = base;}

    public double getHeight() {return height;}
    public void setHeight(double height) {this.height = height;}

    @Override
    public double getArea() {
        return (base * height) / 2;
    }
}

class Drawing {
    private ArrayList<Shape> shapes;

    public Drawing() {
        shapes = new ArrayList<>();
    }

    public boolean addShape(Shape shape) {
        return shapes.add(shape);
    }

    public Shape popShape() {
        if (!shapes.isEmpty()) {
            return shapes.remove(shapes.size() - 1);
        }
        return null;
    }

    public void countShapes() {
        int circles = 0, squares = 0, triangles = 0;

        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                circles++;
                continue;
            }

            if (shape instanceof Square) {
                squares++;
                continue;
            }

            triangles++;
        }

        System.out.println("Кругов: " + circles);
        System.out.println("Квадратов: " + squares);
        System.out.println("Треугольников: " + triangles);
    }

    public double getTotalArea() {
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.getArea();
        }
        return totalArea;
    }

    public void printAllShapes() {
        for (Shape shape : shapes) {
            shape.printInfo();
        }
    }
}
