package org.acme.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.acme.service.OwnersService;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

@Readiness
@ApplicationScoped
public class OwnersHealthCheck implements HealthCheck {

    @Inject
    OwnersService ownersService;

    @Override
    public HealthCheckResponse call() {

        if (ownersService.findAll() != null) {
            return HealthCheckResponse.named("Success of Owners Health Check!!!").up().build();
        } else {
            return HealthCheckResponse.named("Failure of Owners Health Check!!!").down().build();
        }
    }
}