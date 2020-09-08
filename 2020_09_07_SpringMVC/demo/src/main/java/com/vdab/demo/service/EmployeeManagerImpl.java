package com.vdab.demo.service;


import com.vdab.demo.dao.EmployeeDAO;
import com.vdab.demo.model.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeManagerImpl  implements EmployeeManager{

    @Autowired
    EmployeeDAO dao;

    public List<EmployeeVO> getAllEmployees(){
        return dao.getAllEmployees();
    }
}
