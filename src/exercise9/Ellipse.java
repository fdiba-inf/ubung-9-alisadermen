package exercise9;

public class Ellipse {
    private Point startingPoint;
    private double a;
    private double b;

    public Ellipse() {
        this.startingPoint = new Point(0, 0);
        this.a = 1;
        this.b = 1;
    }

    public Ellipse(Point startingPoint, double a, double b) {
        this.startingPoint = new Point(startingPoint);
        this.a = a;
        this.b = b;
    }

    public Ellipse(Ellipse otherEllipse) {
        this.startingPoint = new Point(otherEllipse.startingPoint);
        this.a = otherEllipse.a;
        this.b = otherEllipse.b;
    }
    public boolean isValid() {

        return a > 0 && b > 0;
    }

    public void initialize() {
        do {
            System.out.println("Initialize start point: ");
            startingPoint.initialize();
            System.out.print("Enter a value for a: ");
            this.a = Utils.INPUT.nextDouble();
            System.out.print("Enter a value for b: ");
            this.b = Utils.INPUT.nextDouble();
        } while (!isValid());
    }

    public double calculatePerimeter() {
        return Math.PI * (3*(a+b)-Math.sqrt((3*a+b)*(a+3*b)));
    }

    public double calculateArea() {

        return Math.PI*a*b;
    }

    public String getType() {
        return (a == b) ? "Circle" : "Ellipse";
    }
    public String toString() {
        return String.format("%s-[%s, %s], %s, P=%s, A=%s", startingPoint, a, b, getType(), calculatePerimeter(), calculateArea());
    }

    public boolean equals(Ellipse otherEllipse) {
        boolean sameA = Utils.equals(this.a, otherEllipse.a);
        boolean sameB = Utils.equals(this.b, otherEllipse.b);
        boolean sameAReversed = Utils.equals(this.a, otherEllipse.b);
        boolean sameBReversed = Utils.equals(this.b, otherEllipse.a);

        return ((sameA && sameB) || (sameAReversed && sameBReversed));
    }
}
