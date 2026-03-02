package code.ca.bcit.comp2522.bookstore;

import code.ca.bcit.comp2522.bookstore.Author;
import code.ca.bcit.comp2522.bookstore.Biography;

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
public final class Autobiography extends Biography
{
    public Autobiography(final String title,
                         final int yearPublished,
                         final Author author)
    {
        super(title, yearPublished, author, author);
    }

    @Override
    public void display()
    {
        System.out.println("Autobiography \"" + getTitle()
                + "\" (" + getYearPublished()
                + ") by " + getAuthor()
                + " is about " + getSubject() + ".");
    }
}