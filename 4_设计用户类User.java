public class User {
    // 类的变量
    private String username;
    private String password;
    private static int userCount = 0;  // 记录用户数量

    // 无参构造方法
    public User() {
        userCount++;  // 每次创建新用户时，用户数量加1
    }

    // 只为用户名赋值的构造方法
    public User(String username) {
        this.username = username;
        userCount++;  // 每次创建新用户时，用户数量加1
    }

    // 为用户名和密码赋值的构造方法
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        userCount++;  // 每次创建新用户时，用户数量加1
    }

    // 获取密码的方法
    public String getPassword() {
        return password;
    }

    // 设置密码的方法
    public void setPassword(String password) {
        this.password = password;
    }

    // 返回类信息的方法
    public String getUserInfo() {
        return "用户名: " + username + ", 密码: " + password;
    }

    // 返回当前用户数量的方法
    public static int getUserCount() {
        return userCount;
    }

    public static void main(String[] args) {
        // 创建用户对象
        User user1 = new User("Alice", "password123");
        User user2 = new User("Bob", "password456");

        // 输出用户信息
        System.out.println(user1.getUserInfo());  // 输出: 用户名: Alice, 密码: password123
        System.out.println(user2.getUserInfo());  // 输出: 用户名: Bob, 密码: password456

        // 设置并获取密码
        user1.setPassword("newPassword123");
        System.out.println("更新后的密码: " + user1.getPassword());  // 输出: 更新后的密码: newPassword123

        // 输出当前用户数量
        System.out.println("当前用户数量: " + User.getUserCount());  // 输出: 当前用户数量: 2
    }
}
