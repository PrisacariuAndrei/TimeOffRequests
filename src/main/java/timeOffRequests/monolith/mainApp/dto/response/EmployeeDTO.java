package timeOffRequests.monolith.mainApp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import timeOffRequests.monolith.mainApp.entity.Employee;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private Long id;
    private String surname;
    private String name;
    private String middleName;
    private String userName;
    private String password;

    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.surname = employee.getSurname();
        this.name = employee.getName();
        this.middleName = employee.getMiddleName();
        this.userName = employee.getUserName();
        this.password = employee.getPassword();
    }
}
