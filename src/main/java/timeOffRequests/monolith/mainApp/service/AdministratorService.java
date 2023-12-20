package timeOffRequests.monolith.mainApp.service;

import timeOffRequests.monolith.mainApp.dto.request.CreateEmployeeDTO;
import timeOffRequests.monolith.mainApp.dto.request.CreateAdministratorDTO;
import timeOffRequests.monolith.mainApp.dto.response.EmployeeDTO;
import timeOffRequests.monolith.mainApp.dto.response.AdministratorDTO;
import timeOffRequests.monolith.mainApp.entity.Employee;
import timeOffRequests.monolith.mainApp.entity.Administrator;

import java.util.List;
import java.util.Observer;
import java.util.function.Consumer;

public interface AdministratorService {
    //Administrator CRUD services
    public AdministratorDTO saveAdministrator(CreateAdministratorDTO createUserDTO);
    public AdministratorDTO getAdministratorDTOByID(Long administratorId);
    public List<AdministratorDTO> getAllAdministrators();
    public void deleteAdministratorById(Long administratorId);
    public Administrator updateAdministrator(Long administratorId, Administrator administrator);

    //Employee CRUD services
    public EmployeeDTO saveEmployee(CreateEmployeeDTO createUserDTO);
    public EmployeeDTO getEmployeeDTOByID(Long employeeId);
    public List<EmployeeDTO> getAllEmployee();
    public void deleteEmployeeById(Long employeeId);
    public Employee updateEmployee(Long employeeId, Employee employee);

    //Observer
    void registerObserver(AdministratorDTO observer);
    void removeObserver(Consumer<Void> observer);
    void updateDaysOff();
}
