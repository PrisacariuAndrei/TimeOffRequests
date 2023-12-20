package timeOffRequests.monolith.mainApp.singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import timeOffRequests.monolith.mainApp.dto.response.AdministratorDTO;
import timeOffRequests.monolith.mainApp.dto.response.DaysOffDTO;
import timeOffRequests.monolith.mainApp.dto.response.EmployeeDTO;
import timeOffRequests.monolith.mainApp.entity.Employee;
import timeOffRequests.monolith.mainApp.repository.AdministratorRepository;
import timeOffRequests.monolith.mainApp.repository.DaysOffRepository;
import timeOffRequests.monolith.mainApp.repository.EmployeeRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportGenerator {
    private static ReportGenerator instance;

    @Autowired
    private final DaysOffRepository daysOffRepository;
    @Autowired
    private final AdministratorRepository administratorRepository;
    @Autowired
    private final EmployeeRepository employeeRepository;

    private ReportGenerator(DaysOffRepository daysOffRepository, AdministratorRepository administratorRepository, EmployeeRepository employeeRepository) {
        this.daysOffRepository = daysOffRepository;
        this.administratorRepository = administratorRepository;
        this.employeeRepository = employeeRepository;
    }

    // Public method to get the singleton instance
    public static ReportGenerator getInstance() {
        if (instance == null) {
            instance = new ReportGenerator(getInstance().daysOffRepository, getInstance().administratorRepository, getInstance().employeeRepository);
        }
        return instance;
    }

    // Methods for generating reports
    public List<DaysOffDTO> getAllReports() {
        return daysOffRepository.findAll().stream()
                .map(DaysOffDTO::new)
                .collect(Collectors.toList());
    }

    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(EmployeeDTO::new)
                .collect(Collectors.toList());
    }

    public List<AdministratorDTO> getAllAdministrators() {
        return administratorRepository.findAll().stream()
                .map(AdministratorDTO::new)
                .collect(Collectors.toList());
    }
}
