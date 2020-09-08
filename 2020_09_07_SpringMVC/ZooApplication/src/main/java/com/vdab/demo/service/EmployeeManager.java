package com.vdab.demo.service;

import java.util.List;

import com.vdab.demo.model.EmployeeVO;

public interface EmployeeManager
{
    public List<EmployeeVO> getAllEmployees();

    void addEmployee(EmployeeVO employee);

}