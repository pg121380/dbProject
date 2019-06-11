package org.sfa.infomanage.bean;

public class WorkTime {

    private String employeeId;
    private String employeeName;
    private int workTime;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getWorkTime() {
        return workTime;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }

    public WorkTime(String employeeId, String employeeName, int workTime) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.workTime = workTime;
    }

    public WorkTime() {
    }

    @Override
    public String toString() {
        return "WorkTime{" +
                "employeeId='" + employeeId + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", workTime=" + workTime +
                '}';
    }
}
