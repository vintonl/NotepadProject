package dev.vintonlee.notepad.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private User user;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("NotePadPU");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		user = em.find(User.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		user = null;
	}

	@Test
	@DisplayName("Test primary fields")
	void test() {
		assertEquals(1, user.getId());
		assertEquals("admin", user.getRole());
	}
	
	@Test
	@DisplayName("Test relationship with notes")
	void test2() {
		assertEquals("apply to a lot of jobs", user.getNotes().get(0).getText());
	}
	
	@Test
	@DisplayName("Test relationship with images")
	void test3() {
		assertEquals("https://i.imgur.com/HlVLzU9.jpg", user.getImages().get(0).getUrlLink());
	}

}
