# oTTo

"oTTo (openspace Time Table organizer) is an open source service for managing open spaces such as barcamps in which participants can add and move sessions during the event and the time table is adjusted  in real time. It uses Vue, Spring Boot with Kotlin and Postgresql. 


# Local Setup 


We use [direnv](https://direnv.net/) and the nix package manager to manage the local environment. You can install it with your package manager or follow the instructions on the website. 


## Requirements

* direnv
* docker
* nix package manager

## Setup

1. Make sure you have the requirements installed
2. For direnv
2. Clone the repository
3. Open the project folder in your terminal
4. Copy `.env.dist` to `.env`
5. Run `direnv allow` to load the environment 
6. Start a local development cluster with `minikube start`
7. Deploy the application in dev mode with `skaffold dev`
8. For dev purposes, tunnel to the backend service with `kubectl --namespace otto port-forward svc/backend-otto 8080:8080`
9. Im browser http://localhost:8080/
