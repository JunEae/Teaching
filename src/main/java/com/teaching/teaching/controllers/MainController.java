package com.teaching.teaching.controllers;

import com.teaching.teaching.dal.DataAccessLayer;
import com.teaching.teaching.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/unauthorized")
public class MainController {
    private final DataAccessLayer dataAccessLayer;
    @Autowired
    public MainController(DataAccessLayer dataAccessLayer) {
        this.dataAccessLayer = dataAccessLayer;
    }


    @GetMapping("/get/material/{id}")
    public ResponseEntity getMaterialById(@PathVariable("id") long id){
        return ResponseEntity.ok(dataAccessLayer.getMaterialById(id));
    }
    @GetMapping("get/materials")
    public ResponseEntity getMaterials(){
        return ResponseEntity.ok(dataAccessLayer.getMaterials());
    }
    @GetMapping("/materialsByLanguageId")
    public List<Material> getMaterialByLanguageId(@RequestParam Long id) {
        return dataAccessLayer.getMaterialByLanguageId(id);
    }
    @GetMapping("/materialsByKnowledgeLevelId")
    public List<Material> getMaterialByKnowledgeLevelId(@RequestParam Long id) {
        return dataAccessLayer.getMaterialByKnowledgeLevelId(id);
    }




    @GetMapping("/get/bill/{id}")
    public ResponseEntity getBillById(@PathVariable("id") long id){
        return ResponseEntity.ok(dataAccessLayer.getBillById(id));
    }
    @GetMapping("get/bills")
    public ResponseEntity getBills(){
        return ResponseEntity.ok(dataAccessLayer.getBills());
    }
    @GetMapping("/billsByEmployeeId")
    public List<Bill> getBillByEmployeeId(@RequestParam Long id) {
        return dataAccessLayer.getBillByEmployeeId(id);
    }
    @GetMapping("/billsByCustomerId")
    public List<Bill> getBillByCustomerId(@RequestParam Long id) {
        return dataAccessLayer.getBillByCustomerId(id);
    }
    @GetMapping("/billsByMaterialId")
    public List<Bill> getBillByMaterialId(@RequestParam Long id) {
        return dataAccessLayer.getBillByMaterialId(id);
    }









    @GetMapping("/get/employee/{id}")
    public ResponseEntity getEmployeeById(@PathVariable("id") long id){
        return ResponseEntity.ok(dataAccessLayer.getEmployeeById(id));
    }
    @GetMapping("get/employees")
    public ResponseEntity getEmployees(){
        return ResponseEntity.ok(dataAccessLayer.getEmployees());
    }




    @GetMapping("/get/employeeCategory/{id}")
    public ResponseEntity getEmployeeCategoryById(@PathVariable("id") long id){
        return ResponseEntity.ok(dataAccessLayer.getEmployeeCategoryById(id));
    }
    @GetMapping("get/employeeCategories")
    public ResponseEntity getEmployeeCategories(){
        return ResponseEntity.ok(dataAccessLayer.getEmployeeCategories());
    }




    @GetMapping("/get/knowledgeLevel/{id}")
    public ResponseEntity getKnowledgeLevelById(@PathVariable("id") long id){
        return ResponseEntity.ok(dataAccessLayer.getKnowledgeLevelById(id));
    }
    @GetMapping("get/knowledgeLevels")
    public ResponseEntity getKnowledgeLevels(){
        return ResponseEntity.ok(dataAccessLayer.getKnowledgeLevels());
    }




    @GetMapping("/get/language/{id}")
    public ResponseEntity getLanguageById(@PathVariable("id") long id){
        return ResponseEntity.ok(dataAccessLayer.getLanguageById(id));
    }
    @GetMapping("get/languages")
    public ResponseEntity getLanguages(){
        return ResponseEntity.ok(dataAccessLayer.getLanguages());
    }




    @GetMapping("get/users")
    public ResponseEntity getUsers(){
        return ResponseEntity.ok(dataAccessLayer.getUsers());
    }
}




