import static org.junit.Assert.*;
import org.junit.Test;

public class A2Test {
    // Testing Point <> Point
    @Test
    public void testPointPoint1(){
        Point point1 = new Point();
        Point point2 = new Point(4, 4);
        assertEquals(false, point1.intersect(point2));
    }

    @Test
    public void testPointPoint2(){
        Point point1 = new Point();
        Point point2 = new Point();
        assertEquals(true, point1.intersect(point2));
    }

    @Test
    public void testPointPoint3(){
        Point point1 = new Point(0.5f, 0.3f);
        Point point2 = new Point(0.7f, 0.6f);
        assertEquals(false, point1.intersect(point2));
    }


    @Test
    public void testPointPoint4(){
        Point point1 = new Point(0.00000000f, 0.00000f);
        Point point2 = new Point(0.0f, 0);
        assertEquals(true, point2.intersect(point1));
    }

    @Test
    public void testPointPoint5(){
        Point point1 = new Point(999999999, 999999999);
        Point point2 = new Point(999999999, 999999999);
        assertEquals(true, point2.intersect(point1));
    }

    // Testing Point <> Line Seg
    @Test
    public void testPointLineSeg1(){
        Point point1 = new Point();
        Point point2 = new Point();
        LineSeg line1 = new LineSeg(point1, point2);
        assertEquals(false, point1.intersect(line1));
    }

    @Test
    public void testPointLineSeg2(){
        Point point1 = new Point(2, 7);
        Point point2 = new Point(8, 9);
        LineSeg line1 = new LineSeg(point1, point2);
        Point point3  = new Point(5, 8);
        assertEquals(true, point3.intersect(line1));
    }

    @Test
    public void testPointLineSeg3(){
        Point point1 = new Point(5, 5);
        Point point2 = new Point(10, 5);
        LineSeg line1 = new LineSeg(point1, point2);
        Point point3 = new Point(6, 5);
        assertEquals(true, point3.intersect(line1));
    }

    @Test
    public void testPointLineSeg4(){
        Point point1 = new Point(0, 0);
        Point point2 = new Point(10, 10);
        LineSeg line1 = new LineSeg(point1, point2);
        Point point3 = new Point(7.5f, 7.5f);
        assertEquals(true, point3.intersect(line1));
    }

    @Test
    public void testPointLineSeg5(){
        Point point1 = new Point(5, 5);
        Point point2 = new Point(10, 5);
        LineSeg line1 = new LineSeg(point1, point2);
        Point point3 = new Point(8.5f, 6);
        assertEquals(false, point3.intersect(line1));
    }

    // Testing Point <> Rectangle
    @Test
    public void testPointRectangle1(){
        Point r1 = new Point(-4, -4);
        Point r2 = new Point(-4, 4);
        Point r3 = new Point(4, -4);
        Point r4 = new Point(4, 4);

        Point testPoint = new Point(0, 0);
        // Create a new rectangle using the four points
        Rectangle rect1 = new Rectangle(r1, r2, r3, r4);
        assertEquals(true, testPoint.intersect(rect1));
    }

    @Test
    public void testPointRectangle2(){
        Point r1 = new Point(-4, -4);
        Point r2 = new Point(-4, 4);
        Point r3 = new Point(4, -4);
        Point r4 = new Point(4, 4);

        Point testPoint = new Point(8, 8);
        // Create a new rectangle using the four points
        Rectangle rect1 = new Rectangle(r1, r2, r3, r4);
        assertEquals(false, testPoint.intersect(rect1));
    }

    @Test
    public void testPointRectangle3(){
        Point r1 = new Point(-4, -4);
        Point r2 = new Point(-4, 4);
        Point r3 = new Point(4, -4);
        Point r4 = new Point(4, 4);

        Point testPoint = new Point(-4, -4);
        // Create a new rectangle using the four points
        Rectangle rect1 = new Rectangle(r1, r2, r3, r4);
        assertEquals(true, testPoint.intersect(rect1));
    }

