public class AbnormalClass{
    public static void main(String[] args) {
        try {
            // 创建一个合法的三角形
            Triangle triangle1 = new Triangle(3.0, 4.0, 5.0);
            triangle1.printTriangleInfo();

            // 创建一个非法的三角形（任意两边之和小于或等于第三边）
            Triangle triangle2 = new Triangle(1.0, 2.0, 3.0); // 会抛出异常
            triangle2.printTriangleInfo();
        } catch (IllegalTriangleException e) {
            System.out.println("Error: " + e.getMessage());
        }

         try {
            // 使用默认构造方法创建一个圆
            Circle circle1 = new Circle();
            circle1.printCircleInfo();

            // 使用指定半径的构造方法创建一个圆
            Circle circle2 = new Circle(5.0);
            circle2.printCircleInfo();

            // 尝试使用一个无效的半径（负数）
            Circle circle3 = new Circle(-3.0); // 会抛出异常
            circle3.printCircleInfo();
        } catch (InvalidRadiusException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

// 定义InvalidRadiusException异常类
class InvalidRadiusException extends Exception {
    // 构造方法
    public InvalidRadiusException(String message) {
        super(message);
    }
}

// 定义Circle类
class Circle {
    private double radius;

    // 默认构造方法，默认半径为1
    public Circle() {
        this.radius = 1.0;
    }

    // 创建指定半径的构造方法
    public Circle(double radius) throws InvalidRadiusException {
        setRadius(radius);  // 使用setRadius方法验证半径
    }

    // 获取半径的方法
    public double getRadius() {
        return radius;
    }

    // 设置半径的方法，验证半径是否有效
    public void setRadius(double radius) throws InvalidRadiusException {
        if (radius < 0) {
            throw new InvalidRadiusException("Invalid radius: Radius cannot be negative.");
        }
        this.radius = radius;
    }

    // 计算圆的面积
    public double area() {
        return Math.PI * radius * radius;
    }

    // 计算圆的周长
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    // 打印圆的信息
    public void printCircleInfo() {
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + area());
        System.out.println("Perimeter: " + perimeter());
    }
}

// 定义IllegalTriangleException异常类
class IllegalTriangleException extends Exception {
    // 构造方法
    public IllegalTriangleException(String message) {
        super(message);
    }
}

// 定义Triangle类
class Triangle {
    private double side1;
    private double side2;
    private double side3;

    // 构造方法，验证三角形的合法性
    public Triangle(double side1, double side2, double side3) throws IllegalTriangleException {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            throw new IllegalTriangleException("Sides must be positive values.");
        }
        // 验证三角形的合法性，任意两边之和必须大于第三边
        if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1) {
            throw new IllegalTriangleException("Invalid triangle sides: The sum of any two sides must be greater than the third side.");
        }
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // 获取三角形的三边
    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    // 计算三角形的周长
    public double perimeter() {
        return side1 + side2 + side3;
    }

    // 计算三角形的面积（使用海伦公式）
    public double area() {
        double s = perimeter() / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    // 打印三角形的信息
    public void printTriangleInfo() {
        System.out.println("Side 1: " + side1);
        System.out.println("Side 2: " + side2);
        System.out.println("Side 3: " + side3);
        System.out.println("Perimeter: " + perimeter());
        System.out.println("Area: " + area());
    }
}    
