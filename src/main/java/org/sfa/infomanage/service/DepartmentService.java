package org.sfa.infomanage.service;

import org.sfa.infomanage.bean.Department;
import org.sfa.infomanage.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    public Department getDepartmentById(String deptId){
        return departmentMapper.getDepartmentById(deptId);
    }

    public HashMap<String,String> getDeptMap(){
        HashMap<String, String> map = new HashMap<>();
        List<Department> departments = departmentMapper.getAllDepartments();
        for(Department department:departments){
            map.put(department.getDeptId(),department.getDeptName());
        }
        return map;
    }

    public List<Department> getAllDepartments(){
        return departmentMapper.getAllDepartments();
    }
}