    @Test
    public void testPointRectangle4(){
        Point r1 = new Point(999999999, 999999999);
        Point r2 = new Point(999999999, 999999999);
        Point r3 = new Point(999999999, 999999999);
        Point r4 = new Point(999999999, 999999999);

        Point testPoint = new Point(0, 0);
        // Create a new rectangle using the four points
        Rectangle rect1 = new Rectangle(r1, r2, r3, r4);
        assertEquals(true, testPoint.intersect(rect1));
    }

    @Test
    public void testPointRectangle5(){
        Point r1 = new Point(0, 0);
        Point r2 = new Point(0, 0);
        Point r3 = new Point(0, 0);
        Point r4 = new Point(0, 0);

        Point testPoint = new Point(0, 0);
        // Create a new rectangle using the four points
        Rectangle rect1 = new Rectangle(r1, r2, r3, r4);
        assertEquals(true, testPoint.intersect(rect1));
    }

    // Testing Point <> Circle
    @Test
    public void testPointCircle1(){
        Point center = new Point(0, 0);
        Circle circle = new Circle(center, 5);
        Point testPoint = new Point(5, 6);
        assertEquals(false, testPoint.intersect(circle));
    }

    @Test
    public void testPointCircle2(){
        Point center = new Point(0, 0);
        Circle circle = new Circle(center, 5);
        Point testPoint = new Point(1, 1);
        assertEquals(true, testPoint.intersect(circle));
    }

    @Test
    public void testPointCircle3(){
        Point center = new Point(0, 0);
        Circle circle = new Circle(center, 5);
        Point testPoint = new Point(1, 1);
        assertEquals(true, testPoint.intersect(circle));
    }

    @Test
    public void testPointCircle4(){
        Point center = new Point(0, 0);
        Circle circle = new Circle(center, 5);
        Point testPoint = new Point(1, 1);
        assertEquals(true, testPoint.intersect(circle));
    }

    @Test
    public void testPointCircle5() {
        Point center = new Point(3, 4);
        Circle circle = new Circle(center, 5);
        Point testPoint = new Point(3, 9);
        assertEquals(true, testPoint.intersect(circle));
    }

    // Testing Line Segment <> Point
    @Test
    public void testLineSegPoint1() {
        Point point1 = new Point(5, 5);
        Point point2 = new Point(10, 5);
        LineSeg line1 = new LineSeg(point1, point2);
        Point point3 = new Point(6, 5);
        assertEquals(true, line1.intersect(point3));
    }

    @Test
    public void testLineSegPoint2() {
        Point point1 = new Point();
        Point point2 = new Point();
        LineSeg line1 = new LineSeg(point1, point2);
        Point point3 = new Point(0, 0);
        assertEquals(false, line1.intersect(point3));
    }

    @Test
    public void testLineSegPoint3() {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(10, 10);
        LineSeg line1 = new LineSeg(point1, point2);
        Point point3 = new Point(6, 5);
        assertEquals(false, line1.intersect(point3));
    }

    @Test
    public void testLineSegPoint4() {
        Point point1 = new Point(5, 5);
        Point point2 = new Point(5, 10);
        LineSeg line1 = new LineSeg(point1, point2);
        Point point3 = new Point(5, 7);
        assertEquals(true, line1.intersect(point3));
    }

    @Test
    public void testLineSegPoint5() {
        Point point1 = new Point();
        Point point2 = new Point();
        LineSeg line1 = new LineSeg(point1, point2);
        Point point3 = new Point();
        assertEquals(false, line1.intersect(point3));
    }

    // Testing Line Segment <> Line Segment
    @Test
    public void testLineSegLineSeg1() {
        Point point1 = new Point(5, 5);
        Point point2 = new Point(10, 10);
        LineSeg line1 = new LineSeg(point1, point2);

        Point point3 = new Point(10, 0);
        Point point4= new Point(6, 12);
        LineSeg line2 = new LineSeg(point3, point4);

        assertEquals(true, line1.intersect(line2));
    }

