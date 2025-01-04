public class Rectangle extends AbstractShape {

    private float left;
    private float right;
    private float top;
    private float bottom;

    private Point topLeft;
    private Point topRight;
    private Point bottomLeft;
    private Point bottomRight;
    private static int numInstances;

    public Rectangle() {
        numInstances++;
    }

    public Rectangle(Point topLeft, Point topRight, Point bottomRight, Point bottomLeft) {
        try {
            if (topLeft.getX() >= topRight.getX() || bottomLeft.getY() >= topRight.getY()) {
                throw new ShapeArgumentException("Left >= right or bottom >= top rectangle not possible.");
            }
            numInstances++;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomRight;
            this.bottomRight = bottomLeft;
        } catch (ShapeArgumentException e) {
            System.out.println("ShapeArgumentException in constructing " + this.getClass().getSimpleName());
        }
    }

    public int getNumberOfInstances() {
        return numInstances;
    }

    public float getLeft() {
        return this.left;
    }

    public float getRight() {
        return this.right;
    }

    public float getTop() {
        return this.top;
    }

    public float getBottom() {
        return this.bottom;
    }

    public Point getTopLeft() {
        return this.topLeft;
    }

    public Point getTopRight() {
        return this.topRight;
    }

    public Point getBottomLeft() {
        return this.bottomLeft;
    }

    public Point getBottomRight() {
        return this.bottomRight;
    }

    // get the vector of two points
    public Point vector(Point s, Point t) {
        Point point = new Point(t.getX() - s.getX(), t.getY() - s.getY());
        return point;
    }

    // get the dot product of two vectors
    public float dotProduct(Point s, Point t) {
        float dot = s.getX() * t.getX() + s.getY() * t.getY();
        return dot;
    }

    // rectangle <> point intersection
    // the intuition on the math behind
    // this one gets into some really
    // complicated linear algebra. I referenced this
    // https://math.stackexchange.com/a/190373
    // for a lin-alg based formula to
    // determine intersections
    public boolean intersect(Point s) {
        // the concept: a point M is inside
        // or falls on the edge of a rectangle
        // if and only if (0<=AM⋅AB<=AB⋅AB)∧(0<=AM⋅AD<=AD⋅AD)
        // where A, B, D are points of the rectangle
        Point AM = vector(this.getTopLeft(), s);
        Point AB = vector(this.getTopLeft(), this.getTopRight());
        Point AD = vector(this.getTopLeft(), this.getBottomLeft());

        float AMdotAB = dotProduct(AM, AB);
        float ABdotAB = dotProduct(AB, AB);
        float AMdotAD = dotProduct(AM, AD);
        float ADdotAD = dotProduct(AD, AD);

        if ((0 <= AMdotAB && AMdotAB <= ABdotAB) && (0 <= AMdotAD && AMdotAD <= ADdotAD)) {
            return true;
        }
        return false;
    }

    // rectangle <> line seg intersection
    // since a rectangle is just a shape made
    // up of four line borders, we can just
    // reuse the line to line intersection
    // method to check if a line has intersected
    // a rectangle by checking if any of the 4
    // lines making up a rectangle has intersected
    // with the line segment
    public boolean intersect(LineSeg s) {
        LineSeg line1 = new LineSeg(this.getTopLeft(), this.getTopRight());
        LineSeg line2 = new LineSeg(this.getBottomLeft(), this.getBottomRight());
        LineSeg line3 = new LineSeg(this.getTopLeft(), this.getBottomLeft());
        LineSeg line4 = new LineSeg(this.getTopRight(), this.getBottomRight());

        // check line <> line intersection
        if (line1.intersect(s) || line2.intersect(s) || line3.intersect(s) || line4.intersect(s)) {
            return true;
        }
        return false;
    }

    // rectangle <> rectangle intersection
    // this method works by comparing the
    // left/right/top/bottom values of both
    // rectangles. two given rectangles only
    // intersect if all comparison conditions
    // are satisfied
    public boolean intersect(Rectangle s) {
        if (this.left <= s.right && s.left <= this.right && this.bottom <= s.top && s.bottom <= this.top) {
            return true;
        }
        return false;
    }

    // rectangle <> circle intersection
    // rectangle to circle intersection only
    // happens in 2 cases: 1) when the circle's
    // center is inside the rectangle OR 2)
    // when one of the rectangle's sides intersects
    // with the circle
    // we can reuse some of the methods that were
    // already coded to come up with this solution
    public boolean intersect(Circle s) {
        LineSeg line1 = new LineSeg(this.getTopLeft(), this.getTopRight());
        LineSeg line2 = new LineSeg(this.getBottomLeft(), this.getBottomRight());
        LineSeg line3 = new LineSeg(this.getTopLeft(), this.getBottomLeft());
        LineSeg line4 = new LineSeg(this.getTopRight(), this.getBottomRight());

        // test rectangle <> point intersect OR
        // circle <> line intersections for each line
        if (intersect(s.getCenter()) || s.intersect(line1) || s.intersect(line2) || s.intersect(line3) || s.intersect(line4)) {
            return true;
        }
        return false;
    }
}
