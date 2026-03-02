package code.ca.bcit.comp2522.bookstore;

import code.ca.bcit.comp2522.bookstore.Author;
import code.ca.bcit.comp2522.bookstore.Autobiography;
import code.ca.bcit.comp2522.bookstore.Biography;
import code.ca.bcit.comp2522.bookstore.Person;

public final class Main
{
    private Main()
    {
    }

    public static void main(final String[] args)
    {
        final Author georgeOrwell;
        final Author harperLee;
        final Author janeAusten;
        final Author fScottFitzgerald;
        final Author hermanMelville;

        georgeOrwell = new Author(new Date(1903, 6, 25), new Date(1950, 1, 21),
                new Name("George", "Orwell"), "Dystopian");
        harperLee = new Author(new Date(1926, 4, 28), new Date(2016, 2, 19),
                new Name("Harper", "Lee"), "Fiction");
        janeAusten = new Author(new Date(1775, 12, 16), new Date(1817, 7, 18),
                new Name("Jane", "Austen"), "Romance");
        fScottFitzgerald = new Author(new Date(1896, 9, 24), new Date(1940, 12, 21),
                new Name("F. Scott", "Fitzgerald"), "Fiction");
        hermanMelville = new Author(new Date(1819, 8, 1), new Date(1891, 9, 28),
                new Name("Herman", "Melville"), "Adventure");

        final Book book1;
        final Book book2;
        final Book book3;
        final Book book4;
        final Book book5;

        book1 = new Book("1984", 1949, georgeOrwell);
        book2 = new Book("To Kill a Mockingbird", 1960, harperLee);
        book3 = new Book("Pride and Prejudice", 1813, janeAusten);
        book4 = new Book("The Great Gatsby", 1925, fScottFitzgerald);
        book5 = new Book("Moby-Dick", 1851, hermanMelville);

        final Author robertCaro;
        final Author walterIsaacson;
        final Author martinGilbert;
        final Author ronChernow;

        robertCaro = new Author(new Date(1935, 10, 30), null, new Name("Robert", "Caro"), "Biography");
        walterIsaacson = new Author(new Date(1952, 5, 20), null, new Name("Walter", "Isaacson"), "Biography");
        martinGilbert = new Author(new Date(1936, 10, 25), new Date(2015, 2, 3), new Name("Martin", "Gilbert"), "Biography");
        ronChernow = new Author(new Date(1949, 3, 3), null, new Name("Ron", "Chernow"), "Biography");

        final Person robertMoses;
        final Person steveJobs;
        final Person winstonChurchill;
        final Person alexanderHamilton;
        final Person albertEinstein;

        robertMoses = new Person(new Date(1888, 12, 18), new Date(1981, 7, 29), new Name("Robert", "Moses"));
        steveJobs = new Person(new Date(1955, 2, 24), new Date(2011, 10, 5), new Name("Steve", "Jobs"));
        winstonChurchill = new Person(new Date(1874, 11, 30), new Date(1965, 1, 24), new Name("Winston", "Churchill"));
        alexanderHamilton = new Person(new Date(1755, 1, 11), new Date(1804, 7, 12), new Name("Alexander", "Hamilton"));
        albertEinstein = new Person(new Date(1879, 3, 14), new Date(1955, 4, 18), new Name("Albert", "Einstein"));

        final Biography bio1;
        final Biography bio2;
        final Biography bio3;
        final Biography bio4;
        final Biography bio5;

        bio1 = new Biography("The Power Broker", 1974, robertCaro, robertMoses);
        bio2 = new Biography("Steve Jobs", 2011, walterIsaacson, steveJobs);
        bio3 = new Biography("Churchill: A Life", 1991, martinGilbert, winstonChurchill);
        bio4 = new Biography("Alexander Hamilton", 2004, ronChernow, alexanderHamilton);
        bio5 = new Biography("Einstein: His Life and Universe", 2007, walterIsaacson, albertEinstein);

        final Author anneFrank;
        final Author nelsonMandela;
        final Author mahatmaGandhi;
        final Author mayaAngelou;
        final Author malcolmX;

        anneFrank = new Author(new Date(1929, 6, 12), new Date(1945, 2, 15), new Name("Anne", "Frank"), "Memoir");
        nelsonMandela = new Author(new Date(1918, 7, 18), new Date(2013, 12, 5), new Name("Nelson", "Mandela"), "Memoir");
        mahatmaGandhi = new Author(new Date(1869, 10, 2), new Date(1948, 1, 30), new Name("Mahatma", "Gandhi"), "Memoir");
        mayaAngelou = new Author(new Date(1928, 4, 4), new Date(2014, 5, 28), new Name("Maya", "Angelou"), "Memoir");
        malcolmX = new Author(new Date(1925, 5, 19), new Date(1965, 2, 21), new Name("Malcolm", "X"), "Memoir");

        final Autobiography auto1;
        final Autobiography auto2;
        final Autobiography auto3;
        final Autobiography auto4;
        final Autobiography auto5;

        auto1 = new Autobiography("The Diary of a Young Girl", 1947, anneFrank);
        auto2 = new Autobiography("Long Walk to Freedom", 1994, nelsonMandela);
        auto3 = new Autobiography("The Story of My Experiments with Truth", 1927, mahatmaGandhi);
        auto4 = new Autobiography("I Know Why the Caged Bird Sings", 1969, mayaAngelou);
        auto5 = new Autobiography("Autobiography of Malcolm X", 1965, malcolmX);

        book1.display();
        bio1.display();
        auto1.display();

        System.out.println("\nBook title backwards:");
        book1.backward();

        System.out.println("\nAuthor name backwards:");
        georgeOrwell.backward();

        System.out.println("\nCompare books (older is larger):");
        System.out.println("1984 vs Pride and Prejudice: " + book1.compareTo(book3)); // should be negative because 1949 is NOT older than 1813

        System.out.println("\nCompare people (older is larger):");
        System.out.println("Einstein vs Jobs: " + albertEinstein.compareTo(steveJobs)); // should be positive (Einstein older)

        final Biography bioJobsDifferentTitle;
        bioJobsDifferentTitle = new Biography("Jobs Again", 2020, walterIsaacson, steveJobs);

        System.out.println("Biography equals (same subject): " + bio2.equals(bioJobsDifferentTitle)); // should be true
        System.out.println("Biography equals (different subject): " + bio2.equals(bio1)); // false
    }
}