    @Test
    public void testLineSegLineSeg2() {
        Point point1 = new Point(5, 5);
        Point point2 = new Point(5, 10);
        LineSeg line1 = new LineSeg(point1, point2);

        Point point3 = new Point(3, 7);
        Point point4= new Point(8, 7);
        LineSeg line2 = new LineSeg(point3, point4);

        assertEquals(true, line1.intersect(line2));
    }

    @Test
    public void testLineSegLineSeg3() {
        Point point1 = new Point();
        Point point2 = new Point();
        LineSeg line1 = new LineSeg(point1, point2);

        Point point3 = new Point();
        Point point4= new Point();
        LineSeg line2 = new LineSeg(point3, point4);

        assertEquals(false, line1.intersect(line2));
    }

    @Test
    public void testLineSegLineSeg4() {
        Point point1 = new Point(5, 5);
        Point point2 = new Point(5, 10);
        LineSeg line1 = new LineSeg(point1, point2);

        Point point3 = new Point(5, 5);
        Point point4= new Point(5, 10);
        LineSeg line2 = new LineSeg(point3, point4);

        assertEquals(true, line1.intersect(line2));
    }

    @Test
    public void testLineSegLineSeg5() {
        Point point1 = new Point(3, 7);
        Point point2 = new Point(8, 7);
        LineSeg line1 = new LineSeg(point1, point2);

        Point point3 = new Point(3, 7);
        Point point4= new Point(8, 7);
        LineSeg line2 = new LineSeg(point3, point4);

        assertEquals(true, line1.intersect(line2));
    }

    // Testing Line Segment <> Rectangle
    @Test
    public void testLineSegRectangle1() {
        Point point1 = new Point(0, -5);
        Point point2 = new Point(0, 5);
        LineSeg line1 = new LineSeg(point1, point2);

        Point p1_r1 = new Point(-4, -4);
        Point p2_r1 = new Point(-4, 4);
        Point p3_r1 = new Point(4, -4);
        Point p4_r1 = new Point(4, 4);

        Rectangle r1 = new Rectangle(p1_r1, p2_r1, p3_r1, p4_r1);
        assertEquals(true, line1.intersect(r1));
    }

    @Test
    public void testLineSegRectangle2() {
        Point point1 = new Point(4, 4);
        Point point2 = new Point(4, -4);
        LineSeg line1 = new LineSeg(point1, point2);

        Point p1_r1 = new Point(-4, -4);
        Point p2_r1 = new Point(-4, 4);
        Point p3_r1 = new Point(4, -4);
        Point p4_r1 = new Point(4, 4);

        Rectangle r1 = new Rectangle(p1_r1, p2_r1, p3_r1, p4_r1);
        assertEquals(true, line1.intersect(r1));
    }

    @Test
    public void testLineSegRectangle3() {
        Point point1 = new Point(4, -4);
        Point point2 = new Point(-4, 4);
        LineSeg line1 = new LineSeg(point1, point2);

        Point p1_r1 = new Point(-4, -4);
        Point p2_r1 = new Point(-4, 4);
        Point p3_r1 = new Point(4, -4);
        Point p4_r1 = new Point(4, 4);

        Rectangle r1 = new Rectangle(p1_r1, p2_r1, p3_r1, p4_r1);
        assertEquals(true, line1.intersect(r1));
    }

    @Test
    public void testLineSegRectangle4() {
        Point point1 = new Point(0, -5);
        Point point2 = new Point(0, 5);
        LineSeg line1 = new LineSeg(point1, point2);

        Point p1_r1 = new Point();
        Point p2_r1 = new Point();
        Point p3_r1 = new Point();
        Point p4_r1 = new Point();

        Rectangle r1 = new Rectangle(p1_r1, p2_r1, p3_r1, p4_r1);
        assertEquals(false, line1.intersect(r1));
    }

    @Test
    public void testLineSegRectangle5() {
        Point point1 = new Point(1, 1);
        Point point2 = new Point(-1, -1);
        LineSeg line1 = new LineSeg(point1, point2);

        Point p1_r1 = new Point(0, 0);
        Point p2_r1 = new Point(0, 0);
        Point p3_r1 = new Point(0, 0);
        Point p4_r1 = new Point(0, 0);

        Rectangle r1 = new Rectangle(p1_r1, p2_r1, p3_r1, p4_r1);
        assertEquals(true, line1.intersect(r1));
    }

