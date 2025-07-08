package com.launchdarkly.Controller;

import com.launchdarkly.common.FlagProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TestController {
    @Autowired
    public FlagProvider flagProvider;

    String TEST_FLAG = "test-flag";

    @GetMapping("/check-flagValue")
    public Boolean checkFlagValue(
            @RequestParam(value = "country", required = false) String country,
            @RequestParam(value = "flagName") String flagName
    ) {
        Boolean featureEnable;
        if (country != null) {
            featureEnable = flagProvider.isFeatureEnable(flagName, country);
        } else {
            featureEnable = flagProvider.isFeatureEnable(flagName);
        }
        return featureEnable;
    }
}
