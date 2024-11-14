package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class MainController {

    EmployeeSource source = new EmployeeSource();

    @FXML
    private TableColumn<Employee, Integer> idCol;

    @FXML
    private TableColumn<Employee, Double> salaryCol;

    @FXML
    private TableColumn<Employee, String> cityCol;

    @FXML
    private TableColumn<Employee, String> nameCol;

    @FXML
    private TableView<Employee> empTable;

    @FXML
    private TextField IdField;

    @FXML
    private TextField NameField;

    @FXML
    private TextField CityField;

    @FXML
    private TextField SalaryField;

    @FXML
    void AddButton(ActionEvent event) {
        System.out.println("Hozzáadás indul...");
        Employee emp = new Employee();
        emp.setName(NameField.getText());
        emp.setCity(CityField.getText());
        emp.setSalary(Double.parseDouble(SalaryField.getText()));
        source.addEmployee(emp);
        updateTable();
        imputFieldClear();
    }

    @FXML
    void ChangeButton(ActionEvent event) {
        updateTable();
        imputFieldClear();
    }

    @FXML
    void DeleteButton(ActionEvent event) {

    }


    public void updateTable() {
        empTable.getItems().clear();
        empTable.getItems().addAll(source.getEmployees());
    }

    public void initialize() {
        System.out.println("működik");
        
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        cityCol.setCellValueFactory(new PropertyValueFactory<>("city"));
        salaryCol.setCellValueFactory(new PropertyValueFactory<>("salary"));

        updateTable();

    }

    public void imputFieldClear() {
        IdField.setText("");
        NameField.setText("");
        CityField.setText("");
        SalaryField.setText("");
    }


    @FXML
    void OnClickButton(MouseEvent event) {
        if(
        event.getButton().equals(MouseButton.PRIMARY) && 
        event.getClickCount() == 2) {

            Employee emp = empTable.getSelectionModel().getSelectedItem();
            IdField.setText(emp.getId().toString());
            NameField.setText(emp.getName());
            CityField.setText(emp.getCity());
            SalaryField.setText(emp.getSalary().toString());
        }
    }

}