    // Testing Line Segment <> Circle
    @Test
    public void testLineSegCircle1() {
        Point point1 = new Point(1, 1);
        Point point2 = new Point(-1, -1);
        LineSeg line1 = new LineSeg(point1, point2);

        Point center = new Point(0, 0);
        Circle circle = new Circle(center, 5);
        assertEquals(true, line1.intersect(circle));
    }

    @Test
    public void testLineSegCircle2() {
        Point point1 = new Point(3, 3);
        Point point2 = new Point(-4, -3);
        LineSeg line1 = new LineSeg(point1, point2);

        Point center = new Point(0, 0);
        Circle circle = new Circle(center, 5);
        assertEquals(true, line1.intersect(circle));
    }

    @Test
    public void testLineSegCircle3() {
        Point point1 = new Point(0, 15);
        Point point2 = new Point(10, 15);
        LineSeg line1 = new LineSeg(point1, point2);

        Point center = new Point(5, 5);
        Circle circle = new Circle(center, 5);
        assertEquals(false, line1.intersect(circle));
    }

    @Test
    public void testLineSegCircle4() {
        Point point1 = new Point(1, 1);
        Point point2 = new Point(-1, -1);
        LineSeg line1 = new LineSeg(point1, point2);

        Point center = new Point(5, 5);
        Circle circle = new Circle(center, 0);
        assertEquals(false, line1.intersect(circle));
    }

    @Test
    public void testLineSegCircle5() {
        Point point1 = new Point();
        Point point2 = new Point();
        LineSeg line1 = new LineSeg(point1, point2);

        Point center = new Point(0, 0);
        Circle circle = new Circle(center, 0);
        assertEquals(false, line1.intersect(circle));
    }

    // Testing Rectangle <> Point
    @Test
    public void testRectanglePoint1() {
        Point p1_r1 = new Point(4, 4);
        Point p2_r1 = new Point(4, -4);
        Point p3_r1 = new Point(-4, -4);
        Point p4_r1 = new Point(-4, 4);
        Rectangle r1 = new Rectangle(p1_r1, p2_r1, p3_r1, p4_r1);

        Point testPoint = new Point(4, 4);
        assertEquals(true, r1.intersect(testPoint));
    }

    @Test
    public void testRectanglePoint2() {
        Point p1_r1 = new Point(4, 4);
        Point p2_r1 = new Point(4, -4);
        Point p3_r1 = new Point(-4, -4);
        Point p4_r1 = new Point(-4, 4);
        Rectangle r1 = new Rectangle(p1_r1, p2_r1, p3_r1, p4_r1);

        Point testPoint = new Point();
        assertEquals(false, r1.intersect(testPoint));
    }

    @Test
    public void testRectanglePoint3() {
        Point p1_r1 = new Point();
        Point p2_r1 = new Point();
        Point p3_r1 = new Point();
        Point p4_r1 = new Point();
        Rectangle r1 = new Rectangle(p1_r1, p2_r1, p3_r1, p4_r1);

        Point testPoint = new Point(4, 4);
        assertEquals(false, r1.intersect(testPoint));
    }

    @Test
    public void testRectanglePoint4() {
        Point p1_r1 = new Point(5, 5);
        Point p2_r1 = new Point(10, 10);
        Point p3_r1 = new Point(7, 2);
        Point p4_r1 = new Point(12, 7);
        Rectangle r1 = new Rectangle(p1_r1, p2_r1, p3_r1, p4_r1);

        Point testPoint = new Point(0, 0);
        assertEquals(false, r1.intersect(testPoint));
    }

