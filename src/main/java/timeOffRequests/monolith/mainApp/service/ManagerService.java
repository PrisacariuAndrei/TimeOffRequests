package timeOffRequests.monolith.mainApp.service;

import timeOffRequests.monolith.mainApp.dto.request.CreateEmployeeDTO;
import timeOffRequests.monolith.mainApp.dto.request.CreateManagerDTO;
import timeOffRequests.monolith.mainApp.dto.response.EmployeeDTO;
import timeOffRequests.monolith.mainApp.dto.response.ManagerDTO;
import timeOffRequests.monolith.mainApp.entity.Employee;
import timeOffRequests.monolith.mainApp.entity.Manager;

import java.util.List;

public interface ManagerService {
    //Manager CRUD services
    public ManagerDTO saveManager(CreateManagerDTO createUserDTO);
    public ManagerDTO getManagerDTOByID(Long managerId);
    public List<ManagerDTO> getAllManagers();
    public void deleteManagerById(Long managerId);
    public Manager updateManager(Long managerId, Manager manager);

    //Employee CRUD services
    public EmployeeDTO saveEmployee(CreateEmployeeDTO createUserDTO);
    public EmployeeDTO getEmployeeDTOByID(Long employeeId);
    public List<EmployeeDTO> getAllEmployee();
    public void deleteEmployeeById(Long employeeId);
    public Employee updateEmployee(Long employeeId, Employee employee);
}
