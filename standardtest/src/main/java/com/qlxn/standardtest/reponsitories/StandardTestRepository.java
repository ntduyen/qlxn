package com.qlxn.standardtest.reponsitories;

import com.qlxn.standardtest.model.StandardTest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StandardTestRepository extends JpaRepository<StandardTest, Integer> {
    List<StandardTest> findAllByTestTypeID(Integer testTypeID);
}
