FROM openapitools/openapi-generator-cli:v6.4.0 AS openapigenerator_builder

RUN mkdir -p /app/generated-sources/client
COPY packages/api-spec/openapi.yml /app/openapi.yml
WORKDIR /app/generated-sources/client
RUN /usr/local/bin/docker-entrypoint.sh \
    generate -i /app/openapi.yml -g typescript-axios -o . \
    --additional-properties=npmName=rest-client,withInterface=true,supportsES6=true

# https://openapi-generator.tech/docs/generators/typescript-axios/
# https://openapi-generator.tech/docs/installation#docker

FROM node:alpine3.17 AS frontend_builder_prod

RUN mkdir -p /app
WORKDIR /app

# copy the generated openapi-client
COPY --from=openapigenerator_builder /app/generated-sources/client /app/generated-sources/client

# install npm dependencies
COPY packages/frontend/package*.json ./
RUN npm install

#  build frontend
WORKDIR /app
COPY packages/frontend ./
RUN npm run build


FROM nginx:latest as webserver_prod

COPY --from=frontend_builder_prod /app/dist /usr/share/nginx/html
EXPOSE 80
