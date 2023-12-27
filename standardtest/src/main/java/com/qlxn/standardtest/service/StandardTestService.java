package com.qlxn.standardtest.service;

import com.qlxn.standardtest.model.StandardTest;

import java.util.List;

public interface StandardTestService {
    public String insertStandardTest(StandardTest standardTest);
    public String updateStandardTest(StandardTest standardTest);
    public String deleteStandardTest(Integer standardTestID);
    public StandardTest getStandardTest(Integer standardTestID);
    public List<StandardTest> getAllStandardTest();

    public List <StandardTest>findAllStandardTestByTestTypeID(Integer testTypeID);
}
