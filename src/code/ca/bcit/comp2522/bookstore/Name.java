package code.ca.bcit.comp2522.bookstore;
import java.util.Objects;

/**
 * Stores the names of people using the Bookstore System
 *
 * @author Brian Lau
 * @author Evan Tang
 * @version 1.0
 */
public class Name implements Printable
{
    private final String first;
    private final String last;

    private static final int MAX_CHARACTER_LENGTH = 50;

    /**
     * Instantiate a name value with first and last name.
     *
     * @param first first name
     * @param last last name
     */
    public Name(final String first,
                final String last)
    {
        validateFirst(first);
        validateLast(last);

        this.first = first;
        this.last = last;
    }

    /*
     * catches if First is null or more than MAX_CHARCTER_LENGTH
     *
     * @param first
     */
    private void validateFirst(String first)
    {
        if(first == null || first.isBlank())
        {
            throw new IllegalArgumentException("first cannot be null/blank");
        }
        if(first.length() > MAX_CHARACTER_LENGTH)
        {
            throw new IllegalArgumentException("first must be < 50 chars");
        }
    }

    /*
     * catches if Last is null or has more than MAX_CHARACTER_LENGTH
     *
     * @param last
     */
    private void validateLast(String last)
    {
        if(last == null || last.isBlank())
        {
            throw new IllegalArgumentException("last cannot be null/blank");
        }
        if(last.length() > MAX_CHARACTER_LENGTH)
        {
            throw new IllegalArgumentException("last must be < 50 chars");
        }
    }

    /**
     * Returns the first  name.
     *
     * @return first
     */
    public String getFirst()
    {
        return first;
    }

    /**
     * Returns the last (family) name.
     *
     * @return Last String
     */
    public String getLast()
    {
        return last;
    }

    /**
     * Returns the full name in "first last" format.
     *
     * @return fullName String
     */
    public String getFullName()
    {
        return first + " " + last;
    }

    /**
     * Prints the full name in a readable sentence.
     */
    @Override
    public void display()
    {
        System.out.println("This person's name is "
                + getFullName()
                + ".");
    }
}