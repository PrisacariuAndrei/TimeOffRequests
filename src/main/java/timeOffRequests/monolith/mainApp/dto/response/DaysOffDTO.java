package timeOffRequests.monolith.mainApp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import timeOffRequests.monolith.mainApp.entity.DaysOff;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DaysOffDTO {

    private Long requestId;
    private LocalDate date;
    private String reason;
    private int duration;
    private String status;
    private String employeeId;
    private String approverId;
    private String comments;
    private String attachment;
    private String category;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private String location;

    public DaysOffDTO (DaysOff daysOff) {
        this.requestId = daysOff.getRequestId();
        this.date = daysOff.getDate();
        this.reason = daysOff.getReason();
        this.duration = daysOff.getDuration();
        this.status = daysOff.getStatus();
        this.employeeId = daysOff.getEmployeeId();
        this.approverId = daysOff.getApproverId();
        this.comments = daysOff.getComments();
        this.attachment = daysOff.getAttachment();
        this.createdDate = daysOff.getCreatedDate();
        this.updatedDate = daysOff.getUpdatedDate();
        this.location = daysOff.getLocation();
    }
}
