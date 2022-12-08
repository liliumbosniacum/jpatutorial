package com.lilium.jpatutorial.configuration;

import com.lilium.jpatutorial.repository.impl.DistributedRepositoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
        value = "com.lilium.jpatutorial.repository",
        repositoryBaseClass = DistributedRepositoryImpl.class
)
public class ApplicationConfiguration {
}
