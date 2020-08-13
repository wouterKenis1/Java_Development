package Utils;

public class Vec2D {
    double X,Y;

    public Vec2D(double x, double y){
        X = x;
        Y = y;
    }
    public Vec2D(Point2D point){
        X = point.X;
        Y = point.Y;
    }

    static public double cross(Vec2D v1, Vec2D v2){
        return (v1.X*v2.Y - v1.Y*v2.X);
    }

    static public double dot(Vec2D v1, Vec2D v2){
        return (v1.X*v2.X + v1.Y*v2.Y);
    }

    public double getLength(){
        return Math.sqrt(X*X + Y*Y);
    }
}
