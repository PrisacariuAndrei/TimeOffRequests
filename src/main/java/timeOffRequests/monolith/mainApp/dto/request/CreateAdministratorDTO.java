package timeOffRequests.monolith.mainApp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAdministratorDTO {

    private Long id;
    private String surname;
    private String name;
    private String middleName;
    private String userName;
    private String password;
    private String rank;

    public String getPhoneNumber() {
        return "5555-12345";
    }
}
