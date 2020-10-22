package wanglu.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wanglu.springboot.dao.DepartmentDao;
import wanglu.springboot.dao.EmployeeDao;
import wanglu.springboot.entities.Department;
import wanglu.springboot.entities.Employee;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();

        model.addAttribute("emps", employees);
        return "emp/list";
    }
    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //查出所有的部门在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    //员工添加功能
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    //来到修改页面，查出当前员工在页面回显
    @GetMapping("/emp/{id}")
    public  String toEditPage(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);
        //显示所有部门列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        //回到修改页面
        return "emp/add";
    }

    //员工修改
    @PutMapping("/emp")
    public String updateEmployee(Employee employee) {
        employeeDao.save(employee);
//        System.out.println(employee);
        return "redirect:/emps";
    }

    //员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
