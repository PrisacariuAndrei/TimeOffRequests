package timeOffRequests.monolith.mainApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import timeOffRequests.monolith.mainApp.dto.request.CreateAdministratorDTO;
import timeOffRequests.monolith.mainApp.dto.request.CreateDaysOffDTO;
import timeOffRequests.monolith.mainApp.dto.response.AdministratorDTO;
import timeOffRequests.monolith.mainApp.dto.response.DaysOffDTO;
import timeOffRequests.monolith.mainApp.entity.DaysOff;
import timeOffRequests.monolith.mainApp.service.EmployeeService;

@Controller
@RequestMapping("/type:employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save-daysOff")
    ResponseEntity<DaysOffDTO> saveDaysOff(@RequestBody CreateDaysOffDTO newDaysOff) {
        return new ResponseEntity<>(employeeService.saveDaysOff(newDaysOff), HttpStatus.CREATED);
    }

  /*  @PostMapping("/save-daysOff:{type}")
    ResponseEntity<DaysOffDTO> saveDaysOff(@RequestBody CreateDaysOffDTO newDaysOff,
                                           @RequestParam(name = "type") String type) {
        return new ResponseEntity<>(employeeService.saveDaysOff(newDaysOff, type), HttpStatus.CREATED);
    }*/
}
