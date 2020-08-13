package Utils;

public class Vec3D {
    double X,Y,Z;

    public Vec3D(double x, double y, double z){
        X = x;
        Y = y;
        Z = z;
    }
    public Vec3D(Point3D point){
        X = point.X;
        Y = point.Y;
        Z = point.Z;
    }

    static public Vec3D cross(Vec3D v1, Vec3D v2){
        double a = v1.Y * v2.Z - v1.Z * v2.Y;
        double b = v1.Z * v2.X - v1.X * v2.Z;
        double c = v1.X * v2.Y - v1.Y * v2.X;
        return new Vec3D(a,b,c);
    }

    static public double dot(Vec3D v1, Vec3D v2){
        return (v1.X*v2.X + v1.Y*v2.Y + v1.Z*v2.Z);
    }

    public double getLength(){
        return Math.sqrt(X*X + Y*Y + Z*Z);
    }
}
