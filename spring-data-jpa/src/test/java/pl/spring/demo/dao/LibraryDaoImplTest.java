package pl.spring.demo.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.spring.demo.entity.LibraryEntity;

import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonDaoTest-context.xml")
public class LibraryDaoImplTest {

	@Autowired
	private LibraryDao libraryDao;

	@Test
	public void testShouldFindLibraryByName() {
		// given
		final String name = "a";
		// when
		List<LibraryEntity> libraryEntity = libraryDao.findLibraryByName(name);
		// then
		assertNotNull(libraryEntity);
		assertEquals("Alfa", libraryEntity.get(0).getName());
	}

}