    @Test
    public void testRectanglePoint5() {
        Point p1_r1 = new Point(5, 5);
        Point p2_r1 = new Point(10, 10);
        Point p3_r1 = new Point(7, 2);
        Point p4_r1 = new Point(12, 7);
        Rectangle r1 = new Rectangle(p1_r1, p2_r1, p3_r1, p4_r1);

        Point testPoint = new Point(9, 6);
        assertEquals(true, r1.intersect(testPoint));
    }

    // Testing Rectangle <> Line Segment
    @Test
    public void testRectangleLineSeg1() {
        Point p1_r1 = new Point(5, 5);
        Point p2_r1 = new Point(10, 10);
        Point p3_r1 = new Point(7, 2);
        Point p4_r1 = new Point(12, 7);
        Rectangle r1 = new Rectangle(p1_r1, p2_r1, p3_r1, p4_r1);

        Point point1 = new Point();
        Point point2 = new Point();
        LineSeg line1 = new LineSeg(point1, point2);

        assertEquals(false, r1.intersect(line1));
    }

    @Test
    public void testRectangleLineSeg2() {
        Point p1_r1 = new Point(4, 4);
        Point p2_r1 = new Point(-4, 4);
        Point p3_r1 = new Point(4, -4);
        Point p4_r1 = new Point(-4, -4);
        Rectangle r1 = new Rectangle(p1_r1, p2_r1, p3_r1, p4_r1);

        Point point1 = new Point(-10, 0);
        Point point2 = new Point(13, 0);
        LineSeg line1 = new LineSeg(point1, point2);

        assertEquals(true, r1.intersect(line1));
    }

    @Test
    public void testRectangleLineSeg3() {
        Point p1_r1 = new Point(4, 4);
        Point p2_r1 = new Point(-4, 4);
        Point p3_r1 = new Point(4, -4);
        Point p4_r1 = new Point(-4, -4);
        Rectangle r1 = new Rectangle(p1_r1, p2_r1, p3_r1, p4_r1);

        Point point1 = new Point(4, 4);
        Point point2 = new Point(-4, 4);
        LineSeg line1 = new LineSeg(point1, point2);

        assertEquals(true, r1.intersect(line1));
    }

    @Test
    public void testRectangleLineSeg4() {
        Point p1_r1 = new Point();
        Point p2_r1 = new Point();
        Point p3_r1 = new Point();
        Point p4_r1 = new Point();
        Rectangle r1 = new Rectangle(p1_r1, p2_r1, p3_r1, p4_r1);

        Point point1 = new Point(-10, 0);
        Point point2 = new Point(13, 0);
        LineSeg line1 = new LineSeg(point1, point2);

        assertEquals(false, r1.intersect(line1));
    }

    @Test
    public void testRectangleLineSeg5() {
        Point p1_r1 = new Point(4, 4);
        Point p2_r1 = new Point(-4, 4);
        Point p3_r1 = new Point(4, -4);
        Point p4_r1 = new Point(-4, -4);
        Rectangle r1 = new Rectangle(p1_r1, p2_r1, p3_r1, p4_r1);

        Point point1 = new Point(0, 0);
        Point point2 = new Point(10, 10);
        LineSeg line1 = new LineSeg(point1, point2);

        assertEquals(true, r1.intersect(line1));
    }

    // Testing Rectangle <> Rectangle
    @Test
    public void testRectangleRectangle1() {
        Point p1_r1 = new Point(4, 4);
        Point p2_r1 = new Point(-4, 4);
        Point p3_r1 = new Point(4, -4);
        Point p4_r1 = new Point(-4, -4);
        Rectangle r1 = new Rectangle(p1_r1, p2_r1, p3_r1, p4_r1);

        Point p1_r2 = new Point(4, 4);
        Point p2_r2 = new Point(-4, 4);
        Point p3_r2 = new Point(4, -4);
        Point p4_r2 = new Point(-4, -4);
        Rectangle r2 = new Rectangle(p1_r2, p2_r2, p3_r2, p4_r2);

        assertEquals(true, r1.intersect(r2));
    }

