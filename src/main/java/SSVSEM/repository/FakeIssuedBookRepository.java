package SSVSEM.repository;

import SSVSEM.model.Book;
import SSVSEM.model.IssuedBook;
import SSVSEM.model.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/*
  @author   Mariia Naduieva
  @project   SScourseproject
  @class  FakeIssuedBookRepository
  @version  1.0.0 
  @since 05.08.2021 - 19.20
*/
@Repository
public class FakeIssuedBookRepository {

    @Autowired
    BookMongoRepository bookMongoRepository;

    @Autowired
    ReaderMongoRepository readerMongoRepository;

    private LocalDateTime time = LocalDateTime.now();
    private List<Reader> readers = new ArrayList<>(
            Arrays.asList(
                    new Reader("0","Ivan", "Ivanov", "Ivanovich",
                            "Pushkinska 1","0951234567", "student", "22 y.o.", time, time ),
                    new Reader("1","Maria", "Naduieva", "Oleksiivna",
                            "Pushkinska 3a","0507992386", "student", "23 y.o.", time, time ),
                    new Reader("2","Radyslav", "Churkin", "Dmitrovich",
                            "Pushkinska 3a","0735641213", "student", "21 y.o.", time, time ),
                    new Reader("3","Denys", "Ovdienko", "Ivanovich",
                            "Pushkinska 2","0892364578", "pensioner", "78 y.o.", time, time )
            )
    );

    private List<Book> books = new ArrayList<>(
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

    private List<IssuedBook> list = new ArrayList<>(
            Arrays.asList(
                    new IssuedBook("0",books.get(0), readers.get(0), "01.10.2021",
                            "05.10.2021",5,"description", time, time ),
                    new IssuedBook("1",books.get(1), readers.get(1), "23.05.2021",
                            "22.06.2021",5,"description", time, time ),
                    new IssuedBook("2",books.get(2), readers.get(2), "22.02.2021",
                            "10.03.2021",5,"description", time, time ),
                    new IssuedBook("3",books.get(3), readers.get(3), "15.06.2021",
                            "15.07.2021",10,"description", time, time )
                    )
    );

    public IssuedBook create(IssuedBook issuedBook) {
        String id = UUID.randomUUID().toString();
        issuedBook.setId(id);
        issuedBook.setCreatedAt(LocalDateTime.now());
        issuedBook.setUpdatedAt(LocalDateTime.now());
        list.add(issuedBook);
        return issuedBook;
    }


    public IssuedBook get(String id) {
        IssuedBook issuedBook = list.stream().filter(el -> el.getId().equals(id))
                .findAny().get();
        return issuedBook;
    }


    public IssuedBook update(IssuedBook issuedBook) {
        String id = issuedBook.getId();
        IssuedBook issuedBookToUpdate = this.get(id);
        issuedBook.setCreatedAt(issuedBookToUpdate.getCreatedAt());
        int index = list.indexOf(issuedBookToUpdate);
        issuedBook.setUpdatedAt(LocalDateTime.now());
        list.remove(issuedBookToUpdate);
        list.add(index, issuedBook);

        return issuedBook;
    }


    public IssuedBook delete(String id) {

        IssuedBook issuedBook =  this.get(id);
        list.remove(issuedBook);

        return issuedBook;
    }


    public List<IssuedBook> getAll() {
        return list;
    }

}
