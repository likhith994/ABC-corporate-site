package com.example.corparatewebsite.service;

import com.example.corparatewebsite.model.ServiceModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {

    public List<ServiceModel> getServices() {

        List<ServiceModel> services = new ArrayList<>();

        services.add(new ServiceModel(
                "Cloud Integration",
                "Integrating enterprise applications securely with leading cloud platforms."
        ));

        services.add(new ServiceModel(
                "DevOps Consulting",
                "Automating software delivery pipelines using CI/CD practices."
        ));

        services.add(new ServiceModel(
                "Containerization",
                "Deploying scalable Docker containers managed by Kubernetes."
        ));

        services.add(new ServiceModel(
                "Infrastructure Automation",
                "Provisioning infrastructure using Infrastructure as Code."
        ));

        services.add(new ServiceModel(
                "Monitoring",
                "Continuous monitoring using Nagios, Grafana and Graphite."
        ));

        return services;
    }

}