    @Test
    public void testRectangleRectangle2() {
        Point p1_r1 = new Point(4, 4);
        Point p2_r1 = new Point(-4, 4);
        Point p3_r1 = new Point(4, -4);
        Point p4_r1 = new Point(-4, -4);
        Rectangle r1 = new Rectangle(p1_r1, p2_r1, p3_r1, p4_r1);

        Point p1_r2 = new Point(-10, 0);
        Point p2_r2 = new Point(-10, 10);
        Point p3_r2 = new Point(0, 0);
        Point p4_r2 = new Point(0, 10);
        Rectangle r2 = new Rectangle(p1_r2, p2_r2, p3_r2, p4_r2);

        assertEquals(true, r1.intersect(r2));
    }

    @Test
    public void testRectangleRectangle3() {
        Point p1_r1 = new Point(4, 4);
        Point p2_r1 = new Point(-4, 4);
        Point p3_r1 = new Point(4, -4);
        Point p4_r1 = new Point(-4, -4);
        Rectangle r1 = new Rectangle(p1_r1, p2_r1, p3_r1, p4_r1);

        Point p1_r2 = new Point();
        Point p2_r2 = new Point();
        Point p3_r2 = new Point();
        Point p4_r2 = new Point();
        Rectangle r2 = new Rectangle(p1_r2, p2_r2, p3_r2, p4_r2);

        assertEquals(false, r1.intersect(r2));
    }

    @Test
    public void testRectangleRectangle4() {
        Point p1_r1 = new Point();
        Point p2_r1 = new Point();
        Point p3_r1 = new Point();
        Point p4_r1 = new Point();
        Rectangle r1 = new Rectangle(p1_r1, p2_r1, p3_r1, p4_r1);

        Point p1_r2 = new Point();
        Point p2_r2 = new Point();
        Point p3_r2 = new Point();
        Point p4_r2 = new Point();
        Rectangle r2 = new Rectangle(p1_r2, p2_r2, p3_r2, p4_r2);

        assertEquals(false, r1.intersect(r2));
    }

    @Test
    public void testRectangleRectangle5() {
        Point p1_r1 = new Point(4, 4);
        Point p2_r1 = new Point(-4, 4);
        Point p3_r1 = new Point(4, -4);
        Point p4_r1 = new Point(-4, -4);
        Rectangle r1 = new Rectangle(p1_r1, p2_r1, p3_r1, p4_r1);

        Point p1_r2 = new Point(2, 2);
        Point p2_r2 = new Point(-2, 2);
        Point p3_r2 = new Point(2, -2);
        Point p4_r2 = new Point(-2, -2);
        Rectangle r2 = new Rectangle(p1_r2, p2_r2, p3_r2, p4_r2);

        assertEquals(true, r1.intersect(r2));
    }

    // Testing Rectangle <> Circle
    @Test
    public void testRectangleCircle1() {
        Point p1_r1 = new Point(4, 4);
        Point p2_r1 = new Point(-4, 4);
        Point p3_r1 = new Point(4, -4);
        Point p4_r1 = new Point(-4, -4);
        Rectangle r1 = new Rectangle(p1_r1, p2_r1, p3_r1, p4_r1);

        Point center = new Point(0, 0);
        Circle circle = new Circle(center, 4);
        assertEquals(true, r1.intersect(circle));
    }

    @Test
    public void testRectangleCircle2() {
        Point p1_r1 = new Point(4, 4);
        Point p2_r1 = new Point(-4, 4);
        Point p3_r1 = new Point(4, -4);
        Point p4_r1 = new Point(-4, -4);
        Rectangle r1 = new Rectangle(p1_r1, p2_r1, p3_r1, p4_r1);

        Point center = new Point(0, 0);
        Circle circle = new Circle(center, 7);
        assertEquals(true, r1.intersect(circle));
    }

    @Test
    public void testRectangleCircle3() {
        Point p1_r1 = new Point(4, 4);
        Point p2_r1 = new Point(-4, 4);
        Point p3_r1 = new Point(4, -4);
        Point p4_r1 = new Point(-4, -4);
        Rectangle r1 = new Rectangle(p1_r1, p2_r1, p3_r1, p4_r1);

        Point center = new Point(5, 5);
        Circle circle = new Circle(center, 5);
        assertEquals(true, r1.intersect(circle));
    }

