package com.qlxn.standardtest.controller;

import com.qlxn.standardtest.model.ResponeObject;
import com.qlxn.standardtest.model.StandardTest;
import com.qlxn.standardtest.service.StandardTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/StandardTest")
//localhost:8070
public class StandardTestController {
    @Autowired
    StandardTestService standardTestService;

    public StandardTestController(StandardTestService standardTestService) {
        this.standardTestService = standardTestService;
    }
    @GetMapping("")
    List<StandardTest> getAllStandardTest(){
        return standardTestService.getAllStandardTest();
    }
    @GetMapping("/{standardTestID}")
    ResponseEntity<ResponeObject> findById(@PathVariable("standardTestID") Integer standardTestID){
        StandardTest foundStandardTest = standardTestService.getStandardTest(standardTestID);
        if (foundStandardTest != null){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("OK", "Query standard test successfully", foundStandardTest)
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("Failed", "Cannot find standard test with id = " + standardTestID, "")
            );
        }
    }
    @PostMapping("/{insert}")
    ResponseEntity<ResponeObject> insertStandardTest(@RequestBody StandardTest newStandardTest){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("OK", "Insert standard test successfully", standardTestService.insertStandardTest(newStandardTest))
        );
    }
    @PutMapping("/{standardTestID}")
    ResponseEntity<ResponeObject> updateStandardTest (@RequestBody StandardTest newStandardTest, @PathVariable Integer standardTestID){
        StandardTest optinalStandardTest = standardTestService.getStandardTest(standardTestID);
        if(optinalStandardTest != null){
            optinalStandardTest.setStandardTestName(newStandardTest.getStandardTestName());
            optinalStandardTest.setDescription(newStandardTest.getDescription());
            optinalStandardTest.setTestTypeID(newStandardTest.getTestTypeID());

            String updateStandardTest = standardTestService.updateStandardTest(optinalStandardTest);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("OK", "Update standard test successfully ", updateStandardTest)
            );
        }else {
            newStandardTest.setStandardTestID(standardTestID);
            String updateNewStandardTest = standardTestService.updateStandardTest(newStandardTest);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("OK", "Standard not found. Created new standard test with ID: " + standardTestID, updateNewStandardTest)

            );
        }
    }
    @DeleteMapping("/{standardTestID}")
    ResponseEntity<ResponeObject> deleteStandardTest (@PathVariable Integer standardTestID){
        String standardTest = standardTestService.deleteStandardTest(standardTestID);
        if (standardTest != null){
            standardTestService.deleteStandardTest(standardTestID);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("OK", "Delete standard test successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponeObject("Failed", "Cannot find standard test to delete", "")
        );
    }
    @GetMapping("/testType/{testTypeID}")
    public ResponseEntity<List<StandardTest>> findAllStandardTest(@PathVariable("testTypeID") Integer testTypeID){
        return ResponseEntity.ok(standardTestService.findAllStandardTestByTestTypeID(testTypeID));
    }
}
