package me;

import org.junit.*;
import static org.junit.Assert.*;

public class BirthdayReminderTest {

    public BirthdayReminderTest() {}

    @Test
    public void test() throws Exception {
        assertArrayEquals(new String[]{"515. Bill birthday (1)", "562. John binary birthday (1)", "612. Jack binary birthday (1)", "662. Bill binary birthday (1)", "780. John birthday (2)", "830. Jack birthday (2)", "880. Bill birthday (2)", "1050. John decimal birthday (1)", "1074. John binary birthday (2)", "1100. Jack decimal birthday (1)"}, BirthdayReminder.remind(new String[]{"John", "Jack", "Bill"}, new int[]{50, 100, 150}, 500, new String[]{"birthday", "decimal birthday", "binary birthday"}, new int[]{365, 1000, 512}, 10));

        assertArrayEquals(new String[]{"24. Zero threeday (8)", "24. Three threeday (7)", "24. Zero twoday (12)", "24. Two twoday (11)", "25. Three twoday (11)", "26. Two threeday (8)", "26. Zero twoday (13)", "26. Two twoday (12)", "27. Zero threeday (9)", "27. Three threeday (8)"}, BirthdayReminder.remind(new String[]{"Zero", "Two", "Three"}, new int[]{0, 2, 3}, 24, new String[]{"threeday", "twoday"}, new int[]{3,2}, 10));
    }
}
