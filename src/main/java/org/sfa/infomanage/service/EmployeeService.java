package org.sfa.infomanage.service;

import org.sfa.infomanage.bean.Employee;
import org.sfa.infomanage.bean.WorkTime;
import org.sfa.infomanage.mapper.EmployeeMapper;
import org.sfa.infomanage.mapper.WorkTimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private WorkTimeMapper workTimeMapper;

    public List<Employee> getEmployees(){
        return employeeMapper.getEmployees();
    }

    @Transactional
    public void addEmployee(Employee employee){
        employeeMapper.addEmployee(employee.getEmployeeId(),employee.getEmployeeName(),employee.getAge(),employee.getPostNumber()
        , employee.getHireDate(),employee.getTitle(),employee.getDeptNumber(),employee.getIsMarried());
    }

    public Map<String,String> getEmployeeIdToNameMap(){
        HashMap<String,String> map = new HashMap<>();

        List<Employee> employees = getEmployees();
        for(Employee employee:employees){
            map.put(employee.getEmployeeId(), employee.getEmployeeName());
        }
        return map;
    }

    public int deleteEmployeeById(String id){
        return employeeMapper.deleteEmployeeById(id);
    }

    public int updateEmployeeById(Employee employee){
        return employeeMapper.updateEmployeeById(employee);
    }

    public Employee getEmployeeById(String id){
        return employeeMapper.getEmployeeById(id);
    }

    public List<Employee> getEmployeeByCondition(Employee employee){
        return employeeMapper.getEmployeeByCondition(employee);
    }

    public List<WorkTime> getWorkTimeByTime(int time){
        return workTimeMapper.getWorkTimeByTime(time);
    }

    public List<WorkTime> getWorkTimes(){
        return workTimeMapper.getWorkTimes();
    }

    public List<HashMap<String,Object>> getDeptEmployeeNumber(){
        return employeeMapper.getDeptEmployeeMap();
    }

    public List<HashMap<String,Object>> getEmployeeMarriage(){
        return employeeMapper.getEmployeeMarriage();
    }
}
