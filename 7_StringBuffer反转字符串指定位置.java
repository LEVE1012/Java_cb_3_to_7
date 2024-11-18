public class StringReverser {

    // 方法：反转字符串指定起始和结束位置之间的子字符串
    public static String reverseSubstring(String str, int start, int end) {
        if (str == null || start < 0 || end >= str.length() || start >= end) {
            throw new IllegalArgumentException("Invalid start or end indices");
        }

        // 创建一个 StringBuffer 对象
        StringBuffer buffer = new StringBuffer(str);
        // 将指定位置的子字符串进行反转
        buffer.replace(start, end + 1, new StringBuffer(buffer.substring(start, end + 1)).reverse().toString());

        return buffer.toString();
    }

    // 测试方法
    public static void main(String[] args) {
        String original = "Hello, World!";
        int start = 7;
        int end = 11;

        // 运行测试
        String result = reverseSubstring(original, start, end);
        System.out.println("Original: " + original);
        System.out.println("Modified: " + result);
    }
}