    @Test
    public void testRectangleCircle4() {
        Point p1_r1 = new Point(4, 4);
        Point p2_r1 = new Point(-4, 4);
        Point p3_r1 = new Point(4, -4);
        Point p4_r1 = new Point(-4, -4);
        Rectangle r1 = new Rectangle(p1_r1, p2_r1, p3_r1, p4_r1);

        Point center = new Point(9, 9);
        Circle circle = new Circle(center, 5);
        assertEquals(false, r1.intersect(circle));
    }

    @Test
    public void testRectangleCircle5() {
        Point p1_r1 = new Point(4, 4);
        Point p2_r1 = new Point(-4, 4);
        Point p3_r1 = new Point(4, -4);
        Point p4_r1 = new Point(-4, -4);
        Rectangle r1 = new Rectangle(p1_r1, p2_r1, p3_r1, p4_r1);

        Point center = new Point();
        Circle circle = new Circle(center, 0);
        assertEquals(false, r1.intersect(circle));
    }

    // Testing Circle <> Point
    @Test
    public void testCirclePoint1() {
        Point center = new Point(5, 5);
        Circle circle = new Circle(center, 5);

        Point testPoint = new Point(5, 5);
        assertEquals(true, circle.intersect(testPoint));
    }

    @Test
    public void testCirclePoint2() {
        Point center = new Point(5, 5);
        Circle circle = new Circle(center, 5);

        Point testPoint = new Point(15, 15);
        assertEquals(false, circle.intersect(testPoint));
    }

    @Test
    public void testCirclePoint3() {
        Point center = new Point();
        Circle circle = new Circle(center, 0);

        Point testPoint = new Point(0, 0);
        assertEquals(false, circle.intersect(testPoint));
    }

    @Test
    public void testCirclePoint4() {
        Point center = new Point(0, 0);
        Circle circle = new Circle(center, 999999999);

        Point testPoint = new Point(15, 15);
        assertEquals(true, circle.intersect(testPoint));
    }

    @Test
    public void testCirclePoint5() {
        Point center = new Point(0, 0);
        Circle circle = new Circle(center, 1);

        Point testPoint = new Point(1, 0);
        assertEquals(true, circle.intersect(testPoint));
    }

    // Testing Circle <> Line Segment
    @Test
    public void testCircleLineSeg1() {
        Point center = new Point(0, 0);
        Circle circle = new Circle(center, 5);

        Point point1 = new Point(0, 0);
        Point point2 = new Point(5, 5);
        LineSeg line1 = new LineSeg(point1, point2);

        assertEquals(true, circle.intersect(line1));
    }

    @Test
    public void testCircleLineSeg2() {
        Point center = new Point(0,0);
        Circle circle = new Circle(center, 5);

        Point point1 = new Point(-5, -5);
        Point point2 = new Point(5, 5);
        LineSeg line1 = new LineSeg(point1, point2);

        assertEquals(true, circle.intersect(line1));
    }

    @Test
    public void testCircleLineSeg3() {
        Point center = new Point();
        Circle circle = new Circle(center, 0);

        Point point1 = new Point(-5, -5);
        Point point2 = new Point(5, 5);
        LineSeg line1 = new LineSeg(point1, point2);

        assertEquals(false, circle.intersect(line1));
    }

    @Test
    public void testCircleLineSeg4() {
        Point center = new Point(0, 0);
        Circle circle = new Circle(center, 5);

        Point point1 = new Point(0, 10);
        Point point2 = new Point(0, -5);
        LineSeg line1 = new LineSeg(point1, point2);

        assertEquals(true, circle.intersect(line1));
    }

    @Test
    public void testCircleLineSeg5() {
        Point center = new Point(5, 5);
        Circle circle = new Circle(center, 5);

        Point point1 = new Point(0, 10);
        Point point2 = new Point(0, -5);
        LineSeg line1 = new LineSeg(point1, point2);

        assertEquals(true, circle.intersect(line1));
    }

