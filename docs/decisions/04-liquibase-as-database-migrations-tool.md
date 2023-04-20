# Liquibase as database migrations tool

## Status

accepted

## Context

Find a system that simplifies the management and deployment of database changes.

## Decision

Liquibase is used to store our database schemas in a VCS and executes those against our Database on application start up.
It helps us (re)deploying our Database reliably, while simultaneously keeping its state away from our application runtime/code.
It helps us to manage changes database schema and data in a version-controlled manner.

## Consequences

We need to learn syntax and conventions of liquibase.
Changesets need to be managed properly, otherwise it is possible to end up with different schema versions on different
working states / branches. 
Also version control conflicts can happen, if multiple developers make changes to the same changesets simultaneously. 