# Choose Build Tool

## Status

accepted

## Context

We are building a new project that involves developing applications using Vue.js and Spring Boot technologies. 
A build management system to efficiently manage the build process for the project has to be identified.

## Decision

Regardless of whether it's a Vue.js frontend application or a Spring Boot backend application,
both can be built independently or combined, depending on the directory where Maven commands are executed. 
This enables us to utilize a single build management system and simplifies the build process.

## Consequences

The building process for frontend and backend can be easily managed.
As Maven may not be familiar to all team members, some may need to learn and develop competence in using it.