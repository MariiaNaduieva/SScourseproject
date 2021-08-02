package SSVSEM.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/*
  @author   Mariia Naduieva
  @project   SScourseproject
  @class  BookUpdateForm
  @version  1.0.0 
  @since 02.08.2021 - 20.51
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookUpdateForm {
    private String id;
    private String title;
    private String author;
    private String genre;
    private double rentalPrice;
    private double bail;
    private String desc;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
