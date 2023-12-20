package timeOffRequests.monolith.mainApp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import timeOffRequests.monolith.mainApp.ApiException;
import timeOffRequests.monolith.mainApp.ErrorCode;
import timeOffRequests.monolith.mainApp.dto.request.CreateEmployeeDTO;
import timeOffRequests.monolith.mainApp.dto.request.CreateAdministratorDTO;
import timeOffRequests.monolith.mainApp.dto.response.EmployeeDTO;
import timeOffRequests.monolith.mainApp.dto.response.AdministratorDTO;
import timeOffRequests.monolith.mainApp.entity.DaysOff;
import timeOffRequests.monolith.mainApp.entity.Employee;
import timeOffRequests.monolith.mainApp.entity.Administrator;
import timeOffRequests.monolith.mainApp.observer.DaysOffObserver;
import timeOffRequests.monolith.mainApp.repository.EmployeeRepository;
import timeOffRequests.monolith.mainApp.repository.AdministratorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Service
public class AdministratorServiceImplementation implements AdministratorService {

    @Autowired
    private final AdministratorRepository administratorRepository;
    @Autowired
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public AdministratorServiceImplementation(AdministratorRepository administratorRepository, EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.administratorRepository = administratorRepository;
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public Administrator toAdministrator(CreateAdministratorDTO createUserDTO) {
        return modelMapper.map(createUserDTO, Administrator.class);
    }

    public AdministratorDTO toAdministratorDTO(Administrator administrator) {
        return modelMapper.map(administrator, AdministratorDTO.class);
    }

    @Override
    public AdministratorDTO saveAdministrator(CreateAdministratorDTO createUserDTO) {
        Administrator savedAdministrator = toAdministrator(createUserDTO);
        savedAdministrator = administratorRepository.save(savedAdministrator);

        return toAdministratorDTO(savedAdministrator);
    }

    public AdministratorDTO getAdministratorDTOByID(Long administratorId) {
        Administrator administratorById = administratorRepository.findById(administratorId).orElseThrow(() -> new ApiException(ErrorCode.USER_NOT_FOUND));
        return toAdministratorDTO(administratorById);
    }

    @Override
    public List<AdministratorDTO> getAllAdministrators() {
        return administratorRepository.findAll().stream()
                .map(AdministratorDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAdministratorById(Long administratorId) {
        Administrator administratorDTO = administratorRepository.findById(administratorId).orElseThrow(() -> new ApiException(ErrorCode.USER_NOT_FOUND));

        administratorRepository.deleteById(administratorId);
    }

    @Override
    public Administrator updateAdministrator(Long administratorId, Administrator administrator) {
        Administrator administratorById = administratorRepository.findById(administratorId).orElseThrow(() -> new ApiException(ErrorCode.USER_NOT_FOUND));
        administratorById.setName(administrator.getName());
        administratorById.setSurname(administrator.getSurname());
        administratorById.setMiddleName(administrator.getMiddleName());
        administratorById.setPassword(administrator.getPassword());
        administratorById.setRank(administrator.getRank());

        Administrator updatedAdministrator = administratorRepository.save(administratorById);
        return updatedAdministrator;
    }

    public Employee toEmployee(CreateEmployeeDTO createUserDTO) {
        return modelMapper.map(createUserDTO, Employee.class);
    }

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

        Employee updatedEmployee = employeeRepository.save(employeeById);
        return updatedEmployee;
    }

    // Implementing the logic for Observer here
    private List<Consumer<AdministratorDTO>> observers = new ArrayList<>();

    @Override
    public void registerObserver(AdministratorDTO observer) {
        observers.add((Consumer<AdministratorDTO>) observer);
    }

    @Override
    public void removeObserver(Consumer<Void> observer) {
        observers.remove(observer);
    }

    @Override
    public void updateDaysOff() {
        // Perform DaysOff update logic

        // Notify observers
        //notifyObservers();
    }

//    private void notifyObservers(DaysOff daysOff) {
//        for (Observer observer : observers) {
//            observer.update(daysOff);
//        }
//    }
//
    private void notifyObservers(AdministratorDTO administratorDTO) {
        for (Consumer<AdministratorDTO> admin: observers) {
            admin.accept(administratorDTO);
        }
    }

}
