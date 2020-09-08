package com.vdab.demo.dao;

import java.util.List;

import com.vdab.demo.model.EmployeeVO;

public interface EmployeeDAO
{
    public List<EmployeeVO> getAllEmployees();
    public void addEmployee(EmployeeVO employee);
}