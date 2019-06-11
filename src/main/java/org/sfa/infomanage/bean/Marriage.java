package org.sfa.infomanage.bean;

public class Marriage {
    private String employeeId;
    private String spouseName;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public Marriage(String employeeId, String spouseName) {
        this.employeeId = employeeId;
        this.spouseName = spouseName;
    }

    public Marriage() {
    }
}
