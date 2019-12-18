package org.sfa.infomanage.controller;

import org.sfa.infomanage.bean.Education;
import org.sfa.infomanage.bean.User;
import org.sfa.infomanage.service.EducationService;
import org.sfa.infomanage.service.EmployeeService;
import org.sfa.infomanage.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public String getAllEducations(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user == null){
            model.addAttribute("msg", "请重试！");
            return "education";
        }
        if(user.getRole().equals("admin")){
            List<Education> educations = educationService.getAllEducations();
            model.addAttribute("admin", request.getSession().getAttribute("user"));
            model.addAttribute("educations", educations);
            model.addAttribute("converter", converter);
            return "education";
        } else {
            List<Education> educationByCondition = educationService.getEducationByCondition(new Education(user.getEmployeeId(), "", "", null, "", ""));
            model.addAttribute("educations", educationByCondition);
            model.addAttribute("converter", converter);
            return "education";
        }
    }
    //TODO：以及对学历的修改和添加

    @RequestMapping("/education/getByCondition")
    public String getEducationByCondition(Model model,Education education,HttpServletRequest request){
        Object o = check(request);
        if(o != null){
            model.addAttribute("admin", o);
        }
        List<Education> educationByCondition = educationService.getEducationByCondition(education);
        model.addAttribute("educations", educationByCondition);
        model.addAttribute("converter", converter);
        return "education";
    }

    @RequestMapping("/education/getByBack")
    public String getEducationByBack(@RequestParam("eduBackground") String eduBackground,Model model,HttpServletRequest request){
        Object o = check(request);
        if(o != null){
            model.addAttribute("admin", o);
        }
        Education education = new Education("", eduBackground, "", null, "", "");
        List<Education> educationByCondition = educationService.getEducationByCondition(education);
        model.addAttribute("educations", educationByCondition);
        model.addAttribute("converter", converter);
        return "education";
    }

    @RequestMapping("/education/delete")
    public String deleteEducationById(@RequestParam("id") String employeeId,Model model,HttpServletRequest request){
        Object o = check(request);
        if(o != null){
            model.addAttribute("admin", o);
        }
        educationService.deleteEducationById(employeeId);
        model.addAttribute("msg", "删除成功！");
        return "education";
    }

    @RequestMapping("/education/add")
    public String addEducation(Education education,HttpServletRequest request,Model model){
        Object o = check(request);
        if(o != null){
            model.addAttribute("admin", o);
        }
        educationService.addEducation(education);
        return "redirect:/getEducations";
    }

    @RequestMapping("/education")
    @ResponseBody
    public Education getById(@RequestParam("id") String id){
        List<Education> educationByCondition = educationService.getEducationByCondition(new Education(id, "", "", null, "", ""));
        return educationByCondition.get(0);
    }

    @RequestMapping("/education/update")
    public String updateEducation(Education education,HttpServletRequest request,Model model){
        if(check(request) != null){
            model.addAttribute("admin", new Object());
        }
        educationService.updateEducation(education);
        return "redirect:/getEducations";
    }

    private Object check(HttpServletRequest request){
        return request.getSession().getAttribute("user");
    }
}
