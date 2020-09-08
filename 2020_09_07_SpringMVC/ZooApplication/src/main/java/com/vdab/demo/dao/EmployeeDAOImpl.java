package com.vdab.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.vdab.demo.model.EmployeeVO;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private List<EmployeeVO> m_Employees = new ArrayList<>();

    EmployeeDAOImpl(){

        EmployeeVO vo1 = new EmployeeVO();
        vo1.setId(1);
        vo1.setFirstName("Lokesh");
        vo1.setLastName("Gupta");
        m_Employees.add(vo1);

        EmployeeVO vo2 = new EmployeeVO();
        vo2.setId(2);
        vo2.setFirstName("Raj");
        vo2.setLastName("Kishore");
        m_Employees.add(vo2);
    }


    public List<EmployeeVO> getAllEmployees()
    {
        return m_Employees;
    }

    public void addEmployee(EmployeeVO employee){
        m_Employees.add(employee);
    }

}

