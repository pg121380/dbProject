package org.sfa.infomanage.controller;

import org.sfa.infomanage.bean.Department;
import org.sfa.infomanage.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/getDept")
    @ResponseBody
    public Department getDepartmentById(@RequestParam("deptId") String deptId){
        return departmentService.getDepartmentById(deptId);
    }
}
