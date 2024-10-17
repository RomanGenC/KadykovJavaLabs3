public class Lab4Task1 {
    public static void main(String[] args) {
        Drawing drawing = new Drawing(10);

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

class Drawing{
    private Shape[] shapes;
    private int count;

    public Drawing(int capacity) {
        shapes = new Shape[capacity];
        count = 0;
    }

    public boolean addShape(Shape shape) {
        if (count < shapes.length) {
            shapes[count++] = shape;
            return true;
        }
        return false;
    }

    public Shape popShape() {
        if (count > 0) {
            Shape removedShape = shapes[--count];
            shapes[count] = null;
            return removedShape;
        }
        return null;
    }

    public void countShapes() {
        int circles = 0, squares = 0, triangles = 0;

        for (int i = 0; i < count; i++) {
            if (shapes[i] instanceof Circle) {
                circles++;
            } else if (shapes[i] instanceof Square) {
                squares++;
            } else if (shapes[i] instanceof Triangle) {
                triangles++;
            }
        }

        System.out.println("Кругов: " + circles);
        System.out.println("Квадратов: " + squares);
        System.out.println("Треугольников: " + triangles);
    }

    public double getTotalArea() {
        double totalArea = 0;
        for (int i = 0; i < count; i++) {
            totalArea += shapes[i].getArea();
        }
        return totalArea;
    }

    public void printAllShapes() {
        for (int i = 0; i < count; i++) {
            shapes[i].printInfo();
        }
    }
}
