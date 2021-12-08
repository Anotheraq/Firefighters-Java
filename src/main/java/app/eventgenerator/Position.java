package app.eventgenerator;

public class Position {
    final double x;
    final double y;

    public Position(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override public String toString() {
        return "(X=" + this.x + ", Y=" + this.y + ")";
    }
}
