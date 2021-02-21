package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.repositories.AuthorRepository;
import guru.springframework.spring5webapp.domain.repositories.BookRepository;

@Component
public class BootStrapData implements CommandLineRunner {

	
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	
	
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}



	@Override
	public void run(String... args) throws Exception {

		Author ilias = new Author("ILIAS","IL MAOUN");
		Book introductionToJava = new Book("Introduction To Java","123456");
		ilias.getBooks().add(introductionToJava);
		introductionToJava.getAuthors().add(ilias);
		authorRepository.save(ilias);
		bookRepository.save(introductionToJava);
		
		Author anas = new Author("ANAS","BENZIDIYA");
		Book plsql = new Book("Introduction To PL/SQL","789123");
		anas.getBooks().add(plsql);
		plsql.getAuthors().add(anas);
		authorRepository.save(anas);
		bookRepository.save(plsql);
		
		System.out.println("Started in bootstrap");
		System.out.println("Number of books : "+bookRepository.count());
	}

}
