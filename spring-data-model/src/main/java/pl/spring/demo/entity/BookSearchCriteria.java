package pl.spring.demo.entity;

public class BookSearchCriteria {
	private String title;
	private String author;
	private String library;
	
	public BookSearchCriteria(String title, String author, String library) {
		this.title = title;
		this.author = author;
		this.library = library;
		
		if (title == null) {
			this.title = "";
		}
		
		if (author == null) {
			this.author = "";
		}
		
		if (library == null) {
			this.library = "";
		}
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getAuthor() {
		return this.author;
	}
	
	public String getLibrary() {
		return this.library;
	}
}
