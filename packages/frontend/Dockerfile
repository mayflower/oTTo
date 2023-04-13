FROM openapitools/openapi-generator-cli:6.4.0 AS openapitools

RUN mkdir -p /app/generated-sources/client
WORKDIR /app/generated-sources/client
# https://openapi-generator.tech/docs/installation#docker

FROM node:alpine3.17 AS builder

RUN mkdir -p /app
WORKDIR /app

COPY frontend/package*.json ./

RUN npm install
RUN npm run build

FROM nginx:latest as webserver

COPY /build /var/html/