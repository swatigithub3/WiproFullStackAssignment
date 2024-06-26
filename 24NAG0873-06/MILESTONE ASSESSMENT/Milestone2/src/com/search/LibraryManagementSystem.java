package com.search;

public class LibraryManagementSystem {

	public static void main(String[] args) {
		Library library = new Library();
		library.addBook(new Book("The Catcher in the Rye", "J.D.Salinger", "978-0-316-23456-0"));
		library.addBook(new Book("To kill a Mockingbird", "Harper Lee", "978-0-302-34567-4"));
		library.addBook(new Book("1984", "George Orewell", "978-0-123-67895-8"));
		library.addBook(new Book("Pride and Prejudice", "Jane Austen", "978-0-456-12345-0"));
		System.out.println("All books in the library: ");
		library.displayBooks();
		String searchTitle = "1984";
		System.out.println("\nLinear Search for title: " + searchTitle);
		Book foundBook = library.linearSearch(searchTitle);
		System.out.println(foundBook!=null ? "Found: " + foundBook: "Book not found.");
		System.out.println("\nBinary Search for title: " + searchTitle);
		foundBook = library.binarySearch(searchTitle);
		System.out.println(foundBook!=null ? "Found: " + foundBook: "Book not found.");
		System.out.println("\nComparing search performance:");
		System.out.println("Linear Search: Suitable for unsorted or small datasets.");
		System.out.println("Binary Search: Suitable for sorted datasets, providing faster search times.");

	}

}
