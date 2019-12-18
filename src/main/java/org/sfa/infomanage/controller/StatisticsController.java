package org.sfa.infomanage.controller;

import com.sun.corba.se.spi.ior.ObjectKey;
import org.sfa.infomanage.bean.Employee;
import org.sfa.infomanage.bean.WorkTime;
import org.sfa.infomanage.mapper.WorkTimeMapper;
import org.sfa.infomanage.service.EducationService;
import org.sfa.infomanage.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class StatisticsController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EducationService educationService;

    @Autowired
    private WorkTimeMapper workTimeMapper;

    @RequestMapping("/statistics")
    public String toStatistics(){
        return "statistics";
    }

    @RequestMapping("/statistics/getDeptEmployeeNumber")
    @ResponseBody
    public List<HashMap<String, Object>> getDeptEmployeeNumber(){
        return employeeService.getDeptEmployeeNumber();
    }

    @RequestMapping("/statistics/getEdu")
    @ResponseBody
    public List<HashMap<String, Object>> getEmployeeEducationNumber(){
        return educationService.getEducationNumber();
    }

    @RequestMapping("/statistics/getMarriage")
    @ResponseBody
    public List<HashMap<String, Object>> getEmployeeMarriage(){
        List<Employee> employees = employeeService.getEmployees();
        long marriage = employees.stream().filter(employee -> employee.getIsMarried() == true).count();
        long unmarriage = employees.stream().filter(employee -> employee.getIsMarried() == false).count();
        HashMap<String,Object> map = new HashMap<>();
        map.put("name", "已婚");
        map.put("value", marriage);

        HashMap<String,Object> map2 = new HashMap<>();
        map2.put("name", "未婚");
        map2.put("value", unmarriage);

        List<HashMap<String,Object>> list = new ArrayList<>();
        list.add(map);
        list.add(map2);
        return list;
    }

    @RequestMapping("/statistics/workTime")
    @ResponseBody
    public List<HashMap<String,Object>> workTime(){
        List<HashMap<String,Object>> list = new ArrayList<>();
        List<WorkTime> workTimes = workTimeMapper.getWorkTimes();
        for(WorkTime workTime:workTimes){
            HashMap<String, Object> map = new HashMap<>();
            map.put("name", workTime.getEmployeeName());
            map.put("value", workTime.getWorkTime());
            list.add(map);
        }
        return list;
    }
}
