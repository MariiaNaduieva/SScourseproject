package SSVSEM.model;

/*
  @author   Mariia Naduieva
  @project   SScourseproject
  @class  Reader
  @version  1.0.0 
  @since 04.08.2021 - 12.35
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Reader {
    @Id
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


    public Reader(String name, String surname, String patronymic, String address, String phone, String type, String desc) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.address = address;
        this.phone = phone;
        this.type = type;
        this.desc = desc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reader reader = (Reader) o;
        return getId().equals(reader.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", type='" + type + '\'' +
                ", desc='" + desc + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
