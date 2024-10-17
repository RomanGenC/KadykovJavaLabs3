public class Point3D extends Point {
    private int z;

    public Point3D() {
        super(0, 0);
        this.z = 0;
    }

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public void setLocation(int x, int y, int z) {
        super.setLocation(x, y);
        this.z = z;
    }

    public int getZ() {
        return z;
    }

    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + "," + z + ")";
    }

    @Override
    public double distanceFromOrigin() {
        return Math.sqrt(getX() * getX() + getY() * getY() + z * z);
    }

    public boolean isInBox(Point3D corner1, Point3D corner2) {
        return (getX() >= Math.min(corner1.getX(), corner2.getX()) && getX() <= Math.max(corner1.getX(), corner2.getX()) &&
                getY() >= Math.min(corner1.getY(), corner2.getY()) && getY() <= Math.max(corner1.getY(), corner2.getY()) &&
                z >= Math.min(corner1.getZ(), corner2.getZ()) && z <= Math.max(corner1.getZ(), corner2.getZ()));
    }

    public boolean isInSphere(Point3D center, double radius) {
        int dx = this.getX() - center.getX();
        int dy = this.getY() - center.getY();
        int dz = this.z - center.z;
        double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);
        return distance <= radius;
    }

    private double distanceFromOrigin(Point3D other) {
        return Math.sqrt(Math.pow(getX() - other.getX(), 2) +
                Math.pow(getY() - other.getY(), 2) +
                Math.pow(z - other.getZ(), 2));
    }

    public double angleFromOrigin(Point3D other) {
        double deltaX = other.getX() - getX();
        double deltaY = other.getY() - getY();
        double deltaZ = other.getZ() - z;
        return Math.atan2(Math.sqrt(deltaY * deltaY + deltaX * deltaX), deltaZ);
    }
}
