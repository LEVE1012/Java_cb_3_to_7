public abstract class Geometric {
    // 属性：颜色和是否填充
    private String color;
    private boolean filled;

    // 无参构造方法
    public Geometric() {
        this.color = "white"; // 默认颜色
        this.filled = false;   // 默认不填充
    }

    // 带参数的构造方法
    public Geometric(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    // 获取颜色
    public String getColor() {
        return color;
    }

    // 设置颜色
    public void setColor(String color) {
        this.color = color;
    }

    // 检查是否填充
    public boolean isFilled() {
        return filled;
    }

    // 设置是否填充
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    // 抽象方法：获取面积
    public abstract double getArea();

    // 抽象方法：获取周长
    public abstract double getPerimeter();

    // 返回类的字符串描述
    @Override
    public String toString() {
        return "Geometric[color=" + color + ", filled=" + filled + "]";
    }
    
    public static void main(String[] args) {
        // 创建 Circle 对象
        Circle circle = new Circle(5);
        System.out.println(circle);

        // 创建 Rectangle 对象
        Rectangle rectangle = new Rectangle(2, 4);
        System.out.println(rectangle);

        // 创建 Triangle 对象
        Triangle triangle = new Triangle(3, 4, 5);
        System.out.println(triangle);
    }
}

// Circle 类
class Circle extends Geometric {
    private double radius;

    // 无参构造方法
    public Circle() {
        this.radius = 1.0;
    }

    // 带指定半径的构造方法
    public Circle(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative.");
        }
        this.radius = radius;
    }

    // 获取半径
    public double getRadius() {
        return radius;
    }

    // 设置半径
    public void setRadius(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative.");
        }
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle[radius=" + radius + ", area=" + getArea() + ", perimeter=" + getPerimeter() + "]";
    }

}

// Rectangle 类
class Rectangle extends Geometric {
    private double side1;
    private double side2;

    // 无参构造方法
    public Rectangle() {
        this.side1 = 1.0;
        this.side2 = 1.0;
    }

    // 带指定边长的构造方法
    public Rectangle(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    // 获取 side1
    public double getSide1() {
        return side1;
    }

    // 设置 side1
    public void setSide1(double side1) {
        this.side1 = side1;
    }

    // 获取 side2
    public double getSide2() {
        return side2;
    }

    // 设置 side2
    public void setSide2(double side2) {
        this.side2 = side2;
    }

    @Override
    public double getArea() {
        return side1 * side2;
    }

    @Override
    public double getPerimeter() {
        return 2 * (side1 + side2);
    }

    @Override
    public String toString() {
        return "Rectangle[side1=" + side1 + ", side2=" + side2 + ", area=" + getArea() + ", perimeter=" + getPerimeter() + "]";
    }
    
}

class Triangle extends Geometric {

    // 属性：三条边
    private double side1;
    private double side2;
    private double side3;

    // 无参构造方法
    public Triangle() {
        this.side1 = 1.0;
        this.side2 = 1.0;
        this.side3 = 1.0;
    }

    // 带参数的构造方法
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    
    // 获取side1
    public double getSide1() {
        return side1;
    }

    // 设置side1
    public void setSide1(double side1) {
        this.side1 = side1;
    }

    // 获取side2
    public double getSide2() {
        return side2;
    }

    // 设置side2
    public void setSide2(double side2) {
        this.side2 = side2;
    }

    // 获取side3
    public double getSide3() {
        return side3;
    }

    // 设置side3
    public void setSide3(double side3) {
        this.side3 = side3;
    }

    // 判断是否能构成三角形
    public boolean isTriangle() {
        return (side1 + side2 > side3) && (side1 + side3 > side2) && (side2 + side3 > side1);
    }

    // 计算面积（海伦公式）
    @Override
    public double getArea() {
        if (!isTriangle()) {
            return 0;
        }
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    // 计算周长
    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    // 返回字符串描述
    @Override
    public String toString() {
        return "Triangle[side1=" + side1 + ", side2=" + side2 + ", side3=" + side3 + ", color=" + getColor() + ", filled=" + isFilled() + "]";
    }
}
