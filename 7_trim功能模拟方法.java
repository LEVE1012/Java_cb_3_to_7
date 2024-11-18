public class CustomTrim {

    // Method to simulate the trim() function
    public static String customTrim(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        int start = 0;
        int end = input.length() - 1;

        // Move start index to the right while it points to a space
        while (start <= end && input.charAt(start) == ' ') {
            start++;
        }
        
        // Move end index to the left while it points to a space
        while (end >= start && input.charAt(end) == ' ') {
            end--;
        }
        
        // Return the trimmed substring
        return input.substring(start, end + 1);
    }

    public static void main(String[] args) {
        // Test cases
        String test1 = "   Hello World!   ";
        String test2 = "NoLeadingOrTrailingSpaces";
        String test3 = "   LeadingOnly";
        String test4 = "TrailingOnly   ";
        String test5 = "      "; // String with only spaces
        String test6 = ""; // Empty string
        
        // Print results
        System.out.println("Test 1: [" + customTrim(test1) + "]");
        System.out.println("Test 2: [" + customTrim(test2) + "]");
        System.out.println("Test 3: [" + customTrim(test3) + "]");
        System.out.println("Test 4: [" + customTrim(test4) + "]");
        System.out.println("Test 5: [" + customTrim(test5) + "]");
        System.out.println("Test 6: [" + customTrim(test6) + "]");
    }
}
