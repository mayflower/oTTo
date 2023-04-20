# choose generator tool for client-, server- and model-classes

## Status

accepted

## Context

A tool for generating client-, server- and model-classes needs to be chosen.

## Decision

OpenAPI v3 is used as contract between our frontend and backend.
We are leveraging OpenAPI Generator in order to generate client-, server- and model-classes.
This enables us to have a single definition for our Request- and Response-models.

## Consequences

Reduces development time and effort as it generates code based on the OpenApi specifications.
Knowledge across the team members needs to be built.
