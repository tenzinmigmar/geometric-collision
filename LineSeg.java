public class LineSeg extends AbstractShape implements CollisionDetector {

    private Point begin;
    private Point end;
    private static int numInstances = 0;

    public LineSeg() {
        numInstances++;
    }
    public LineSeg(Point begin, Point end) {
        try {
            if (begin.getX() == end.getX() && begin.getY() == end.getY()) {
                throw new ShapeArgumentException("Line segment with coincided begin and end points");
            }
            this.begin = begin;
            this.end = end;
            numInstances++;
        } catch (ShapeArgumentException e) {
            System.out.println("ShapeArgumentException in constructing " + this.getClass().getSimpleName());
        }
    }

    public int getNumberOfInstances() {
        return numInstances;
    }

    public Point getBegin() {
        return this.begin;
    }

    public Point getEnd() {
        return this.end;
    }

    // line seg <> point intersection
    // a point intersects a line seg
    // if the point's y coord is equal
    // to the value when you plug x into
    // the line's slope-intercept equation
    public boolean intersect(Point s) {
        // find the slope first
        float m = (this.getEnd().getY() - this.getBegin().getY()) / (this.getEnd().getX() - this.getBegin().getX());
        // find the intercept
        float b = this.getEnd().getY() - (m * this.getEnd().getX());

        // now use slope-intercept equation to
        // determine whether the point intersects
        if (s.getY() == m * s.getX() + b) {
            if ((this.getBegin().getX() <= s.getX() && s.getX() <= this.getEnd().getX()) && (this.getBegin().getY() <= s.getY() && s.getY() <= this.getEnd().getY())) {
                return true;
            }
        }
        return false;
    }

    // line seg <> line seg intersection
    // there are several ways to test line to
    // line intersection, one of them is to
    // calculate the distance to the point of
    // intersection and then check if the distance
    // is in the range of 0-1
    public boolean intersect(LineSeg s) {
        float xOne = this.getBegin().getX();
        float yOne = this.getBegin().getY();
        float xTwo = this.getEnd().getX();
        float yTwo = this.getEnd().getY();
        float xThree = s.getBegin().getX();
        float yThree = s.getBegin().getY();
        float xFour = s.getEnd().getX();
        float yFour = s.getEnd().getY();

        float denom = (xOne - xTwo) * (yThree - yFour) - (yOne - yTwo) * (xThree - xFour);

        if (denom == 0) {
            return false;
        }

        float distanceOne = ((xOne - xThree) * (yThree - yFour) - (yOne - yThree) * (xThree - xFour)) / denom;
        float distanceTwo = -((xOne - xTwo) * (yOne - yThree) - (yOne - yTwo) * (xOne - xThree)) / denom;

        return (distanceOne >= 0 && distanceOne <= 1 && distanceTwo >= 0 && distanceTwo <= 1);
    }


    // line seg <> rectangle intersection
    // since a rectangle is just a shape made
    // up of four line borders, we can just
    // reuse the line to line intersection
    // method to check if a line has intersected
    // a rectangle by checking if any of the 4
    // lines making up a rectangle has intersected
    // with the line segment
    public boolean intersect(Rectangle s) {
        LineSeg line1 = new LineSeg(s.getTopLeft(), s.getTopRight());
        LineSeg line2 = new LineSeg(s.getBottomLeft(), s.getBottomRight());
        LineSeg line3 = new LineSeg(s.getTopLeft(), s.getBottomLeft());
        LineSeg line4 = new LineSeg(s.getTopRight(), s.getBottomRight());

        // check line <> line intersection
        if (intersect(line1) || intersect(line2) || intersect(line3) || intersect(line4)) {
            return true;
        }
        return false;
    }

    // line seg <> circle intersection
    // to determine if a circle intersects with
    // a line segment, we can compute the discriminant
    // r^2(d_r)^2 - D^2 where r is the radius, d_r
    // is the length of the line segment, D is the
    // discriminant of the line segment's points
    // in the matrix [x1 x2 y1 y2]
    // reference: https://mathworld.wolfram.com/Circle-LineIntersection.html
    public boolean intersect(Circle s) {
        float dx = this.getEnd().getX() - this.getBegin().getX();
        float dy = this.getEnd().getY() - this.getEnd().getY();

        float dr = (float)Math.pow(Math.pow(dx, 2) + Math.pow(dy, 2), 0.5);
        float D = this.getBegin().getX() * this.getEnd().getY() - this.getEnd().getX() * this.getBegin().getY();

        double discriminant = (Math.pow(s.getRadius(), 2) * Math.pow(dr, 2)) - Math.pow(D, 2);

        if (discriminant >= 0) {
            return true;
        }
        return false;
    }
}
