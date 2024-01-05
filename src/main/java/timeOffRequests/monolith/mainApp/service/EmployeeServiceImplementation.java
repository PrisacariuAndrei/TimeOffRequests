package timeOffRequests.monolith.mainApp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import timeOffRequests.monolith.mainApp.ApiException;
import timeOffRequests.monolith.mainApp.ErrorCode;
import timeOffRequests.monolith.mainApp.dto.request.CreateDaysOffDTO;
import timeOffRequests.monolith.mainApp.dto.response.AdministratorDTO;
import timeOffRequests.monolith.mainApp.dto.response.DaysOffDTO;
import timeOffRequests.monolith.mainApp.entity.DaysOff;
import timeOffRequests.monolith.mainApp.factory.*;
import timeOffRequests.monolith.mainApp.repository.DaysOffRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    @Autowired
    private final DaysOffRepository repository;
    private final ModelMapper modelMapper;

    public EmployeeServiceImplementation(DaysOffRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public DaysOff toDaysOff(CreateDaysOffDTO createDaysOffDTO){
        return modelMapper.map(createDaysOffDTO, DaysOff.class);
    }

    public DaysOffDTO toDaysOffDTO(DaysOff daysOff) {
        return modelMapper.map(daysOff, DaysOffDTO.class);
    }

    @Override
    public DaysOffDTO saveDaysOff(CreateDaysOffDTO createDaysOffDTO) {
        DaysOff savedDaysOff = toDaysOff(createDaysOffDTO);

        DaysOff factory;
        switch (savedDaysOff.getCategory()) {
            case "paid" -> factory = new PaidDaysOffFactory().createDaysOff();
            case "medical" -> factory = new MedicalDaysOffFactory().createDaysOff();
            case "halfpaid" -> factory = new HalfPaidDaysOffFactory().createDaysOff();
            case "special" -> factory = new SpecialDaysOffFactory().createDaysOff();
            default -> factory = new UnpaidDaysOffFactory().createDaysOff();
        }

        savedDaysOff.setStatus("Pending");
        savedDaysOff.setReason(factory.getReason());
        savedDaysOff.setComments(factory.getComments());
        savedDaysOff.setCreatedDate(factory.getCreatedDate());

        savedDaysOff = repository.save(savedDaysOff);
        return toDaysOffDTO(savedDaysOff);
    }

    @Override
    public DaysOffDTO getDaysOffDTOById(Long daysOffId) {
        DaysOff daysOffById = repository.findById(daysOffId).orElseThrow(() -> new ApiException(ErrorCode.REQUEST_NOT_FOUND));
        return toDaysOffDTO(daysOffById);
    }

    @Override
    public List<DaysOffDTO> getAllDaysOff() {
        return repository.findAll().stream()
                .map(DaysOffDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteDaysOffById(Long daysOffId) {
        DaysOff daysOffById = repository.findById(daysOffId).orElseThrow(() -> new ApiException(ErrorCode.REQUEST_NOT_FOUND));

        repository.deleteById(daysOffId);
    }

    @Override
    public DaysOff updateDaysOff(Long daysOffId, DaysOff daysOff) {
        return null;
    }

    // Implementing the logic for Observer here
    private List<Consumer<DaysOffDTO>> observers = new ArrayList<>();

    @Override
    public void registerObserver(DaysOffDTO observer) {
        observers.add((Consumer<DaysOffDTO>) observer);
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
    private void notifyObservers(DaysOffDTO daysOffDTO) {
        for (Consumer<DaysOffDTO> report: observers) {
            report.accept(daysOffDTO);
        }
    }
}
