package code.ca.bcit.comp2522.bookstore;

import java.util.Calendar;

/**
 * Represents an immutable calendar date with validation.
 * Stores a year, month, and day.
 *
 * @author Evan Tang
 * @author Brian Lau
 * @version 1.0
 */
public final class Date implements Printable
{
    private static final int MIN_YEAR = 1;

    private static final int JANUARY = 1;
    private static final int FEBRUARY = 2;
    private static final int DECEMBER = 12;

    private static final int MIN_DAY = 1;
    private static final int MAX_DAY_31 = 31;
    private static final int MAX_DAY_30 = 30;
    private static final int MAX_DAY_FEB_LEAP = 29;
    private static final int MAX_DAY_FEB = 28;

    private static final int LEAP_DIV_4 = 4;
    private static final int LEAP_DIV_100 = 100;
    private static final int LEAP_DIV_400 = 400;

    private final int year;
    private final int month;
    private final int day;
    public Date getYear;

    public Date(final int year,
                final int month,
                final int day)
    {
        validateYear(year);
        validateMonth(month);
        validateDay(year, month, day);

        this.year = year;
        this.month = month;
        this.day = day;
    }

    private static void validateYear(final int year)
    {
        final int currentYear;
        currentYear = Calendar.getInstance().get(Calendar.YEAR);

        if(year < MIN_YEAR || year > currentYear)
        {
            throw new IllegalArgumentException("Invalid year: " + year);
        }
    }

    private static void validateMonth(final int month)
    {
        if(month < JANUARY || month > DECEMBER)
        {
            throw new IllegalArgumentException("Invalid month: " + month);
        }
    }

    private static boolean isLeapYear(final int year)
    {
        if(year % LEAP_DIV_400 == 0)
        {
            return true;
        }

        if(year % LEAP_DIV_100 == 0)
        {
            return false;
        }

        return year % LEAP_DIV_4 == 0;
    }

    private static void validateDay(final int year,
                                    final int month,
                                    final int day)
    {
        if(day < MIN_DAY)
        {
            throw new IllegalArgumentException("Invalid day: " + day);
        }

        final int maxDay;

        switch(month)
        {
            case 4, 6, 9, 11 -> maxDay = MAX_DAY_30;
            case FEBRUARY -> maxDay = isLeapYear(year) ? MAX_DAY_FEB_LEAP : MAX_DAY_FEB;
            default -> maxDay = MAX_DAY_31;
        }

        if(day > maxDay)
        {
            throw new IllegalArgumentException("Invalid day: " + day);
        }
    }

    public int getYear()
    {
        return year;
    }

    public int getMonth()
    {
        return month;
    }

    public int getDay()
    {
        return day;
    }

    @Override
    public void display()
    {
        System.out.println("The date is year=" + year + ", month=" + month + ", day=" + day + ".");
    }

    @Override
    public String toString()
    {
        return year + "-" + month + "-" + day;
    }
}
