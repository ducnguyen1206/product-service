package com.dav.customerflow.config;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing(auditorAwareRef="auditorProvider")
public class PersistenceConfig {
}
