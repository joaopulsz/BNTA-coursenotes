public class Rectangle {

    float length;
    float width;

    public Rectangle(float length, float width) {
        this.length = length;
        this.width = width;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getPerimeter() {
        return 2 * length + 2 * width;
    };

    public float getArea() {
        return length * width;
    };

    public double getDiagonal() {
        return Math.sqrt(Math.pow(length, 2) + Math.pow(width, 2));
    }
}
