package pl.spring.demo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.entity.LibraryEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonRepositoryTest-context.xml")
public class LibraryRepositoryTest {

    @Autowired
    private LibraryRepository libraryRepository;
    
    @Autowired
    private BookRepository bookRepository;

    @Test
    @Sql({"delete.sql", "data.sql"})
    public void testShouldFindLibraryByName() {
        // given
        final String name = "a";
        // when
        List<LibraryEntity> libraryEntity = libraryRepository.findLibraryByName(name);
        // then
        assertNotNull(libraryEntity);
        assertFalse(libraryEntity.isEmpty());
        assertEquals("Alfa", libraryEntity.get(0).getName());
    }
    
    @Test
    @Sql({"delete.sql", "data.sql"})
    public void testShouldFindLibraryById() {
        // given
        final long id = 4;
        // when
        LibraryEntity libraryEntity = libraryRepository.findOne(id);
        // then
        assertNotNull(libraryEntity);
        assertEquals("Alfa", libraryEntity.getName());
    }
    
    @Test
    @Sql({"delete.sql", "data.sql"})
    public void testShouldDeleteLibraryById() {
       // given
       final long id = 4;
       assertNotNull(bookRepository.findOne(2L));
        // when
       libraryRepository.delete(id);
       LibraryEntity libraryEntity = libraryRepository.findOne(id);
        // then
       assertNull(libraryEntity);
       assertNull(bookRepository.findOne(2L));
    }
}
