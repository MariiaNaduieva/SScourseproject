package SSVSEM.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

/*
  @author   Mariia Naduieva
  @project   SScourseproject
  @class  Book
  @version  1.0.0 
  @since 02.08.2021 - 20.06
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Book {
        @Id
        private String id;
        private String title;
        private String author;
        private String genre;
        private double rentalPrice;
        private double bail;
        private String desc;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public Book(String title, String author, String genre, double rentalPrice, double bail, String desc) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.rentalPrice = rentalPrice;
            this.bail = bail;
            this.desc = desc;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SSVSEM.model.Book book = (SSVSEM.model.Book) o;
            return Objects.equals(id, book.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        @Override
        public String toString() {
            return "Book{" +
                    "id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    ", genre='" + genre + '\'' +
                    ", rentalPrice=" + rentalPrice +
                    ", bail=" + bail +
                    ", desc='" + desc + '\'' +
                    ", createdAt=" + createdAt +
                    ", updatedAt=" + updatedAt +
                    '}';
        }

    }

