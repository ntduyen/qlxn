package com.qlxn.testtype.client;

import com.qlxn.testtype.model.StandardTest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "standardtest", url = "${application.config.standardtest-url}")
public interface StandardTestClient {
    @GetMapping("/testType/{testTypeID}")
    List<StandardTest> findAllStandardTestByTestType(@PathVariable("testTypeID") Integer testTypeID);

}
