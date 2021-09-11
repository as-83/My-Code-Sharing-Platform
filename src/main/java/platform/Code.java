package platform;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "code")
@JsonIgnoreProperties("id")
public  class Code {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private  LocalDateTime date;
    private String code;

    public Code() {
    }

    public Code(LocalDateTime date, String code) {
        this.date = date;
        this.code = code;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public  String getDate() {
        if(date != null) {
            return DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(date);
        }
        return null;
    }

    public  void setDate(LocalDateTime date) {
        this.date = date;
    }

    public  String getCode() {
        return code;
    }

    public  void setCode(String code) {
        this.code = code;
    }
}
