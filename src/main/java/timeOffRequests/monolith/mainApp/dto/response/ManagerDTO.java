package timeOffRequests.monolith.mainApp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import timeOffRequests.monolith.mainApp.entity.Manager;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManagerDTO {

    private Long id;
    private String surname;
    private String name;
    private String middleName;
    private String userName;
    private String password;
    private String rank;

    public ManagerDTO(Manager manager) {
        this.id = manager.getId();
        this.surname = manager.getSurname();
        this.name = manager.getName();
        this.middleName = manager.getMiddleName();
        this.userName = manager.getUserName();
        this.password = manager.getPassword();
        this.rank = manager.getRank();
    }
}
