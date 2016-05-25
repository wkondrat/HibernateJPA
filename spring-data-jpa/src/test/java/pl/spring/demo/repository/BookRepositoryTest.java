package pl.spring.demo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.entity.BookEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonRepositoryTest-context.xml")
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testShouldFindBookById() {
        // given
        final long bookId = 1;
        // when
        BookEntity bookEntity = bookRepository.findOne(bookId);
        // then
        assertNotNull(bookEntity);
        assertEquals("Pierwsza książka", bookEntity.getTitle());
    }

    @Test
    public void testShouldFindBooksByTitle() {
        // given
        final String bookTitle = "p";
        // when
        List<BookEntity> booksEntity = bookRepository.findBookByTitle(bookTitle);
        // then
        assertNotNull(booksEntity);
        assertFalse(booksEntity.isEmpty());
        assertEquals("Pierwsza książka", booksEntity.get(0).getTitle());
    }

    @Test
    public void testShouldFindBooksByAuthorFirstName() {
        // given
        final String author = "jan";
        // when
        List<BookEntity> booksEntity = bookRepository.findBookByAuthor(author);
        // then
        assertNotNull(booksEntity);
        assertFalse(booksEntity.isEmpty());
        assertEquals("Pierwsza książka", booksEntity.get(0).getTitle());
    }

    @Test
    public void testShouldFindBooksByAuthorLastName() {
        // given
        final String author = "kowalski";
        // when
        List<BookEntity> booksEntity = bookRepository.findBookByAuthor(author);
        // then
        assertNotNull(booksEntity);
        assertFalse(booksEntity.isEmpty());
        assertEquals("Pierwsza książka", booksEntity.get(0).getTitle());
    }
    
    @Test
    public void testShouldFindBooksByLibraryName() {
        // given
        final String name = "Alfa";
        // when
        List<BookEntity> booksEntity = bookRepository.findBookByLibrary(name);
        // then
        assertNotNull(booksEntity);
        assertFalse(booksEntity.isEmpty());
        assertEquals("Druga książka", booksEntity.get(1).getTitle());
    }
    
    @Test
    public void testShouldFindBooksByTitleOrLibraryName() {
        // given
    	final String title= "Pierwsza książka";
        final String library= "Alfa";
        // when
        List<BookEntity> booksEntity = bookRepository.findBookByTitleOrLibrary(title, library);
        // then
        assertNotNull(booksEntity);
        assertFalse(booksEntity.isEmpty());
        assertEquals("Pierwsza książka", booksEntity.get(0).getTitle());
    }
    
    @Test
    public void testShouldFindBooksByTitleAndAuthorFirstNameAndLibraryName() {
        // given
    	final String title= "Pierwsza książka";
        final String library = "Alfa";
        final String author = "Jan";
        // when
        List<BookEntity> booksEntity = bookRepository.findBookByTitleAuthorLibrary(title, author, library);
        // then
        assertNotNull(booksEntity);
        assertFalse(booksEntity.isEmpty());
        assertEquals("Pierwsza książka", booksEntity.get(0).getTitle());
    }
    
    @Test
    public void testShouldFindBooksByTitleAndAuthorLastNameAndLibraryName() {
        // given
    	final String title= "Pierwsza książka";
        final String library = "Alfa";
        final String author = "Kowalski";
        // when
        List<BookEntity> booksEntity = bookRepository.findBookByTitleAuthorLibrary(title, author, library);
        // then
        assertNotNull(booksEntity);
        assertFalse(booksEntity.isEmpty());
        assertEquals("Pierwsza książka", booksEntity.get(0).getTitle());
    }
    
    @Test
    public void testShouldFindAllBooksByTitleAndAuthorLastNameAndLibraryName() {
        // given
    	final String title= "";
        final String library = "";
        final String author = "";
        // when
        List<BookEntity> booksEntity = bookRepository.findBookByTitleAuthorLibrary(title, author, library);
        // then
        assertNotNull(booksEntity);
        assertFalse(booksEntity.isEmpty());
        assertEquals("Trzecia książka", booksEntity.get(2).getTitle());
    }
}
