package org.sfa.infomanage.utils;

import org.sfa.infomanage.service.DepartmentService;
import org.sfa.infomanage.service.EmployeeService;
import org.sfa.infomanage.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Converter {
    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private PostService postService;

    @Autowired
    private EmployeeService employeeService;

    private HashMap<String,String> convertMap;

    public String convert(String id){
        Map<String,String> postMap = postService.getPostMap();
        Map<String,String> deptMap = departmentService.getDeptMap();
        Map<String,String> empMap = employeeService.getEmployeeIdToNameMap();

        convertMap = new HashMap<>();
        convertMap.putAll(deptMap);
        convertMap.putAll(postMap);
        convertMap.putAll(empMap);
        return convertMap.get(id);
    }
}
