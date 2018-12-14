public class Vector {
    public String sDirect;
    public double direction;
    public double positionX;
    public double positionY;
    public Vector() {}
    
    public Vector(double x, double  y, String d, double s) {
        positionX = x;
        positionY = y;
        sDirect = d;
        direction = s;
    }
}