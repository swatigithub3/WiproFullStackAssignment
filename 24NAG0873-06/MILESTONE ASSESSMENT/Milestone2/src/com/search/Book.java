package com.search;
import java.util.Objects;

public class Book implements Comparable<Book> {
	private String title;
	private String author;
	private String ISBN;
	public Book(String title, String author, String ISBN) {
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	public int compareTo(Book other) {
		return this.title.compareTo(other.title);
	}
	public String toString() {
		return "Book{" + "title='" + title + '\'' + ", author='" + author + '\'' + ", ISBN='" + ISBN + '\'' +'}';
	}
	public boolean equals(Object o) {
		if(this==o)
			return true;
		if(o==null || getClass()!=o.getClass())
			return false;
		Book book = (Book) o;
		return Objects.equals(ISBN, book.ISBN);
	}
	public int hashCode() {
		return Objects.hash(ISBN);
	}
	
	

}
