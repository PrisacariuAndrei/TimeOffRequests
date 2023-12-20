package timeOffRequests.monolith.mainApp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import timeOffRequests.monolith.mainApp.entity.Administrator;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdministratorDTO {

    private Long id;
    private String surname;
    private String name;
    private String middleName;
    private String userName;
    private String password;
    private String rank;

    public AdministratorDTO(Administrator administrator) {
        this.id = administrator.getId();
        this.surname = administrator.getSurname();
        this.name = administrator.getName();
        this.middleName = administrator.getMiddleName();
        this.userName = administrator.getUserName();
        this.password = administrator.getPassword();
        this.rank = administrator.getRank();
    }
}
