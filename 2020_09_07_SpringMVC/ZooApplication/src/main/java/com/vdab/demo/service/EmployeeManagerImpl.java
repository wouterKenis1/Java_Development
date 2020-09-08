package com.vdab.demo.service;

import java.util.List;

import com.vdab.demo.dao.EmployeeDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vdab.demo.dao.EmployeeDAO;
import com.vdab.demo.model.EmployeeVO;

@Service
public class EmployeeManagerImpl implements EmployeeManager {

    @Autowired
    EmployeeDAO dao;

    public List<EmployeeVO> getAllEmployees()
    {
        return dao.getAllEmployees();
    }

    @Override
    public void addEmployee(EmployeeVO employee) {
        dao.addEmployee(employee);
    }
}