package SSVSEM.form;

import SSVSEM.model.Book;
import SSVSEM.model.IssuedBook;
import SSVSEM.model.Reader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/*
  @author   Mariia Naduieva
  @project   SScourseproject
  @class  IssuedBookUpdateForm
  @version  1.0.0 
  @since 05.08.2021 - 20.33
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssuedBookUpdateForm {
    private String id;
    private String book;
    private String reader;
    private String issueDate;
    private String returnDate;
    private int discount;
    private String desc;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public IssuedBookUpdateForm(IssuedBook issuedBook) {
        this.id = issuedBook.getId();
        this.book = issuedBook.getBook().getTitle();
        this.reader = issuedBook.getReader().getName() + " " + issuedBook.getReader().getSurname() + " "
                + issuedBook.getReader().getPatronymic();
        this.issueDate = issuedBook.getIssueDate();
        this.returnDate = issuedBook.getReturnDate();
        this.discount = issuedBook.getDiscount();
        this.desc = issuedBook.getDesc();
        this.createdAt = issuedBook.getCreatedAt();
        this.updatedAt = issuedBook.getUpdatedAt();
    }
}
