public class Main {
    public static void main(String[] args) {
        // Create two new points
        Point p1_l1 = new Point();
        Point p2_l1 = new Point(4, 4);
        // Create a line segment using the two points
        LineSeg l1 = new LineSeg(p1_l1, p2_l1);
        // Create four new points (corners of the rectangle)
        Point p1_r1 = new Point(-4, -4);
        Point p2_r1 = new Point(-4, 4);
        Point p3_r1 = new Point(4, -4);
        Point p4_r1 = new Point(4, 4);
        // Create a new rectangle using the four points
        Rectangle r1 = new Rectangle(p1_r1, p2_r1, p3_r1, p4_r1);
        // Check the intersectsion status between the line segment l1 and the rectangle r1
        // And store the value (true/false) in the variable status
        boolean status_r1_intersects_l1 = l1.intersect(r1);
        // Print out the result of the intersection
        System.out.println(status_r1_intersects_l1);
    }
}