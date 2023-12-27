package com.qlxn.testtype.controller;

import com.qlxn.testtype.model.FullTestTypeResponse;
import com.qlxn.testtype.model.ResponeObject;
import com.qlxn.testtype.model.TestType;
import com.qlxn.testtype.service.TestTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/TestType")
//localhost:8082
public class TestTypeController {
    @Autowired
    TestTypeService testTypeService;

    public TestTypeController(TestTypeService testTypeService) {
        this.testTypeService = testTypeService;
    }
    @GetMapping("")
    List<TestType> getAllTestType(){
        return testTypeService.getAllTestType();
    }
    @GetMapping("/{testTypeID}")
    ResponseEntity<ResponeObject> findById(@PathVariable("testTypeID") Integer testTypeID){
        TestType foundTestType = testTypeService.getTestType(testTypeID);
        if (foundTestType != null){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("OK", "Query test type successfully", foundTestType)
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("Failed", "Cannot find test type with id = " + testTypeID, "")
            );
        }
    }
    @PostMapping("/{insert}")
    ResponseEntity<ResponeObject> insertTestType(@RequestBody TestType newTestType){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("OK", "Insert test type successfully", testTypeService.insertTestType(newTestType))
        );
    }

    @PutMapping("/{testTypeID}")
    ResponseEntity<ResponeObject> updateTestType (@RequestBody TestType newTestType, @PathVariable Integer testTypeID){
        TestType optinalTestType = testTypeService.getTestType(testTypeID);
        if(optinalTestType != null){
            optinalTestType.setTestTypeName(newTestType.getTestTypeName());
            optinalTestType.setDescription(newTestType.getDescription());

            String updateTestType = testTypeService.updateTestType(optinalTestType);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("OK", "Update test type successfully", updateTestType)
            );
        }else {
            newTestType.setTestTypeID(testTypeID);
            String updateNewTestType = testTypeService.updateTestType(newTestType);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("OK", "Test type not found. Created new test type with ID: " + testTypeID, updateNewTestType)

            );
        }
    }
    @DeleteMapping("/{testTypeID}")
    ResponseEntity<ResponeObject> deleteTestType (@PathVariable Integer testTypeID){
        String testType = testTypeService.deleteTestType(testTypeID);
        if (testType != null){
            testTypeService.deleteTestType(testTypeID);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("OK", "Delete test type successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponeObject("Failed", "Cannot find test type to delete", "")
        );
    }

    @GetMapping("/with-standardTest/{testTypeID}")
    public ResponseEntity<FullTestTypeResponse> findAllTestType(@PathVariable ("testTypeID") Integer testTypeID){
        return ResponseEntity.ok(testTypeService.findTestTypeWithStandardTest(testTypeID));
    }
}
