package SSVSEM.repository;

import SSVSEM.model.Book;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/*
  @author   Mariia Naduieva
  @project   SScourseproject
  @class  FakeBookRepository
  @version  1.0.0 
  @since 02.08.2021 - 20.54
*/
@Repository
public class FakeBookRepository {
    private LocalDateTime time = LocalDateTime.now();
    private List<Book> list = new ArrayList<>(
            Arrays.asList(
                    new Book("0","The Time Machine", "H.G. Wells", "Science Fiction",
                            10,5,"Classic example of science fiction", time, time ),
                    new Book("1","The Hunger Games", "Suzanne Collins", "Young Adult",
                            12,6,"Example of popular young adult fiction", time, time ),
                    new Book("2","Killing England", "Bill O’Reilly and Martin Dugard", "History",
                            9,3.5,"Example of a popular history book", time, time ),
                    new Book("3","Mastering the Art of French Cooking", "Julia Child", "Food",
                            11.5,6.5,"Example of a popular food book", time, time )
            )
    );

    public Book create(Book book) {
        String id = UUID.randomUUID().toString();
        book.setId(id);
        book.setCreatedAt(LocalDateTime.now());
        book.setUpdatedAt(LocalDateTime.now());
        list.add(book);
        return book;
    }


    public Book get(String id) {
        Book book = list.stream().filter(el -> el.getId().equals(id))
                .findAny().get();
        return book;
    }


    public Book update(Book book) {
        String id = book.getId();
        Book bookToUpdate = this.get(id);
        book.setCreatedAt(bookToUpdate.getCreatedAt());
        int index = list.indexOf(bookToUpdate);
        book.setUpdatedAt(LocalDateTime.now());
        list.remove(bookToUpdate);
        list.add(index, book);

        return book;
    }


    public Book delete(String id) {

        Book book =  this.get(id);
        list.remove(book);

        return book;
    }


    public List<Book> getAll() {
        return list;
    }
}
