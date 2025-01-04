public class Point extends AbstractShape implements CollisionDetector {
    private float x;
    private float y;
    private static int numInstances = 0;

    public Point() {
        this.x = 0;
        this.y = 0;
        numInstances++;
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
        numInstances++;
    }

    public int getNumberOfInstances() {
        return numInstances;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
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

    // point <> point intersection
    // a point intersects another point
    // if they have the same x, y coords
    public boolean intersect(Point s) {
        if (this.x == s.getX() && this.y == s.getY()) {
            return true;
        }
        return false;
    }

    // point <> line seg intersection
    // a point intersects a line seg
    // if the point's y coord is equal
    // to the value when you plug x into
    // the line's slope-intercept equation
    public boolean intersect(LineSeg s) {
        // find the slope
        float m = (s.getEnd().getY() - s.getBegin().getY()) / (s.getEnd().getX() - s.getBegin().getX());
        // find the intercept
        float b = s.getEnd().getY() - (m * s.getEnd().getX());

        // now use slope-intercept equation to
        // determine whether the point intersects
        if (this.y == m * this.x + b) {
            if ((s.getBegin().x <= this.x && this.x <= s.getEnd().x) && (s.getBegin().y <= this.y && this.y <= s.getEnd().y)) {
                return true;
            }
        }
        return false;
    }

    // point <> rectangle intersection
    // the intuition on the math behind
    // this one gets into some really
    // complicated linear algebra. I referenced this
    // https://math.stackexchange.com/a/190373
    // for a lin-alg based formula to
    // determine intersections
    public boolean intersect(Rectangle s) {
        // the concept: a point M is inside
        // or falls on the edge of a rectangle
        // if and only if (0<=AM⋅AB<=AB⋅AB)∧(0<=AM⋅AD<=AD⋅AD)
        // where A, B, D are points of the rectangle
        Point AM = vector(s.getTopLeft(), this);
        Point AB = vector(s.getTopLeft(), s.getTopRight());
        Point AD = vector(s.getTopLeft(), s.getBottomLeft());

        float AMdotAB = dotProduct(AM, AB);
        float ABdotAB = dotProduct(AB, AB);
        float AMdotAD = dotProduct(AM, AD);
        float ADdotAD = dotProduct(AD, AD);

        if ((0 <= AMdotAB && AMdotAB <= ABdotAB) && (0 <= AMdotAD && AMdotAD <= ADdotAD)) {
            return true;
        }
        return false;
    }

    // point <> circle intersection
    // a point intersects with a circle
    // if the distance between the point
    // and the center of the circle is
    // less than / equal to the circle's radius
    // otherwise, the point falls outside
    public boolean intersect(Circle s) {
        // calculate distance
        double d = Math.pow((Math.pow((this.getX() - s.getCenter().getX()), 2) + Math.pow((this.getY() - s.getCenter().getY()), 2)), 0.5);

        if (d <= s.getRadius()) {
            return true;
        }
        return false;
    }
}