    // Testing Circle <> Rectangle
    @Test
    public void testCircleRectangle1() {
        Point p1_r1 = new Point(4, 4);
        Point p2_r1 = new Point(-4, 4);
        Point p3_r1 = new Point(4, -4);
        Point p4_r1 = new Point(-4, -4);
        Rectangle r1 = new Rectangle(p1_r1, p2_r1, p3_r1, p4_r1);

        Point center = new Point(5, 5);
        Circle circle = new Circle(center, 5);

        assertEquals(true, circle.intersect(r1));
    }

    @Test
    public void testCircleRectangle2() {
        Point p1_r1 = new Point(4, 4);
        Point p2_r1 = new Point(-4, 4);
        Point p3_r1 = new Point(4, -4);
        Point p4_r1 = new Point(-4, -4);
        Rectangle r1 = new Rectangle(p1_r1, p2_r1, p3_r1, p4_r1);

        Point center = new Point(9, 5);
        Circle circle = new Circle(center, 5);

        assertEquals(true, circle.intersect(r1));
    }

    @Test
    public void testCircleRectangle3() {
        Point p1_r1 = new Point();
        Point p2_r1 = new Point();
        Point p3_r1 = new Point();
        Point p4_r1 = new Point();
        Rectangle r1 = new Rectangle(p1_r1, p2_r1, p3_r1, p4_r1);

        Point center = new Point();
        Circle circle = new Circle(center, 0);

        assertEquals(false, circle.intersect(r1));
    }

    @Test
    public void testCircleRectangle4() {
        Point p1_r1 = new Point(4, 4);
        Point p2_r1 = new Point(-4, 4);
        Point p3_r1 = new Point(4, -4);
        Point p4_r1 = new Point(-4, -4);
        Rectangle r1 = new Rectangle(p1_r1, p2_r1, p3_r1, p4_r1);

        Point center = new Point(5, 5);
        Circle circle = new Circle(center, 5);

        assertEquals(true, circle.intersect(r1));
    }

    @Test
    public void testCircleRectangle5() {
        Point p1_r1 = new Point(5, 5);
        Point p2_r1 = new Point(10, 10);
        Point p3_r1 = new Point(7, 2);
        Point p4_r1 = new Point(12, 7);
        Rectangle r1 = new Rectangle(p1_r1, p2_r1, p3_r1, p4_r1);

        Point center = new Point(9, 5);
        Circle circle = new Circle(center, 5);

        assertEquals(true, circle.intersect(r1));
    }

    // Testing Circle <> Circle
    @Test
    public void testCircleCircle1() {
        Point center1 = new Point(9, 5);
        Circle circle1 = new Circle(center1, 5);

        Point center2 = new Point(9, 5);
        Circle circle2 = new Circle(center2, 6);

        assertEquals(true, circle1.intersect(circle2));
    }

    @Test
    public void testCircleCircle2() {
        Point center1 = new Point(0, 0);
        Circle circle1 = new Circle(center1, 5);

        Point center2 = new Point(11, 0);
        Circle circle2 = new Circle(center2, 6);

        assertEquals(true, circle1.intersect(circle2));
    }

    @Test
    public void testCircleCircle3() {
        Point center1 = new Point(0, 0);
        Circle circle1 = new Circle(center1, 5);

        Point center2 = new Point(0, 0);
        Circle circle2 = new Circle(center2, 5);

        assertEquals(true, circle1.intersect(circle2));
    }

    @Test
    public void testCircleCircle4() {
        Point center1 = new Point(9, 5);
        Circle circle1 = new Circle(center1, 5);

        Point center2 = new Point(5, 0);
        Circle circle2 = new Circle(center2, 6);

        assertEquals(true, circle1.intersect(circle2));
    }

    @Test
    public void testCircleCircle5() {
        Point center1 = new Point();
        Circle circle1 = new Circle(center1, 0);

        Point center2 = new Point();
        Circle circle2 = new Circle(center2, 0);

        assertEquals(false, circle1.intersect(circle2));
    }
}
