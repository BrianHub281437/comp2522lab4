package code.ca.bcit.comp2522.bookstore;

import java.time.Year;

import static java.util.Collections.reverse;

/**
 * Represents a Book in the bookstore.
 * A Book has a title, publication year, and an author.
 *
 * Implements
 * Comparable: allows books to be compared by age
 * Printable: displays book information
 * Reversible: prints the book title backward
 * @author Evan Tang
 * @author Brian Lau
 * @version 1.0
 */
public class Book implements Comparable<Book>, Printable, Reversible
{
    // Title of the book (non-null, non-blank, < 100 characters)
    private final String title;

    // Year the book was published (1 to current year)
    private final int yearPublished;

    // Author of the book (must not be null)
    private final Author author;

    /**
     * Constructs a Book object.
     *
     * @param title the title of the book
     * @param yearPublished the year the book was published
     * @param author the author of the book
     * @throws IllegalArgumentException if any argument is invalid
     */
    public Book(final String title,
                final int yearPublished,
                final Author author)
    {
        // Validate title
        if (title == null || title.isBlank() || title.length() >= 100)
        {
            throw new IllegalArgumentException("Invalid title");
        }

        // Validate publication year
        int currentYear = Year.now().getValue();
        if (yearPublished < 1 || yearPublished > currentYear)
        {
            throw new IllegalArgumentException("Invalid publication year");
        }

        // Validate author
        if (author == null)
        {
            throw new IllegalArgumentException("Author cannot be null");
        }

        // Assign validated values
        this.title = title;
        this.yearPublished = yearPublished;
        this.author = author;

    }

    /**
     * Gets the book title.
     *
     * @return the title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Gets the publication year.
     *
     * @return the year published
     */
    public int getYearPublished()
    {
        return yearPublished;
    }

    /**
     * Gets the author of the book.
     *
     * @return the author
     */
    public Author getAuthor()
    {
        return author;
    }

    /**
     * Compares this book with another book.
     * Older books are considered "larger".
     *
     * @param other the book to compare against
     * @return a positive value if this book is older,
     *         zero if same year,
     *         negative if this book is newer
     */
    @Override
    public int compareTo(final Book other)
    {
        return Integer.compare(other.yearPublished, this.yearPublished);
    }

    /**
     * Displays the book information.
     * Format includes title, year published, and author.
     */
    @Override
    public void display()
    {
        System.out.println(this.title);
        System.out.println(this.yearPublished);
        System.out.println(this.author);
    }

    /**
     * Displays the book title in reverse order.
     */
    @Override
    public void backward()
    {
        final String title = this.title;
        StringBuilder sb;
        sb = new StringBuilder();

        sb.append(title).reverse().toString();

        System.out.println(sb);

    }

}
