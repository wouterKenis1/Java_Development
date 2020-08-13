package Utils;

public class Triangle2D {
    Point2D m_p1, m_p2, m_p3;

    public Triangle2D(Point2D p1, Point2D p2, Point2D p3){
        m_p1 = p1;
        m_p2 = p2;
        m_p3 = p3;
    }

    static public boolean isOverlapping(Triangle2D tri1, Triangle2D tri2){
        return false;
    }

    static public boolean isPointInTriangle(Triangle2D triangle, Point2D point){
        return false;
    }
}
