package timeOffRequests.monolith.mainApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import timeOffRequests.monolith.mainApp.dto.request.CreateEmployeeDTO;
import timeOffRequests.monolith.mainApp.dto.request.CreateAdministratorDTO;
import timeOffRequests.monolith.mainApp.dto.response.DaysOffDTO;
import timeOffRequests.monolith.mainApp.dto.response.EmployeeDTO;
import timeOffRequests.monolith.mainApp.dto.response.AdministratorDTO;
import timeOffRequests.monolith.mainApp.entity.Employee;
import timeOffRequests.monolith.mainApp.entity.Administrator;
import timeOffRequests.monolith.mainApp.observer.DaysOffObserver;
import timeOffRequests.monolith.mainApp.service.AdministratorService;

import java.util.List;

@Controller
@RequestMapping("/type:admin")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;
    @Autowired
    private List<DaysOffObserver> observers;

    @PostMapping("/save-administrator")
    ResponseEntity<AdministratorDTO> saveAdministrator(@RequestBody CreateAdministratorDTO newAdministrator) {
        return new ResponseEntity<>(administratorService.saveAdministrator(newAdministrator), HttpStatus.CREATED);
    }

    @PostMapping("/save-employee")
    ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody CreateEmployeeDTO newEmployee) {
        return new ResponseEntity<>(administratorService.saveEmployee(newEmployee), HttpStatus.CREATED);
    }

    @GetMapping("/allAdministrator")
    ResponseEntity<List<AdministratorDTO>> getAllAdministrator() {
        return ResponseEntity.ok(administratorService.getAllAdministrators());
    }

    @GetMapping("/allEmployees")
    ResponseEntity<List<EmployeeDTO>> getAllEmployee() {
        return ResponseEntity.ok(administratorService.getAllEmployee());
    }

    @GetMapping("/administrator:{administratorId}")
    ResponseEntity<AdministratorDTO> getAdministratorById(@PathVariable("administratorId") final Long administratorId) {
        return ResponseEntity.ok(administratorService.getAdministratorDTOByID(administratorId));
    }

    @GetMapping("/employee:{employeeId}")
    ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("employeeId") final Long employeeId) {
        return ResponseEntity.ok(administratorService.getEmployeeDTOByID(employeeId));
    }

    @PatchMapping("/manager:{managerId}")
    ResponseEntity<Administrator> updateManager(@PathVariable("managerId") Long managerId, @RequestBody Administrator updatedAdministrator) {
        return ResponseEntity.ok(administratorService.updateAdministrator(managerId, updatedAdministrator));
    }

    @PatchMapping("/employee:{employeeId}")
    ResponseEntity<Employee> updateEmployee(@PathVariable("employeeId") Long employeeId, @RequestBody Employee updatedEmployee) {
        return ResponseEntity.ok(administratorService.updateEmployee(employeeId, updatedEmployee));
    }

    @DeleteMapping("/manager:{managerId}")
    public void deleteManagerById(@PathVariable("managerId") Long managerId) {
        administratorService.deleteAdministratorById(managerId);
    }

    @DeleteMapping("/employee:{employeeId}")
    public void deleteEmployeeById(@PathVariable("employeeId") Long employeeId) {
        administratorService.deleteEmployeeById(employeeId);
    }

    @GetMapping("/allReports")
    ResponseEntity<List<DaysOffDTO>> getAllReports() {
        return ResponseEntity.ok(administratorService.getAllReports());
    }
}
