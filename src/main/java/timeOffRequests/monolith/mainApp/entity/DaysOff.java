package timeOffRequests.monolith.mainApp.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "Table_DaysOff")
public class DaysOff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;     // The request unique id
    private LocalDate date;     // Specific date for the day off
    private String reason;      // Reason for taking the day off (e.g., vacation, sick leave)
    private int duration;       // Duration in days (for multiple-day leaves)
    private String status;      // Status of the day off (pending, approved, rejected, taken)
    private String employeeId;  // ID of the employee taking the day off
    private String approverId;  // ID of the person who approved or denied the request
    private String comments;    // Additional comments or notes related to the day off
    private String attachment;  // File or document attached to the request
    private String category;    // Category or type of the day off (e.g., vacation day, public holiday)
    private LocalDateTime createdDate;   // Date and time when the request was initially submitted
    private LocalDateTime updatedDate;   // Date and time of the last modification to the request
    private String location;    // Location where the day off will be taken

    public DaysOff() {
    }

    public DaysOff(LocalDate date, String reason, int duration, String employeeId) {
        this();  // Call the default constructor to initialize other fields
        this.date = date;
        this.reason = reason;
        this.duration = duration;
        this.employeeId = employeeId;
    }
}
