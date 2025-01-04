public class Circle extends AbstractShape implements  CollisionDetector {
    private Point center;
    private float radius;
    private static int numInstances = 0;

    public Circle() {
        numInstances++;
    }

    public Circle(Point c, float r) {
        try {
            if (r <= 0) {
                throw new ShapeArgumentException("Circle with radius <= 0");
            }
            this.center = c;
            this.radius = r;
            numInstances++;
        } catch (ShapeArgumentException e) {
            System.out.println("ShapeArgumentException in constructing " + this.getClass().getSimpleName());
        }
    }

    public int getNumberOfInstances() {
        return numInstances;
    }

    public Point getCenter() {
        return this.center;
    }

    public float getRadius() {
        return this.radius;
    }

    // circle <> point intersection
    // a point intersects with a circle
    // if the distance between the point
    // and the center of the circle is
    // less than / equal to the circle's radius
    // otherwise, the point falls outside
    public boolean intersect(Point s) {
        double d = Math.pow((Math.pow((s.getX() - this.getCenter().getX()), 2) + Math.pow((s.getY() - this.getCenter().getY()), 2)), 0.5);

        if (d <= this.getRadius()) {
            return true;
        }
        return false;
    }

    // circle <> line seg intersection
    // to determine if a circle intersects with
    // a line segment, we can compute the discriminant
    // r^2(d_r)^2 - D^2 where r is the radius, d_r
    // is the length of the line segment, D is the
    // discriminant of the line segment's points
    // in the matrix [x1 x2 y1 y2]
    // reference: https://mathworld.wolfram.com/Circle-LineIntersection.html
    public boolean intersect(LineSeg s) {
        float dx = s.getEnd().getX() - s.getBegin().getX();
        float dy = s.getEnd().getY() - s.getEnd().getY();

        float dr = (float)Math.pow(Math.pow(dx, 2) + Math.pow(dy, 2), 0.5);
        float D = s.getBegin().getX() * s.getEnd().getY() - s.getEnd().getX() * s.getBegin().getY();

        double discriminant = (Math.pow(this.radius, 2) * Math.pow(dr, 2)) - Math.pow(D, 2);

        if (discriminant >= 0) {
            return true;
        }
        return false;
    }

    // circle <> rectangle intersection
    // circle to rectangle intersection only
    // happens in 2 cases: 1) when the circle's
    // center is inside the rectangle OR 2)
    // when one of the rectangle's sides intersects
    // with the circle
    // we can reuse some of the methods that were
    // already coded to come up with this solution
    public boolean intersect(Rectangle s) {
        LineSeg line1 = new LineSeg(s.getTopLeft(), s.getTopRight());
        LineSeg line2 = new LineSeg(s.getBottomLeft(), s.getBottomRight());
        LineSeg line3 = new LineSeg(s.getTopLeft(), s.getBottomLeft());
        LineSeg line4 = new LineSeg(s.getTopRight(), s.getBottomRight());

        // test rectangle <> point intersect OR
        // circle <> line intersections for each line
        if (this.center.intersect(s) || intersect(line1) || intersect(line2) || intersect(line3) || intersect(line4)) {
            return true;
        }
        return false;

    }

    // circle <> circle intersection
    // a circle intersects with another circle
    // if and only if the sum of their radii or
    // difference of their radii are equal to the
    // distance between the centers of the circles
    // reference: https://www.bbc.co.uk/bitesize/guides/z9pssbk/revision/4#:~:text=To%20do%20this%2C%20you%20need,then%20the%20circles%20touch%20internally.
    // reference: https://www.petercollingridge.co.uk/tutorials/computational-geometry/circle-circle-intersections/
    public boolean intersect(Circle s) {
        double distance = Math.sqrt(Math.pow(s.getCenter().getX() - this.getCenter().getX(), 2) +
                Math.pow(s.getCenter().getY() - this.getCenter().getY(), 2));
        double radiusSum = s.getRadius() + this.radius;
        double radiusDiff = Math.abs(s.getRadius() - this.radius);

        // case 1) circles intersect @ 2 points
        if (distance < radiusSum && distance > radiusDiff) {
            return true;
        }

        // case 2) circles intersect at 1 point
        else if (distance == radiusSum || distance == radiusDiff) {
            return true;
        }
        return false;
    }

}