package SSVSEM.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/*
  @author   Mariia Naduieva
  @project   SScourseproject
  @class  ReaderUpdateForm
  @version  1.0.0 
  @since 04.08.2021 - 14.52
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReaderUpdateForm {
    private String id;
    private String name;
    private String surname;
    private String patronymic;
    private String address;
    private String phone;
    private String type;
    private String desc;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
