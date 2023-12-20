package timeOffRequests.monolith.mainApp.singleton;

import timeOffRequests.monolith.mainApp.entity.DaysOff;
import timeOffRequests.monolith.mainApp.entity.Employee;

import java.util.Collections;
import java.util.List;

public class ReportGenerator {
    private static ReportGenerator instance;

    private ReportGenerator() {
    }

    // Public method to get the singleton instance
    public static ReportGenerator getInstance() {
        if (instance == null) {
            instance = new ReportGenerator();
        }
        return instance;
    }

    // Methods for generating reports
    public List<DaysOff> getAllReports() {
        // Implementation for getting all reports TODO
        return Collections.emptyList(); // Placeholder, replace with actual implementation
    }

    public List<Employee> getAllEmployees() {
        // Implementation for getting all employees TODO
        return Collections.emptyList(); // Placeholder, replace with actual implementation
    }
}
