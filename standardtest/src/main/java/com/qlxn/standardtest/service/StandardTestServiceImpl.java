package com.qlxn.standardtest.service;

import com.qlxn.standardtest.model.StandardTest;
import com.qlxn.standardtest.reponsitories.StandardTestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StandardTestServiceImpl implements StandardTestService{
    StandardTestRepository standardTestRepository;

    public StandardTestServiceImpl(StandardTestRepository standardTestRepository) {
        this.standardTestRepository = standardTestRepository;
    }

    @Override
    public String insertStandardTest(StandardTest standardTest) {
        standardTestRepository.save(standardTest);
        return "Success";
    }

    @Override
    public String updateStandardTest(StandardTest standardTest) {
        standardTestRepository.save(standardTest);
        return "Success";
    }

    @Override
    public String deleteStandardTest(Integer standardTestID) {
        StandardTest standardTest = standardTestRepository.getById(standardTestID);
        if (standardTest != null){
            standardTestRepository.delete(standardTest);
        }
        return "Success";
    }

    @Override
    public StandardTest getStandardTest(Integer standardTestID) {
        return standardTestRepository.findById(standardTestID).get();
    }

    @Override
    public List<StandardTest> getAllStandardTest() {
        return standardTestRepository.findAll();
    }

    @Override
    public List<StandardTest> findAllStandardTestByTestTypeID(Integer testTypeID) {

        return standardTestRepository.findAllByTestTypeID(testTypeID);
    }
}
