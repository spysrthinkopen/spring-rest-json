package com.spysr.demo.rest.controller;
/*@Author spysr
 * 
 * 
 * */ 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spysr.demo.model.EmployeeListVO;
import com.spysr.demo.model.EmployeeVO;

 
@RestController
public class EmployeeController 
{
    @RequestMapping(value = "/employees" ,headers ={"Accept=application/json,application/xml"},produces={"application/json", "application/xml"})
    public @ResponseBody EmployeeListVO getAllEmployees() 
    {
        EmployeeListVO employees = new EmployeeListVO();
        
        employees.getEmployees().add(new EmployeeVO(1,"Ram","Hello","yogeshthescorpian@gmail.com"));
        employees.getEmployees().add(new EmployeeVO(1,"Shyam","Hello","yogeshthescorpian@gmail.com"));
        employees.getEmployees().add(new EmployeeVO(1,"Veer","Hello","yogeshthescorpian@gmail.com"));
         
        return employees;
    }
     
    @RequestMapping(value = "/employees/{id}",headers ={"Accept=application/json,application/xml"},produces={"application/json", "application/xml"})
    @ResponseBody
    public ResponseEntity<EmployeeVO> getEmployeeById (@PathVariable("id") int id) 
    {
        if (id <= 3) {
            EmployeeVO employee = new EmployeeVO(1,"yogesh","shar","yogeshthescorpian@gmail.com");
            return new ResponseEntity<EmployeeVO>(employee, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}