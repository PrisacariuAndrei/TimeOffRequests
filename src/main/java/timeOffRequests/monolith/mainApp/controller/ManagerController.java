package timeOffRequests.monolith.mainApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import timeOffRequests.monolith.mainApp.dto.request.CreateEmployeeDTO;
import timeOffRequests.monolith.mainApp.dto.request.CreateManagerDTO;
import timeOffRequests.monolith.mainApp.dto.response.EmployeeDTO;
import timeOffRequests.monolith.mainApp.dto.response.ManagerDTO;
import timeOffRequests.monolith.mainApp.entity.Employee;
import timeOffRequests.monolith.mainApp.entity.Manager;
import timeOffRequests.monolith.mainApp.service.ManagerService;

import java.util.List;

@Controller
@RequestMapping("/type:manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @PostMapping("/save-manager")
    ResponseEntity<ManagerDTO> saveManager(@RequestBody CreateManagerDTO newManager) {
        return new ResponseEntity<>(managerService.saveManager(newManager), HttpStatus.CREATED);
    }

    @PostMapping("/save-employee")
    ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody CreateEmployeeDTO newEmployee) {
        return new ResponseEntity<>(managerService.saveEmployee(newEmployee), HttpStatus.CREATED);
    }

    @GetMapping("/allManagers")
    ResponseEntity<List<ManagerDTO>> getAllManagers() {
        return ResponseEntity.ok(managerService.getAllManagers());
    }

    @GetMapping("/allEmployees")
    ResponseEntity<List<EmployeeDTO>> getAllEmployee() {
        return ResponseEntity.ok(managerService.getAllEmployee());
    }

    @GetMapping("/manager:{managerId}")
    ResponseEntity<ManagerDTO> getManagerById(@PathVariable("managerId") final Long managerId) {
        return ResponseEntity.ok(managerService.getManagerDTOByID(managerId));
    }

    @GetMapping("/employee:{employeeId}")
    ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("employeeId") final Long employeeId) {
        return ResponseEntity.ok(managerService.getEmployeeDTOByID(employeeId));
    }

    @PatchMapping("/manager:{managerId}")
    ResponseEntity<Manager> updateManager(@PathVariable("managerId") Long managerId, @RequestBody Manager updatedManager) {
        return ResponseEntity.ok(managerService.updateManager(managerId, updatedManager));
    }

    @PatchMapping("/employee:{employeeId}")
    ResponseEntity<Employee> updateEmployee(@PathVariable("employeeId") Long employeeId, @RequestBody Employee updatedEmployee) {
        return ResponseEntity.ok(managerService.updateEmployee(employeeId,updatedEmployee));
    }

    @DeleteMapping("/manager:{managerId}")
    public void deleteManagerById(@PathVariable("managerId") Long managerId) {
        managerService.deleteManagerById(managerId);
    }

    @DeleteMapping("/employee:{employeeId}")
    public void deleteEmployeeById(@PathVariable("employeeId") Long employeeId) {
        managerService.deleteEmployeeById(employeeId);
    }
}
