import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private List<Book> books = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public Book getBookById(Long id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public Book createBook(Book book) {
        book.setId(nextId++);
        books.add(book);
        return book;
    }

    @Override
    public Book updateBook(Long id, Book book) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId().equals(id)) {
                book.setId(id);
                books.set(i, book);
                return book;
            }
        }
        return null;
    }

    @Override
    public void deleteBook(Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }
}
