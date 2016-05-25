package pl.spring.demo.service;

import java.util.List;

import pl.spring.demo.to.BookTo;

public interface BookService {

    List<BookTo> findAllBooks();
    List<BookTo> findBooksByTitle(String title);
    List<BookTo> findBooksByAuthor(String author);
    List<BookTo> findBooksByTitleAuthorLibrary(String title, String author, String library);
    List<BookTo> findBooksByLibrary(String library);
    List<BookTo> findBooksByTitleOrLibrary(String title, String library);
    
    BookTo saveBook(BookTo book);
}
