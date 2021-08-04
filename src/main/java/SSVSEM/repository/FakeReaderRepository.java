package SSVSEM.repository;

/*
  @author   Mariia Naduieva
  @project   SScourseproject
  @class  FakeReaderRepository
  @version  1.0.0 
  @since 04.08.2021 - 13.15
*/

import SSVSEM.model.Reader;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeReaderRepository {
    private LocalDateTime time = LocalDateTime.now();
    private List<Reader> list = new ArrayList<>(
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

    public Reader create(Reader reader) {
        String id = UUID.randomUUID().toString();
        reader.setId(id);
        reader.setCreatedAt(LocalDateTime.now());
        reader.setUpdatedAt(LocalDateTime.now());
        list.add(reader);
        return reader;
    }


    public Reader get(String id) {
        Reader reader = list.stream().filter(el -> el.getId().equals(id))
                .findAny().get();
        return reader;
    }


    public Reader update(Reader reader) {
        String id = reader.getId();
        Reader readerToUpdate = this.get(id);
        reader.setCreatedAt(readerToUpdate.getCreatedAt());
        int index = list.indexOf(readerToUpdate);
        reader.setUpdatedAt(LocalDateTime.now());
        list.remove(readerToUpdate);
        list.add(index, reader);

        return reader;
    }


    public Reader delete(String id) {

        Reader reader =  this.get(id);
        list.remove(reader);

        return reader;
    }


    public List<Reader> getAll() {
        return list;
    }
}
