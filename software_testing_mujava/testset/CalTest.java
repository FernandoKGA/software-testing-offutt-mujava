import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalTest {
    @Before
    public void setUp() {
        // Setup code if needed
    }

    @After
    public void tearDown() {
        // Cleanup code if needed
    }

    // Test same month, same day
    @Test
    public void testSameMonthSameDay() {
        int result = Cal.cal(5, 15, 5, 15, 2023);
        assertEquals("Same day should return 0", 0, result);
    }

    // Test same month, different days
    @Test
    public void testSameMonthDifferentDays() {
        int result = Cal.cal(3, 10, 3, 15, 2023);
        assertEquals("March 10 to March 15 should be 5 days", 5, result);
    }

    // Test different month, same days
    @Test
    public void testDifferentMonthSameDays() {
        int result = Cal.cal(3, 10, 4, 10, 2025);
        assertEquals("March 10 to April 10 should be 31 days", 31, result);
    }

    // Test different months in non-leap year
    @Test
    public void testDifferentMonthsNonLeapYear() {
        // January 15 to March 10 in 2023 (non-leap year)
        // Days remaining in January: 31 - 15 = 16
        // Days in February: 28
        // Days in March: 10
        // Total: 16 + 28 + 10 = 54
        int result = Cal.cal(1, 15, 3, 10, 2023);
        assertEquals("Jan 15 to Mar 10 in non-leap year", 54, result);
    }

    // Test different months in leap year
    @Test
    public void testDifferentMonthsLeapYear() {
        // January 15 to March 10 in 2024 (leap year)
        // Days remaining in January: 31 - 15 = 16
        // Days in February: 29 (leap year)
        // Days in March: 10
        // Total: 16 + 29 + 10 = 55
        int result = Cal.cal(1, 15, 3, 10, 2024);
        assertEquals("Jan 15 to Mar 10 in leap year", 55, result);
    }

    // Test February in non-leap year
    @Test
    public void testFebruaryNonLeapYear() {
        // February 1 to February 28 in 2023
        int result = Cal.cal(2, 1, 2, 28, 2023);
        assertEquals("Feb 1 to Feb 28 in non-leap year", 27, result);
    }

    // Test February in leap year
    @Test
    public void testFebruaryLeapYear() {
        // February 1 to February 29 in 2024
        int result = Cal.cal(2, 1, 2, 29, 2024);
        assertEquals("Feb 1 to Feb 29 in leap year", 28, result);
    }

    // Test spanning February in leap year
    @Test
    public void testSpanningFebruaryLeapYear() {
        // January 31 to March 1 in 2024 (leap year)
        // Days remaining in January: 31 - 31 = 0
        // Days in February: 29
        // Days in March: 1
        // Total: 0 + 29 + 1 = 30
        int result = Cal.cal(1, 31, 3, 1, 2024);
        assertEquals("Jan 31 to Mar 1 in leap year", 30, result);
    }

    // Test spanning February in non-leap year
    @Test
    public void testSpanningFebruaryNonLeapYear() {
        // January 31 to March 1 in 2023 (non-leap year)
        // Days remaining in January: 31 - 31 = 0
        // Days in February: 28
        // Days in March: 1
        // Total: 0 + 28 + 1 = 29
        int result = Cal.cal(1, 31, 3, 1, 2023);
        assertEquals("Jan 31 to Mar 1 in non-leap year", 29, result);
    }

    // Test beginning to end of year
    @Test
    public void testBeginningToEndOfYear() {
        // January 1 to December 31 in non-leap year
        int result = Cal.cal(1, 1, 12, 31, 2023);
        assertEquals("Jan 1 to Dec 31 in non-leap year", 364, result);
    }

    // Test beginning to end of leap year
    @Test
    public void testBeginningToEndOfLeapYear() {
        // January 1 to December 31 in leap year
        int result = Cal.cal(1, 1, 12, 31, 2024);
        assertEquals("Jan 1 to Dec 31 in leap year", 365, result);
    }

    // Test century year that is not divisible by 400 (not leap year)
    @Test
    public void testCenturyYearNotLeap() {
        // 1900 is divisible by 100 but not by 400, so not a leap year
        int result = Cal.cal(2, 1, 2, 28, 1900);
        assertEquals("Feb 1 to Feb 28 in 1900 (not leap year)", 27, result);
    }

    // Test century year that is divisible by 400 (leap year)
    @Test
    public void testCenturyYearLeap() {
        // 2000 is divisible by 400, so it is a leap year
        int result = Cal.cal(2, 1, 2, 29, 2000);
        assertEquals("Feb 1 to Feb 29 in 2000 (leap year)", 28, result);
    }

    // Test century year that is not divisible by 400
    @Test
    public void testCenturyYearNotLeapByOne() {
        // 1999 is not divisible by 400, so it is not a leap year
        int result = Cal.cal(2, 1, 2, 28, 1999);
        assertEquals("Feb 1 to Feb 28 in 1999 (not leap year)", 27, result);
    }

    // Test edge case: first day of month to last day of month
    @Test
    public void testFirstToLastDayOfMonth() {
        // April 1 to April 30
        int result = Cal.cal(4, 1, 4, 30, 2023);
        assertEquals("Apr 1 to Apr 30", 29, result);
    }

    // Test multiple months span
    @Test
    public void testMultipleMonthsSpan() {
        // March 15 to August 20
        // Days remaining in March: 31 - 15 = 16
        // Days in April: 30
        // Days in May: 31
        // Days in June: 30
        // Days in July: 31
        // Days in August: 20
        // Total: 16 + 30 + 31 + 30 + 31 + 20 = 158
        int result = Cal.cal(3, 15, 8, 20, 2023);
        assertEquals("Mar 15 to Aug 20", 158, result);
    }

    // Test boundary year values
    @Test
    public void testBoundaryYearMinimum() {
        int result = Cal.cal(6, 15, 6, 20, 1);
        assertEquals("June 15 to June 20 in year 1", 5, result);
    }

    @Test
    public void testBoundaryYear100() {
        int result = Cal.cal(6, 15, 6, 20, 100);
        assertEquals("June 15 to June 20 in year 100", 5, result);
    }

    @Test
    public void testBoundaryYearMaximum() {
        int result = Cal.cal(6, 15, 6, 20, 10000);
        assertEquals("June 15 to June 20 in year 10000", 5, result);
    }

    // Test 30-day months
    @Test
    public void testThirtyDayMonth() {
        // September (30 days): Sep 1 to Sep 30
        int result = Cal.cal(9, 1, 9, 30, 2023);
        assertEquals("Sep 1 to Sep 30", 29, result);
    }

    // Test 31-day months
    @Test
    public void testThirtyOneDayMonth() {
        // October (31 days): Oct 1 to Oct 31
        int result = Cal.cal(10, 1, 10, 31, 2023);
        assertEquals("Oct 1 to Oct 31", 30, result);
    }
}