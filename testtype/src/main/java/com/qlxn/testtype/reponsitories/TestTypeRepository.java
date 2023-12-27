package com.qlxn.testtype.reponsitories;

import com.qlxn.testtype.model.TestType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestTypeRepository extends JpaRepository<TestType, Integer> {
}
