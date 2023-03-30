# Local Environment

## Requirements
* Docker
* Azul OpenJDK 17
* provide a `.env` (based on `.env.dist`)

## Local Database
* docker based, see [doc](https://hub.docker.com/_/postgres) 
* can be viewed using [adminer](https://hub.docker.com/_/adminer)

## Compose
* can be used for local development
* cannot use [jib](https://github.com/GoogleContainerTools/jib) with build -> custom Dockerfile per service
* the custom Dockerfiles are dependent on the context set in `compose.yml` 