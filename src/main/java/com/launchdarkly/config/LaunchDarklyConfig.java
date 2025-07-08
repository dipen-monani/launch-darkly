package com.launchdarkly.config;

import com.launchdarkly.common.FlagProvider;
import com.launchdarkly.sdk.server.LDClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LaunchDarklyConfig {
    @Value("${LAUNCH_DARKLY_SDK_KEY}")
    String sdkKey;

    @Bean
    public LDClient sdkLDClient() {
         return new LDClient(sdkKey);
    }

    @Bean
    public FlagProvider flagProvider(LDClient ldClient){
        return new FlagProvider(ldClient);
    }
}
