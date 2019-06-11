package org.sfa.bean;

import java.util.Date;

public class Employee {
	
	private String employeeId;
	private String employeeName;
	private int age;
	private String postNumber;		//岗位号
	private Date hireDate;		//入职时间
	private String title;		//职称
	private boolean isMarried;	// 已/未婚
	private String deptNumber;
	
	
	
	public Employee() {
		
	}
	
	public Employee(String employeeId, String employeeName, int age,
			String postNumber, Date hireDate, String title, boolean isMarried,
			String deptNumber) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.age = age;
		this.postNumber = postNumber;
		this.hireDate = hireDate;
		this.title = title;
		this.isMarried = isMarried;
		this.deptNumber = deptNumber;
	}

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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPostNumber() {
		return postNumber;
	}
	public void setPostNumber(String postNumber) {
		this.postNumber = postNumber;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isMarried() {
		return isMarried;
	}
	public void setMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}
	public String getDeptNumber() {
		return deptNumber;
	}
	public void setDeptNumber(String deptNumber) {
		this.deptNumber = deptNumber;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName="
				+ employeeName + ", age=" + age + ", postNumber=" + postNumber
				+ ", hireDate=" + hireDate + ", title=" + title
				+ ", isMarried=" + isMarried + ", deptNumber=" + deptNumber
				+ "]";
	}
}
