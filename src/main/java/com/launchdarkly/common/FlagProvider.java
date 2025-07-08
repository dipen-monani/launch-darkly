package com.launchdarkly.common;

import com.launchdarkly.sdk.LDContext;
import com.launchdarkly.sdk.server.LDClient;

import java.util.Map;

public class FlagProvider {
    String USER = "user";

    LDClient ldClient;

    public FlagProvider(LDClient ldClient) {
        this.ldClient = ldClient;
    }

    public Boolean isFeatureEnable(String key) {
        LDContext ldContext = LDContext.builder(USER).build();
        return ldClient.boolVariation(key, ldContext, false);
    }

    public String isFeatureEnableAsString(String featureKey, String key) {
        LDContext ldContext = LDContext.builder(USER).build();
        return ldClient.stringVariation(featureKey, ldContext, key);
    }

    public Boolean isFeatureEnable(String featureKey, String country) {
        LDContext ldContext = LDContext.builder(USER)
                .set("country", country)
                .build();
        return ldClient.boolVariation(featureKey, ldContext, false);
    }

    public Boolean isFeatureEnable(String featureKey, String userKey, Map<String, String> customFields) {
        var builder = LDContext.builder(userKey);
        customFields.forEach(builder::set);
        LDContext ldContext = builder.build();
        return ldClient.boolVariation(featureKey, ldContext, false);
    }

}
