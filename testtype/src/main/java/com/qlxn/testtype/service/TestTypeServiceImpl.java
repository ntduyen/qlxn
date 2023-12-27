package com.qlxn.testtype.service;

import com.qlxn.testtype.client.StandardTestClient;
import com.qlxn.testtype.model.FullTestTypeResponse;
import com.qlxn.testtype.model.TestType;
import com.qlxn.testtype.reponsitories.TestTypeRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@ComponentScan(basePackages = "com.qlxn.testtype.service")
public class TestTypeServiceImpl implements TestTypeService {
    TestTypeRepository testTypeRepository;
    StandardTestClient standardTestClient;

    public TestTypeServiceImpl(TestTypeRepository testTypeRepository, StandardTestClient standardTestClient) {


        this.testTypeRepository = testTypeRepository;
        this.standardTestClient = standardTestClient;
    }



    @Override
    public String insertTestType(TestType testType) {
        testTypeRepository.save(testType);
        return "Success";
    }

    @Override
    public String updateTestType(TestType testType) {
        testTypeRepository.save(testType);
        return "Success";
    }

    @Override
    public String deleteTestType(Integer tesTypeID) {
        TestType testType = testTypeRepository.getById(tesTypeID);
        if (testType != null){
            testTypeRepository.delete(testType);
        }
        return "Success";
    }

    @Override
    public TestType getTestType(Integer testTypeID) {

        return testTypeRepository.findById(testTypeID).get();
    }


    @Override
    public List<TestType> getAllTestType() {
        return testTypeRepository.findAll();
    }

    @Override
    public FullTestTypeResponse findTestTypeWithStandardTest(Integer testTypeID) {
        var testType = testTypeRepository.findById(testTypeID)
                .orElse(TestType.builder()
                        .testTypeName("NOT_FOUND")
                        .description("NOT_FOUND")
                        .build()
                );
        var standardTest = standardTestClient.findAllStandardTestByTestType(testTypeID); //find all the standard test from standardtest microservice
        return FullTestTypeResponse.builder()
                .testTypeName(testType.getTestTypeName())
                .description(testType.getDescription())
                .standardTest(standardTest).build();
    }
}
