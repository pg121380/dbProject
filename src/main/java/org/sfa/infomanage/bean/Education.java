package org.sfa.infomanage.bean;

import java.util.Date;

public class Education {

    private String employeeId;
    private String eduBackground;
    private String major;   //专业
    private Date graduateDate;  // 毕业时间
    private String graduateSchool;  //毕业院校
    private String foreignLang; //外语水平

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEduBackground() {
        return eduBackground;
    }

    public void setEduBackground(String eduBackground) {
        this.eduBackground = eduBackground;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Date getGraduateDate() {
        return graduateDate;
    }

    public void setGraduateDate(Date graduateDate) {
        this.graduateDate = graduateDate;
    }

    public String getGraduateSchool() {
        return graduateSchool;
    }

    public void setGraduateSchool(String graduateSchool) {
        this.graduateSchool = graduateSchool;
    }

    public String getForeignLang() {
        return foreignLang;
    }

    public void setForeignLang(String foreignLang) {
        this.foreignLang = foreignLang;
    }

    @Override
    public String toString() {
        return "Education{" +
                "employeeId='" + employeeId + '\'' +
                ", eduBackground='" + eduBackground + '\'' +
                ", major='" + major + '\'' +
                ", graduateDate=" + graduateDate +
                ", graduateSchool='" + graduateSchool + '\'' +
                ", foreignLang='" + foreignLang + '\'' +
                '}';
    }

    public Education() {
    }

    public Education(String employeeId, String eduBackground, String major, Date graduateDate, String graduateSchool, String foreignLang) {
        this.employeeId = employeeId;
        this.eduBackground = eduBackground;
        this.major = major;
        this.graduateDate = graduateDate;
        this.graduateSchool = graduateSchool;
        this.foreignLang = foreignLang;
    }
}
