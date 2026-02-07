package code.ca.bcit.comp2522.bookstore;

/**
 * Represents an author in the bookstore system.
 *
 * @author Brian Lau
 * @author Evan Tang
 * @version 1.0
 */
public class Author extends Person
{
    private static final int MAX_GENRE_LENGTH = 30;

    private final String genre;

    /**
     * Constructor for Author
     *
     * @param dateOfBirth the author's date of birth
     * @param dateOfDeath the author's date of death
     * @param name the author's name
     * @param genre the author's genre
     */
    public Author(final Date dateOfBirth,
                  final Date dateOfDeath,
                  final Name name,
                  final String genre)
    {
        super(dateOfBirth, dateOfDeath, name);

        validateGenre(genre);
        this.genre = genre;
    }

    /*
     * catches if genre is null or more than MAX_GENRE_LENGTH
     *
     * @param genre the genre to validate
     */
    private void validateGenre(final String genre)
    {
        if (genre == null || genre.isBlank())
        {
            throw new IllegalArgumentException("genre cannot be null or blank");
        }

        if (genre.length() > MAX_GENRE_LENGTH)
        {
            throw new IllegalArgumentException("genre cannot exceed 30 characters");
        }
    }

    /**
     * Returns the author's genre.
     *
     * @return genre
     */
    public String genre()
    {
        return genre;
    }

    /**
     * Prints the author's details.
     */
    @Override
    public void display()
    {
        System.out.println("Author "
                + name()
                + " writes in the "
                + genre
                + " genre.");
    }
}
