package pl.spring.demo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.entity.BookSearchCriteria;
import pl.spring.demo.to.BookTo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonServiceTest-context.xml")
public class BookSearchServiceTest {

	@Autowired
	private BookSearchService service;

	@Test
	public void testShouldNotFindAnyBooks() {
		// given
		final String title = "";
		final String library = "gamma";
		final String author = "";
		int sizeOfList = 0;
		BookSearchCriteria bookCriteria = new BookSearchCriteria(title, author, library);
		// when
		List<BookTo> booksTo = service.findBooksBySearchCriteria(bookCriteria);
		// then
		assertNotNull(booksTo);
		assertTrue(booksTo.isEmpty());
		assertEquals(sizeOfList, booksTo.size());
	}

	@Test
	public void testShouldFindAllBooks() {
		// given
		final String title = "";
		final String library = "";
		final String author = "";
		int sizeOfList = 3;
		BookSearchCriteria bookCriteria = new BookSearchCriteria(title, author, library);
		// when
		List<BookTo> booksTo = service.findBooksBySearchCriteria(bookCriteria);
		// then
		assertNotNull(booksTo);
		assertFalse(booksTo.isEmpty());
		assertEquals(sizeOfList, booksTo.size());
		assertEquals("Trzecia książka", booksTo.get(2).getTitle());
	}

	@Test
	public void testShouldFindBooksByAllCriteria() {
		// given
		final String title = "t";
		final String library = "beta";
		final String author = "janusz";
		BookSearchCriteria bookCriteria = new BookSearchCriteria(title, author, library);
		// when
		List<BookTo> booksTo = service.findBooksBySearchCriteria(bookCriteria);
		// then
		assertNotNull(booksTo);
		assertFalse(booksTo.isEmpty());
		assertEquals("Trzecia książka", booksTo.get(0).getTitle());
	}

	@Test
	public void testShouldFindBooksByLibrary() {
		// given
		final String title = "";
		final String library = "beta";
		final String author = "";
		BookSearchCriteria bookCriteria = new BookSearchCriteria(title, author, library);
		// when
		List<BookTo> booksTo = service.findBooksBySearchCriteria(bookCriteria);
		// then
		assertNotNull(booksTo);
		assertFalse(booksTo.isEmpty());
		assertEquals("Trzecia książka", booksTo.get(0).getTitle());
	}

	@Test
	public void testShouldFindBooksByAuthor() {
		// given
		final String title = "";
		final String library = "";
		final String author = "jan";
		BookSearchCriteria bookCriteria = new BookSearchCriteria(title, author, library);
		// when
		List<BookTo> booksTo = service.findBooksBySearchCriteria(bookCriteria);
		// then
		assertNotNull(booksTo);
		assertFalse(booksTo.isEmpty());
		assertEquals("Trzecia książka", booksTo.get(1).getTitle());
	}

	@Test
	public void testShouldFindBooksByTitle() {
		// given
		final String title = "p";
		final String library = "";
		final String author = "";
		BookSearchCriteria bookCriteria = new BookSearchCriteria(title, author, library);
		// when
		List<BookTo> booksTo = service.findBooksBySearchCriteria(bookCriteria);
		// then
		assertNotNull(booksTo);
		assertFalse(booksTo.isEmpty());
		assertEquals("Pierwsza książka", booksTo.get(0).getTitle());
	}

	@Test
	public void testShouldFindBooksByTitleAndLibrary() {
		// given
		final String title = "d";
		final String library = "a";
		final String author = "";
		BookSearchCriteria bookCriteria = new BookSearchCriteria(title, author, library);
		// when
		List<BookTo> booksTo = service.findBooksBySearchCriteria(bookCriteria);
		// then
		assertNotNull(booksTo);
		assertFalse(booksTo.isEmpty());
		assertEquals("Druga książka", booksTo.get(0).getTitle());
	}

	@Test
	public void testShouldFindBooksByTitleAndAuthor() {
		// given
		final String title = "t";
		final String library = "";
		final String author = "jan";
		BookSearchCriteria bookCriteria = new BookSearchCriteria(title, author, library);
		// when
		List<BookTo> booksTo = service.findBooksBySearchCriteria(bookCriteria);
		// then
		assertNotNull(booksTo);
		assertFalse(booksTo.isEmpty());
		assertEquals("Trzecia książka", booksTo.get(0).getTitle());
	}

	@Test
	public void testShouldFindBooksByLibraryAndAuthor() {
		// given
		final String title = "";
		final String library = "a";
		final String author = "zbig";
		BookSearchCriteria bookCriteria = new BookSearchCriteria(title, author, library);
		// when
		List<BookTo> booksTo = service.findBooksBySearchCriteria(bookCriteria);
		// then
		assertNotNull(booksTo);
		assertFalse(booksTo.isEmpty());
		assertEquals("Druga książka", booksTo.get(0).getTitle());
	}

	@Test
	public void testShouldFindBooksWhenAllParametersAreNull() {
		// given
		final String title = null;
		final String library = null;
		final String author = null;
		int sizeOfList = 3;
		BookSearchCriteria bookCriteria = new BookSearchCriteria(title, author, library);
		// when
		List<BookTo> booksTo = service.findBooksBySearchCriteria(bookCriteria);
		// then
		assertNotNull(booksTo);
		assertFalse(booksTo.isEmpty());
		assertEquals(sizeOfList, booksTo.size());
		assertEquals("Pierwsza książka", booksTo.get(0).getTitle());
	}

	@Test
	public void testShouldFindBooksWhenOneParameterIsNull() {
		// given
		final String title = null;
		final String library = "a";
		final String author = "zbig";
		BookSearchCriteria bookCriteria = new BookSearchCriteria(title, author, library);
		// when
		List<BookTo> booksTo = service.findBooksBySearchCriteria(bookCriteria);
		// then
		assertNotNull(booksTo);
		assertFalse(booksTo.isEmpty());
		assertEquals("Druga książka", booksTo.get(0).getTitle());
	}
}
