package code.ca.bcit.comp2522.bookstore;

/**
 * Represents a Biography, which is a type of Book
 * written about a specific person.
 *
 * Extends Book
 * Implements Printable: displays all attributes including the subject
 * @author Evan Tang
 * @author Brian Lau
 * @version 1.0
 */
public class Biography extends Book implements Printable
{
    // The person this biography is about (must not be null)
    private final Person subject;

    /**
     * Constructs a Biography object.
     *
     * @param title the title of the biography
     * @param yearPublished the year the biography was published
     * @param author the author of the biography
     * @param subject the person the biography is about
     * @throws IllegalArgumentException if subject is null
     */
    public Biography(final String title,
                     final int yearPublished,
                     final Author author,
                     final Person subject)
    {
        super(title, yearPublished, author);

        if (subject == null)
        {
            throw new IllegalArgumentException("Subject cannot be null");
        }

        this.subject = subject;
    }

    /**
     * Gets the subject of the biography.
     *
     * @return the subject
     */
    public Person getSubject()
    {
        return subject;
    }

    /**
     * Two biographies are considered equal if they
     * are about the same subject.
     *
     * @param o the object to compare with
     * @return true if both biographies have the same subject
     */
    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
        {
            return true;
        }

        if (!(o instanceof Biography))
        {
            return false;
        }

        Biography other = (Biography) o;
        return subject.equals(other.subject);
    }

    /**
     * Overrides hashcode
     *
     * @return hashcode
     */
    @Override
    public int hashCode()
    {
        return 0;
    }

    /**
     * Prints all biography attributes including
     * title, year published, author, and subject.
     */
    @Override
    public void display()
    {
        System.out.println(getTitle() + " (" + getYearPublished() + ") by " +
                            getAuthor() + ", Subject: " + subject);
    }
}
