package com.example;

import java.util.ArrayList;

import hu.szit.resclient.ResClient;
import hu.szit.resclient.ResConvert;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EmployeeSource {
    String url = "http://[::1]:8000/employees";
    public ObservableList<Employee> getEmployees() {
        ResClient client = new ResClient();        
        String res = client.get(url);        
        ArrayList<Employee> emps = ResConvert.toListObject(res, Employee.class);
        ObservableList<Employee> empList = FXCollections.observableArrayList(emps);

        return empList;
    }

    public String addEmployee(Employee emp) {
        String json = ResConvert.toJson(emp);
        ResClient client = new ResClient();
        String res = client.post(url, json);
        return res;
    }
}
