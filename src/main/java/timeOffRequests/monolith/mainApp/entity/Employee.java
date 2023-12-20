package timeOffRequests.monolith.mainApp.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Entity
@Data
@Table(name = "Table_Employee")
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Nonnull
    private String surname;
    @Nonnull
    private String name;
    private String middleName;
    @Nonnull
    private String password;
    private int yearsInCompany;
    //private HashMap<String, Integer> daysOffHistory;

    public Employee(Long id, @Nonnull String surname, @Nonnull String name, String middleName, @Nonnull String password) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.password = password;
    }

    public String getUserName() {
        return getSurname() + getName();
    }

}
