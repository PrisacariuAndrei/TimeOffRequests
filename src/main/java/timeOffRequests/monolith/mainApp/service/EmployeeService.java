package timeOffRequests.monolith.mainApp.service;

import timeOffRequests.monolith.mainApp.dto.request.CreateDaysOffDTO;
import timeOffRequests.monolith.mainApp.dto.response.DaysOffDTO;
import timeOffRequests.monolith.mainApp.entity.DaysOff;

import java.util.List;

public interface EmployeeService {
    public DaysOffDTO saveDaysOff(CreateDaysOffDTO createDaysOffDTO);
    public DaysOffDTO getDaysOffDTOById(Long daysOffId);
    public List<DaysOffDTO> getAllDaysOff();
    public void deleteDaysOffById(Long daysOffId);
    public DaysOff updateDaysOff(Long daysOffId, DaysOff daysOff);
}
