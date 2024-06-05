package com.teaching.teaching.controllers;

import com.teaching.teaching.dal.DataAccessLayer;
import com.teaching.teaching.models.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@Slf4j
@RequestMapping("/authorized")
public class SecuredController {
    private final DataAccessLayer dataAccessLayer;
    @Autowired
    public SecuredController(DataAccessLayer dataAccessLayer) {
        this.dataAccessLayer = dataAccessLayer;
    }

    @PostMapping("/new/material")
    public ResponseEntity<String> newMaterial(@RequestBody Material material) {
        try {
            dataAccessLayer.createMaterial(material);
            return ResponseEntity.ok("Material added successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add material: " + e.getMessage());
        }
    }
    @DeleteMapping("/delete/material/{id}")
    public ResponseEntity deleteMaterialById(@PathVariable("id") long id){
        dataAccessLayer.deleteMaterialById(id);
        return ResponseEntity.ok("Material deleted successfully!");
    }
    @PutMapping("/update/material/{id}")
    public ResponseEntity updateMaterialById(@PathVariable("id") long id, @RequestBody Material updatedMaterial){
        dataAccessLayer.updateMaterialById(id, updatedMaterial);
        return ResponseEntity.ok("Material updated successfully!");
    }




    @PostMapping("/new/bill")
    public ResponseEntity<String> newBill(@RequestBody Bill bill) {
        try {
            dataAccessLayer.createBill(bill);
            return ResponseEntity.ok("Bill added successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add bill: " + e.getMessage());
        }
    }
    @DeleteMapping("/delete/bill/{id}")
    public ResponseEntity deleteBillById(@PathVariable("id") long id){
        dataAccessLayer.deleteBillById(id);
        return ResponseEntity.ok("Bill deleted successfully!");
    }
    @PutMapping("/update/bill/{id}")
    public ResponseEntity updateBillById(@PathVariable("id") long id, @RequestBody Bill updatedBill){
        dataAccessLayer.updateBillById(id, updatedBill);
        return ResponseEntity.ok("Bill updated successfully!");
    }










    @PostMapping("/new/employee")
    public ResponseEntity<String> newEmployee(@RequestBody Employee employee) {
        try {
            dataAccessLayer.createEmployee(employee);
            return ResponseEntity.ok("Employee added successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add employee: " + e.getMessage());
        }
    }
    @DeleteMapping("/delete/employee/{id}")
    public ResponseEntity deleteEmployeeById(@PathVariable("id") long id){
        dataAccessLayer.deleteEmployeeById(id);
        return ResponseEntity.ok("Employee deleted successfully!");
    }
    @PutMapping("/update/employee/{id}")
    public ResponseEntity updateEmployeeById(@PathVariable("id") long id, @RequestBody Employee updatedEmployee){
        dataAccessLayer.updateEmployeeById(id, updatedEmployee);
        return ResponseEntity.ok("Employee updated successfully!");
    }



    @PostMapping("/new/employeeCategory")
    public ResponseEntity<String> newEmployeeCategory(@RequestBody EmployeeCategory employeeCategory) {
        try {
            dataAccessLayer.createEmployeeCategory(employeeCategory);
            return ResponseEntity.ok("Employee category added successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add employee category: " + e.getMessage());
        }
    }
    @DeleteMapping("/delete/employeeCategory/{id}")
    public ResponseEntity deleteEmployeeCategoryById(@PathVariable("id") long id){
        dataAccessLayer.deleteEmployeeCategoryById(id);
        return ResponseEntity.ok("Employee category deleted successfully!");
    }
    @PutMapping("/update/employeeCategory/{id}")
    public ResponseEntity updateEmployeeCategoryById(@PathVariable("id") long id, @RequestBody EmployeeCategory updatedEmployeeCategory){
        dataAccessLayer.updateEmployeeCategoryById(id, updatedEmployeeCategory);
        return ResponseEntity.ok("Employee category updated successfully!");
    }




    @PostMapping("/new/knowledgeLevel")
    public ResponseEntity<String> newKnowledgeLevel(@RequestBody KnowledgeLevel knowledgeLevel) {
        try {
            dataAccessLayer.createKnowledgeLevel(knowledgeLevel);
            return ResponseEntity.ok("Knowledge level added successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add knowledge level: " + e.getMessage());
        }
    }
    @DeleteMapping("/delete/knowledgeLevel/{id}")
    public ResponseEntity deleteKnowledgeLevelById(@PathVariable("id") long id){
        dataAccessLayer.deleteKnowledgeLevelById(id);
        return ResponseEntity.ok("Knowledge level deleted successfully!");
    }
    @PutMapping("/update/knowledgeLevel/{id}")
    public ResponseEntity updateKnowledgelevelById(@PathVariable("id") long id, @RequestBody KnowledgeLevel updatedKnowledgeLevel){
        dataAccessLayer.updateKnowledgeLevelById(id, updatedKnowledgeLevel);
        return ResponseEntity.ok("Knowledge level updated successfully!");
    }




    @PostMapping("/new/language")
    public ResponseEntity<String> newlanguage(@RequestBody Language language) {
        try {
            dataAccessLayer.createLanguage(language);
            return ResponseEntity.ok("Language added successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add language: " + e.getMessage());
        }
    }
    @DeleteMapping("/delete/language/{id}")
    public ResponseEntity deleteLanguageById(@PathVariable("id") long id){
        dataAccessLayer.deleteLanguageById(id);
        return ResponseEntity.ok("Language deleted successfully!");
    }
    @PutMapping("/update/language/{id}")
    public ResponseEntity updateLanguageById(@PathVariable("id") long id, @RequestBody Language updatedLanguage){
        dataAccessLayer.updateLanguageById(id, updatedLanguage);
        return ResponseEntity.ok("Language updated successfully!");
    }



    @PostMapping("/create/user")
    public ResponseEntity addUser(@RequestBody User user) {

        dataAccessLayer.newUserToDatabase(user);
        return ResponseEntity.ok("");

    }

    @DeleteMapping("delete/user/{id}")
    public ResponseEntity deleteUserById(@PathVariable("id") long id) {
        dataAccessLayer.delUserById(id);
        return ResponseEntity.ok("");
    }

    @PutMapping("/update/user/{id}")
    public ResponseEntity updateUserById(@PathVariable("id") long id, @RequestBody User user) {
        dataAccessLayer.updateUser(id, user);
        return ResponseEntity.ok("");
    }
}
