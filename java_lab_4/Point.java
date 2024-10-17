public class Point {
    private int x;
    private int y;

    public Point() {this(0, 0);}
    public Point(int x, int y) {this.x = x;this.y = y;}

    public void setLocation(int x, int y) {this.x = x;this.y = y;}

    public int getX() {return x;}
    public int getY() {return y;}

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public double distanceFromOrigin() {
        return Math.sqrt(x * x + y * y);
    }

    public boolean isInRectangle(Point topLeft, Point bottomRight) {
        return (x >= topLeft.getX() && x <= bottomRight.getX() &&
                y >= topLeft.getY() && y <= bottomRight.getY());
    }

    public boolean isInCircle(Point center, double radius) {
        return distanceFromOrigin() <= radius;
    }

    public double angleFromOrigin(Point other) {
        double deltaX = other.getX() - x;
        double deltaY = other.getY() - y;
        return Math.atan2(deltaY, deltaX);
    }

    public double distanceTo(Point other) {
        int dx = other.x - this.x;
        int dy = other.y - this.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
