package timeOffRequests.monolith.mainApp.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "Table_Administrator")
@NoArgsConstructor
public class Administrator extends Employee{

    private String rank = "Administrator";

    public Administrator(Long id, String surname, String name, String middleName, String password) {
        super(id, surname, name, middleName, password);
    }

    public String getRank() {
        return "Administrator";
    }
}
