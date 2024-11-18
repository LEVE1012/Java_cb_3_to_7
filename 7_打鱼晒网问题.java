public class FishingNetCheck {
    public static void main(String[] args) {
        // Start date: January 1, 1990
        // Target date: January 1, 2016

        // Calculate total number of days between the two dates
        int startYear = 1990;
        int endYear = 2016;
        int totalDays = 0;

        for (int year = startYear; year < endYear; year++) {
            // Check if the year is a leap year
            if (isLeapYear(year)) {
                totalDays += 366;
            } else {
                totalDays += 365;
            }
        }

        // Determine the activity on January 1, 2016
        // The cycle is 5 days long: 3 days fishing, 2 days net drying
        String[] cycle = {"Fishing", "Fishing", "Fishing", "Net Drying", "Net Drying"};
        String activityOnTargetDate = cycle[totalDays % 5];

        System.out.println("On January 1, 2016, the activity is: " + activityOnTargetDate);
    }

    // Helper method to check if a year is a leap year
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    }
}
