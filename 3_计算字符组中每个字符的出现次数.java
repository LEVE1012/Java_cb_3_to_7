import java.util.HashMap;

public class CharacterCount {
    
    // 方法：计算字符数组中每个字符出现的次数
    public static void countCharacters(char[] array) {
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        
        // 遍历字符数组并统计每个字符的出现次数
        for (char c : array) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        
        // 输出每个字符及其出现次数
        for (char key : charCountMap.keySet()) {
            System.out.println("字符 '" + key + "' 出现次数: " + charCountMap.get(key));
        }
    }

    public static void main(String[] args) {
        char[] inputArray = {'a', 'b', 'c', 'a', 'b', 'a', 'd'};
        
        countCharacters(inputArray); // 调用方法，统计字符出现次数
    }
}
