package timeOffRequests.monolith.mainApp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import timeOffRequests.monolith.mainApp.ApiException;
import timeOffRequests.monolith.mainApp.ErrorCode;
import timeOffRequests.monolith.mainApp.dto.request.CreateEmployeeDTO;
import timeOffRequests.monolith.mainApp.dto.request.CreateManagerDTO;
import timeOffRequests.monolith.mainApp.dto.response.EmployeeDTO;
import timeOffRequests.monolith.mainApp.dto.response.ManagerDTO;
import timeOffRequests.monolith.mainApp.entity.Employee;
import timeOffRequests.monolith.mainApp.entity.Manager;
import timeOffRequests.monolith.mainApp.repository.EmployeeRepository;
import timeOffRequests.monolith.mainApp.repository.ManagerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManagerServiceImplementation implements ManagerService {

    @Autowired
    private final ManagerRepository managerRepository;
    @Autowired
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public ManagerServiceImplementation(ManagerRepository managerRepository, EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.managerRepository = managerRepository;
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public Manager toManager(CreateManagerDTO createUserDTO) {return modelMapper.map(createUserDTO, Manager.class);}
    public ManagerDTO toManagerDTO(Manager manager) {
        return modelMapper.map(manager, ManagerDTO.class);
    }


    @Override
    public ManagerDTO saveManager(CreateManagerDTO createUserDTO) {
        Manager savedManager = toManager(createUserDTO);
        savedManager = managerRepository.save(savedManager);

        return toManagerDTO(savedManager);
    }

    @Override
    public ManagerDTO getManagerDTOByID(Long managerId) {
        Manager managerById = managerRepository.findById(managerId).orElseThrow(() -> new ApiException(ErrorCode.USER_NOT_FOUND));
        return toManagerDTO(managerById);
    }

    @Override
    public List<ManagerDTO> getAllManagers() {
        return managerRepository.findAll().stream()
                .map(ManagerDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteManagerById(Long managerId) {
        Manager managerDTO = managerRepository.findById(managerId).orElseThrow(() -> new ApiException(ErrorCode.USER_NOT_FOUND));

        managerRepository.deleteById(managerId);
    }

    @Override
    public Manager updateManager(Long managerId, Manager manager) {
        Manager managerById = managerRepository.findById(managerId).orElseThrow(() -> new ApiException(ErrorCode.USER_NOT_FOUND));
        managerById.setName(manager.getName());
        managerById.setSurname(manager.getSurname());
        managerById.setMiddleName(manager.getMiddleName());
        managerById.setPassword(manager.getPassword());
        managerById.setRank(manager.getRank());
        managerById.setUserName(manager.getUserName());

        Manager updatedManager = managerRepository.save(managerById);
        return updatedManager;
    }

    public Employee toEmployee(CreateEmployeeDTO createUserDTO) {return modelMapper.map(createUserDTO, Employee.class);}
    public EmployeeDTO toEmployeeDTO(Employee employee) {
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO saveEmployee(CreateEmployeeDTO createUserDTO) {
        Employee savedEmployee = toEmployee(createUserDTO);
        savedEmployee = employeeRepository.save(savedEmployee);

        return toEmployeeDTO(savedEmployee);
    }

    @Override
    public EmployeeDTO getEmployeeDTOByID(Long employeeId) {
        Employee employeeById = employeeRepository.findById(employeeId).orElseThrow(() -> new ApiException(ErrorCode.USER_NOT_FOUND));
        return toEmployeeDTO(employeeById);
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        return employeeRepository.findAll().stream()
                .map(EmployeeDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {
        Employee employeeDTO = employeeRepository.findById(employeeId).orElseThrow(() -> new ApiException(ErrorCode.USER_NOT_FOUND));

        employeeRepository.deleteById(employeeId);
    }

    @Override
    public Employee updateEmployee(Long employeeId, Employee employee) {
        Employee employeeById = employeeRepository.findById(employeeId).orElseThrow(() -> new ApiException(ErrorCode.USER_NOT_FOUND));
        employeeById.setName(employee.getName());
        employeeById.setSurname(employee.getSurname());
        employeeById.setMiddleName(employee.getMiddleName());
        employeeById.setPassword(employee.getPassword());
        employeeById.setRank(employee.getRank());
        employeeById.setUserName(employee.getUserName());

        Employee updatedEmployee = employeeRepository.save(employeeById);
        return updatedEmployee;
    }
}
