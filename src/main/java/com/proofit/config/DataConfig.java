package com.proofit.config;

import com.proofit.policy.calculator.PremiumCalculator;
import com.proofit.policy.premium.PremiumPolicy;
import com.proofit.policy.premium.impl.PremiumPolicyImpl;
import com.proofit.policy.validation.PolicyValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfig {
    @Bean
    public PremiumPolicy specialPremium() {
        return new PremiumPolicyImpl();
    }
    @Bean
    public PolicyValidator policyValidator() {
        return new PolicyValidator();
    }
    @Bean
    public PremiumCalculator premiumCalculator() {
        return new PremiumCalculator();
    }
}
