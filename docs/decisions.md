# Project specific Decisions

## Maven based Reactor Setup

Be it a VueJS-application or a Spring Boot-Application, everything can be build separately or together depending on the directory you execute your maven commands.
This enables us to use a single build-management system in order to get everything up and running.

## API first with OpenAPI

OpenAPI v3 is used as contract between our frontend and backend.
We are leveraging OpenAPI Generator in order to generate client-, server- and model-classes.
This enables us to have a single definition for our Request- and Response-models.
- [kotlin-spring](https://openapi-generator.tech/docs/generators/kotlin-spring)

## Database Migrations using Liquibase

Liquibase is used to store our database schemas in a VCS and executes those against our Database on application starts up.
It helps us (re)deploying our Database reliably, while simultaneously keeping its state away from our application runtime/code.