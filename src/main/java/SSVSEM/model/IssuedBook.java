package SSVSEM.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

/*
  @author   Mariia Naduieva
  @project   SScourseproject
  @class  IssuedBook
  @version  1.0.0 
  @since 05.08.2021 - 18.18
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class IssuedBook {
    @Id
    private String id;
    private Book book;
    private Reader reader;
    private String issueDate;
    private String returnDate;
    private int discount;
    private String desc;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public IssuedBook(Book book, Reader reader, String issueDate, String returnDate, int discount, String desc) {
        this.book = book;
        this.reader = reader;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.discount = discount;
        this.desc = desc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IssuedBook that = (IssuedBook) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "IssuedBook{" +
                "id='" + id + '\'' +
                ", book=" + book +
                ", reader=" + reader +
                ", issueDate=" + issueDate +
                ", returnDate=" + returnDate +
                ", discount=" + discount +
                ", desc='" + desc + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
