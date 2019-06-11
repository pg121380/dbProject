package org.sfa.infomanage.controller;

import org.sfa.infomanage.bean.Education;
import org.sfa.infomanage.bean.Employee;
import org.sfa.infomanage.service.EducationService;
import org.sfa.infomanage.service.EmployeeService;
import org.sfa.infomanage.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class EducationController {

    @Autowired
    private EducationService educationService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private Converter converter;

    @RequestMapping("/getEducations")
    public String getAllEducations(Model model){
        List<Education> educations = educationService.getAllEducations();
        model.addAttribute("educations", educations);
        model.addAttribute("converter", converter);
        return "education";
    }
    //TODO：完成按照学历查询 以及对学历的修改删除和添加 按学历统计职工信息
}
