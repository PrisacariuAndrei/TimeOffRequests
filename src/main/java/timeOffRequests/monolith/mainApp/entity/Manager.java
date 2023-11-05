package timeOffRequests.monolith.mainApp.entity;


import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Table_Manager")
@NoArgsConstructor
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nonnull
    private String surname;

    @Nonnull
    private String name;

    private String middleName;

    private String userName = surname + name;

    @Nonnull
    private String password;

    private String rank = "Manager";

    public Manager(Long id, String surname, String name, String middleName, String password) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.password = password;
    }
}
