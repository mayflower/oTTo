# oTTo

"oTTo (openspace Time Table organizer) is an open source service for managing open spaces such as barcamps in which participants can add and move sessions during the event and the time table is adjusted in real time. It uses Vue, Spring Boot with Kotlin and Postgresql.

# Local Setup

We use [direnv](https://direnv.net/) and the nix package manager to manage the local environment. You can install it with your package manager or follow the instructions on the website.

## Requirements

- direnv
- docker
- nix package manager

## Setup

1. Make sure you have the requirements installed
2. For direnv make sure to follow the complete guide (hook into shell https://direnv.net/docs/hook.html)
3. Clone the repository
4. Open the project folder in your terminal
5. Copy `.env.dist` to `.env`
6. Run `direnv allow` to load the environment
7. Start a local development cluster with `minikube start`
8. Deploy the application in dev mode with `skaffold dev`
9. Navigate to http://localhost:8080/ in your browser
