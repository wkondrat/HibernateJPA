package pl.spring.demo.service;

import java.util.List;

import pl.spring.demo.entity.BookSearchCriteria;
import pl.spring.demo.to.BookTo;

public interface BookSearchService {
    List<BookTo> findBooksBySearchCriteria(BookSearchCriteria bookSearchCriteria);

}
