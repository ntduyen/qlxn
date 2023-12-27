package com.qlxn.testtype.service;

import com.qlxn.testtype.model.FullTestTypeResponse;
import com.qlxn.testtype.model.TestType;

import java.util.List;
public interface TestTypeService {
    public String insertTestType(TestType testType);
    public String updateTestType(TestType testType);
    public String deleteTestType(Integer tesTypeID);
    public TestType getTestType(Integer testTypeID);
    public List<TestType> getAllTestType();

    FullTestTypeResponse findTestTypeWithStandardTest(Integer testTypeID);
}
