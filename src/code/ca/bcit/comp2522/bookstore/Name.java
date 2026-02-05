package code.ca.bcit.comp2522.bookstore;

import java.util.Objects;

/**
 * Stores the names of people using the Bookstore System
 */
public class Name implements printable
{
    private final String first;
    private final String last;

    private static final int MAX_CHARACTER_LENGTH = 100;

    /**
     * Instantiate a name value with first and last name.
     *
     * @param first first name
     * @param last last name
     */
    public Name(final String first,
                final String last)
    {
        if(first == null || first.isBlank())
        {
            throw new IllegalArgumentException("first cannot be null/blank");
        }

        if(last == null || last.isBlank())
        {
            throw new IllegalArgumentException("last cannot be null/blank");
        }

        if(first.length() > MAX_CHARACTER_LENGTH)
        {
            throw new IllegalArgumentException("first must be < 50 chars");
        }

        if(last.length() > MAX_CHARACTER_LENGTH)
        {
            throw new IllegalArgumentException("last must be < 50 chars");
        }

        this.first = first;
        this.last = last;
    }

    /**
     * Returns the first (given) name.
     *
     * @return the first name
     */
    public String getFirst()
    {
        return first;
    }

    /**
     * Returns the last (family) name.
     *
     * @return the last name
     */
    public String getLast()
    {
        return last;
    }

    /**
     * Returns the full name in "first last" format.
     *
     * @return the full name
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
        System.out.println("The person's name is " + getFullName() + ".");
    }
}