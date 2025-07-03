package com.ct.demo.configuration;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.defaultconfig.ApiRootBuilder;
import com.commercetools.api.defaultconfig.ServiceRegion;
import io.vrap.rmf.base.client.oauth2.ClientCredentials;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class CommercetoolsClientConfig {

    @Value("${commercetools.client-id}")
    private String clientId;

    @Value("${commercetools.client-secret}")
    private String clientSecret;

    @Value("${commercetools.project-key}")
    private String projectKey;

    @Bean
    public ProjectApiRoot commercetoolsClient() {
        return ApiRootBuilder.of()
                .defaultClient(ClientCredentials.of()
                                .withClientId(clientId)
                                .withClientSecret(clientSecret)
                                .build(),
                        ServiceRegion.GCP_US_CENTRAL1)
                .withPolicies(policyBuilder ->
                        policyBuilder.withRetry(retry -> retry
                                .maxRetries(3)
                                .statusCodes(
                                        Arrays.asList(
                                                503, 500
                                        )
                                )))
                .build(projectKey);
    }
}
