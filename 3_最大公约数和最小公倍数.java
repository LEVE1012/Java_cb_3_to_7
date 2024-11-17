public class GCDAndLCM {

    // 方法：计算最大公约数 (GCD)
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 方法：计算最小公倍数 (LCM)
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        int num1 = 12;
        int num2 = 18;

        System.out.println("最大公约数: " + gcd(num1, num2));
        System.out.println("最小公倍数: " + lcm(num1, num2));
    }
}
