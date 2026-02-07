package code.ca.bcit.comp2522.bookstore;
import java.util.Objects;

/**
 * Represents the person of the Bookstore
 *
 * @author Brian Lau
 * @author Evan Tang
 * @version 1.0
 */

public class Person implements Comparable<Person>, Reversible, Printable
{
    private final Date dateOfBirth;
    private final Date dateOfDeath;
    private final Name name;

    /**
     * constructor for Person
     *
     * @param dateOfBirth
     * @param dateOfDeath
     * @param name
     */
    public Person(final Date dateOfBirth,
                  final Date dateOfDeath,
                  final Name name)
    {
        validateDateOfBirth(dateOfBirth);
        validateDateOfDeath(dateOfDeath, dateOfBirth);
        validateName(name);

        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.name = name;
    }
    /*
     * catches if dateOfBirth is null
     *
     * @param dateOfBirth
     */
    private void validateDateOfBirth(final Date dateOfBirth)
    {
        if (dateOfBirth == null)
        {
            throw new IllegalArgumentException("dateOfBirth cannot be null");
        }

    }

    /*
     * catches if dateOfDeath is earlier than dateOfBirth
     *
     * @param dateOfDeath
     * @param dateOfBirth
     */
    private void validateDateOfDeath(final Date dateOfDeath,
                                     final Date dateOfBirth)
    {
        if (dateOfDeath != null &&
                dateOfDeath.getYear() - dateOfBirth.getYear() < 0)
        {
            throw new IllegalArgumentException("dateOfDeath cannot be before dateOfBirth");
        }
    }

    /**
     * catches if name is null
     *
     * @param name
     */
    private void validateName(final Name name)
    {
        if (name == null)
        {
            throw new IllegalArgumentException("name cannot be null");
        }
    }

    /**
     * returns the date of birth
     *
     * @return dateOfBirth()
     */
    public Date dateOfBirth()
    {
        return dateOfBirth;
    }

    /**
     * returns the date of death
     *
     * @return dateOfDeath()
     */
    public Date dateOfDeath()
    {
        return dateOfDeath;
    }

    /**
     * returns the name of person
     *
     * @return name()
     */
    public Name name()
    {
        return name;
    }


    /**
     * prints details of the person
     */
    @Override
    public void display()
    {
        final String deathNote;
        if (dateOfDeath == null)
        {
            deathNote = "still living";
        }
        else
        {
            deathNote = dateOfDeath.toString();
        }
        System.out.println("Person"
        + name
        + "was born"
        + dateOfBirth
        + "and is"
        + deathNote
        + ".");

    }

    /**
     * prints name in reverse
     */
    @Override
    public void backward()
    {
        final String fullName;
        fullName = name.getFullName();

        System.out.println(reverse(fullName));
    }

    /**
     *
     * @param text
     * @return reverse text
     */
    private String reverse(final String text)
    {
        final StringBuilder builder;
        builder = new StringBuilder(text);
        return builder.reverse().toString();
    }

    /**
     *compares persons by date of birth
     *
     * @param other the object to be compared.
     * @return Integer of comparison
     */
    @Override
    public int compareTo(final Person other)
    {
        if(other == null)
        {
            throw new IllegalArgumentException("other cannot be null");
        }

        if(dateOfBirth.getYear() != other.dateOfBirth.getYear())
        {
            return Integer.compare(other.dateOfBirth.getYear(), dateOfBirth.getYear());
        }

        if(dateOfBirth.getMonth() != other.dateOfBirth.getMonth())
        {
            return Integer.compare(other.dateOfBirth.getMonth(), dateOfBirth.getMonth());
        }

        return Integer.compare(other.dateOfBirth.getDay(), dateOfBirth.getDay());
    }


    /**
     * Persons are equal if they have the same date of birth, date of death, and name
     *
     * @param o   the reference object with which to compare.
     * @return true if equal
     */
    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
        {
            return true;
        }

        if (!(o instanceof Person))
        {
            return false;
        }

        final Person person;
        person = (Person) o;

        return dateOfBirth.equals(person.dateOfBirth) &&
                dateOfDeath.equals(person.dateOfDeath) &&
                name.equals(person.name);
    }

    /**
     * Overrides hashcode
     *
     * @return hashcode
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(dateOfBirth,
                dateOfDeath,
                name);
    }

    /**
     * Overrides toString
     *
     * @return name + toString
     */
    @Override
    public String toString()
    {
        return name.toString();
    }
}
