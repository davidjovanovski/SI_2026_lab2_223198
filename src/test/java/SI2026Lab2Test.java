import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.util.List;

public class SI2026Lab2Test {

    @Test
    public void searchBookEveryStatementTest(){
        Library library;
        List<Book> result;

        // test1
        Library library1 = new Library();
        assertThrows(IllegalArgumentException.class, () -> library1.searchBookByTitle(""));

        // test2
        library = new Library();
        library.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));
        result = library.searchBookByTitle("Clean Code");
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Clean Code", result.getFirst().getTitle());

        // test3
        library = new Library();
        library.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));
        result = library.searchBookByTitle("Whatever title");
        assertNull(result);
    }

    @Test
    public void borrowBookEveryBranchTest(){
        Library lib1, lib2, lib3, lib4;


        // check prazen title
        lib1 = new Library();
        assertThrows(IllegalArgumentException.class, () -> lib1.borrowBook("", "Robert C, Martin"));

        // check poln title, no nepostoecka kniga
        lib2 = new Library();
        lib2.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));
        assertThrows(RuntimeException.class, () -> lib2.borrowBook("The Hobbit", "J.R.R. Tolkien"));


        // check poln title, postoecka kniga, nepozajmena, pozajmi
        lib3 = new Library();
        lib3.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));
        lib3.borrowBook("Clean Code", "Robert C. Martin");
        assertNull(lib3.searchBookByTitle("Clean Code"));

        // check poln title, postoecka kniga, pozajmena
        lib4 = new Library();
        lib4.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));
        lib4.borrowBook("Clean Code", "Robert C. Martin");
        assertThrows(RuntimeException.class, () -> lib4.borrowBook("Clean Code", "Robert C. Martin"));
    }

    @Test
    public void borrowBookMultipleConditionTest(){ //ima 4 kombinacii za conditions (T || T, F || T, T || F, F || F)
        Library lib1, lib2, lib3, lib4;

        lib1 = new Library();
        assertThrows(IllegalArgumentException.class, () -> lib1.borrowBook("",""));//prazen title, prazen author

        lib2 = new Library();
        assertThrows(IllegalArgumentException.class, () -> lib2.borrowBook("Clean Code",""));//poln title, prazen author

        lib3 = new Library();
        assertThrows(IllegalArgumentException.class, () -> lib3.borrowBook("","Robert C. Martin"));//prazen title, poln author

        lib4 = new Library();
        lib4.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));
        lib4.borrowBook("Clean Code", "Robert C. Martin");//poln title, poln author, mozhe da prodolzhi
        assertNull(lib4.searchBookByTitle("Clean Code"));//check dali prethodnata linija prodolzila pravilno
    }

    @Test
    public void searchBookMultipleConditionTest(){
        Library lib1, lib2, lib3, lib4;


        //ist title, dodadena kniga, nepozajmena, proverka dali ima 1 objekt vo listata
        lib1 = new Library();
        lib1.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));
        List<Book> result1 = lib1.searchBookByTitle("Clean Code");
        assertNotNull(result1);
        assertEquals(1, result1.size());

        //ist title, dodadena kniga, pozajmena, proverka dali listata nema elementi
        lib2 = new Library();
        lib2.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));
        lib2.borrowBook("Clean Code", "Robert C. Martin");
        List<Book> result2 = lib2.searchBookByTitle("Clean Code");
        assertNull(result2);

        //razlicen title, nepozajmena kniga, proverka dali listata nema elementi(ako nema, ja nema knigata koj e pobarana, mozno da ima druga kniga)
        lib3 = new Library();
        lib3.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));
        List<Book> result3 = lib3.searchBookByTitle("The Hobbit");
        assertNull(result3);


        //razlicen title za pozajmuvanje, pozajmena kniga, proverka dali nema el (ako nema, ja nema baranata, mozhe da ima drugi)
        lib4 = new Library();
        lib4.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));
        lib4.borrowBook("Clean Code", "Robert C. Martin");
        List<Book> result4 = lib4.searchBookByTitle("The Hobbit");
        assertNull(result4);
    }
}
