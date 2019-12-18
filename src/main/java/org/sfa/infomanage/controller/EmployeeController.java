package org.sfa.infomanage.controller;

import org.sfa.infomanage.bean.Employee;
import org.sfa.infomanage.bean.User;
import org.sfa.infomanage.bean.WorkTime;
import org.sfa.infomanage.service.DepartmentService;
import org.sfa.infomanage.service.EmployeeService;
import org.sfa.infomanage.service.MarriageService;
import org.sfa.infomanage.service.PostService;
import org.sfa.infomanage.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private PostService postService;

    @Autowired
    private MarriageService marriageService;

    @Autowired
    private Converter converter;

    @RequestMapping("/getEmployees")
    public String getEmployees(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user == null){
            model.addAttribute("msg", "请重试！");
            return "employee";
        }
        if(user.getRole().equals("admin")){
            List<Employee> employees = employeeService.getEmployees();
            model.addAttribute("employees", employees);
            model.addAttribute("converter", converter);
            model.addAttribute("depts", departmentService.getAllDepartments());
            model.addAttribute("posts", postService.getAllPosts());
            model.addAttribute("workTimes", employeeService.getWorkTimes());
            model.addAttribute("admin", request.getSession().getAttribute("user"));
            return "employee";
        } else {
            String employeeId = user.getEmployeeId();
            Employee employeeById = employeeService.getEmployeeById(employeeId);
            List<Employee> list = new ArrayList<>();
            list.add(employeeById);
            model.addAttribute("employees", list);
            model.addAttribute("converter", converter);
            model.addAttribute("depts", departmentService.getAllDepartments());
            model.addAttribute("posts", postService.getAllPosts());
            model.addAttribute("workTimes", employeeService.getWorkTimes());
            return "employee";
        }
    }

    @RequestMapping("/employee/add")
    public String addEmployee(Model model, Employee employee,@RequestParam("isMarried") boolean isMarried,HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user == null){
            model.addAttribute("msg", "请重试！");
            return "employee";
        }
        if(user.getRole().equals("admin")){
            employee.setMarried(isMarried);
            employeeService.addEmployee(employee);
            model.addAttribute("msg", "添加成功！");
            model.addAttribute("admin", request.getSession().getAttribute("user"));
            return "employee";
        }else {
            model.addAttribute("msg", "请重试！");
            return "employee";
        }
    }

    @RequestMapping("/employee/delete")
    public String deleteEmployeeById(@RequestParam("id") String employeeId,Model model,HttpServletRequest request){
        check(request, model);
        employeeService.deleteEmployeeById(employeeId);
        model.addAttribute("msg", "添加成功！");
        return "redirect:/getEmployees";
    }

    @RequestMapping("/employee/update")
    public String updateEmployee(Employee employee,Model model,HttpServletRequest request){
        check(request, model);
        employeeService.updateEmployeeById(employee);
        return "redirect:/getEmployees";
    }

    @RequestMapping("/employee")
    @ResponseBody
    public Employee getEmployeeById(@RequestParam("id") String employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

    @RequestMapping("/employee/get")
    public String getEmployeeByCondition(Employee employee,Model model,HttpServletRequest request){
        check(request, model);
        if(employee.getEmployeeId().equals("")){
            employee.setEmployeeId(null);
        }
        if(employee.getEmployeeName().equals("")){
            employee.setEmployeeName(null);
        }
        if(employee.getTitle().equals("")){
            employee.setTitle(null);
        }
        List<Employee> employees = employeeService.getEmployeeByCondition(employee);
        model.addAttribute("employees", employees);
        model.addAttribute("converter", converter);
        model.addAttribute("depts", departmentService.getAllDepartments());
        model.addAttribute("posts", postService.getAllPosts());
        return "employee";
    }

    @RequestMapping("/employee/getByMarriage")
    public String getEmployeeByMarriage(Model model,@RequestParam("isMarried") boolean isMarried,HttpServletRequest request){
        check(request, model);
        Employee employee = new Employee();
        employee.setMarried(isMarried);
        List<Employee> employees = employeeService.getEmployeeByCondition(employee);
        model.addAttribute("employees", employees);
        model.addAttribute("converter", converter);
        model.addAttribute("depts", departmentService.getAllDepartments());
        model.addAttribute("posts", postService.getAllPosts());
        return "employee";
    }

    @RequestMapping("/employee/getByDept")
    public String getEmployeeByDept(Model model,@RequestParam("deptNumber")String deptNumber, HttpServletRequest request){
        check(request, model);
        Employee employee = new Employee();
        employee.setDeptNumber(deptNumber);
        List<Employee> employees = employeeService.getEmployeeByCondition(employee);
        model.addAttribute("employees", employees);
        model.addAttribute("converter", converter);
        model.addAttribute("depts", departmentService.getAllDepartments());
        model.addAttribute("posts", postService.getAllPosts());
        return "employee";
    }

    @RequestMapping("/employee/getByTime")
    public String getWorkTime(@RequestParam("time") int time,Model model,HttpServletRequest request){
        check(request,model);
        List<WorkTime> workTimeByTime = employeeService.getWorkTimeByTime(time);
        List<Employee> employees = employeeService.getEmployees();
        List<Employee> returnEmployees = new ArrayList<>();
        for(WorkTime workTime:workTimeByTime){
            for(Employee employee:employees){
                if(workTime.getEmployeeId().equals(employee.getEmployeeId()))
                    returnEmployees.add(employee);
            }
        }
        model.addAttribute("employees", returnEmployees);
        model.addAttribute("converter", converter);
        model.addAttribute("depts", departmentService.getAllDepartments());
        model.addAttribute("posts", postService.getAllPosts());
        return "employee";
    }

    private void check(HttpServletRequest request,Model model){
        if(request.getSession().getAttribute("user") != null){
            model.addAttribute("admin", new Object());
        }
    }


}

