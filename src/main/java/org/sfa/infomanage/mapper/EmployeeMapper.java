package org.sfa.infomanage.mapper;

import org.apache.ibatis.annotations.*;
import org.sfa.infomanage.bean.Employee;
import org.sfa.infomanage.sqlprovider.EmployeeSQLProvider;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Repository
public interface EmployeeMapper {

    @Select("select * from employee")
    List<Employee> getEmployees();

    @Insert("insert into employee values(#{employeeId},#{employeeName},#{age},#{postNumber},#{hireDate},#{title},#{deptNumber},#{isMarried})")
    void addEmployee(String employeeId, String employeeName, int age, String postNumber, Date hireDate,String title,String deptNumber,boolean isMarried);

    @Update("update employee set employeeName=#{employeeName},age=#{age},postNumber=#{postNumber},hireDate=#{hireDate},title=#{title},deptNumber=#{deptNumber},isMarried=#{isMarried} where employeeId=#{employeeId}")
    int updateEmployeeById(Employee employee);

    @Delete("delete from employee where employeeId=#{id}")
    int deleteEmployeeById(String id);

    @Select("select * from employee where employeeId=#{id}")
    Employee getEmployeeById(String id);

    @SelectProvider(type = EmployeeSQLProvider.class,method = "getQuerySql")
    List<Employee> getEmployeeByCondition(Employee employee);

    @Select("select COUNT(*) as value,deptName as name from employee,department where employee.deptNumber=department.deptNumber group by(deptName)")
    List<HashMap<String,Object>> getDeptEmployeeMap();

    @Select("select COUNT(*) as value,employee.isMarried as name from employee group by(isMarried)")
    List<HashMap<String,Object>> getEmployeeMarriage();
}
