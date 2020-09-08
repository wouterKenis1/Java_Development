package com.vdab.demo.Controllers;

import com.vdab.demo.model.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vdab.demo.service.EmployeeManager;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employee")
public class EmployeeController
{
    @Autowired
    EmployeeManager manager;

    @RequestMapping(value = "/getAllEmployees", method = RequestMethod.GET)
//    @GetMapping(value = "/getAllEmployees")
    public String getAllEmployees(ModelMap model)
    {
        model.addAttribute("employees", manager.getAllEmployees());
        return "employeesListDisplay";
        //return new ModelAndView("employeesListDisplay",model);
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView showAddView(ModelMap modelMap)
    {
        return new ModelAndView("addEmployee", modelMap);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addEmployee(@ModelAttribute EmployeeVO employee, ModelMap model)
    {
        manager.addEmployee(employee);
        return new ModelAndView("redirect:/employee/getAllEmployees");
    }



}