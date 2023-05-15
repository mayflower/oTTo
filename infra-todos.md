todos 

frontend:
- build:
  - openapi anders?
  buildpacks?
  direkt docker?
  über maven?
deploy
 nginx prod vs dev container?
 - postgres: wir stellen code für dev bereit, den leute optional für prod hernehmen könnten, wir rechnen aber nicht damit

setup
 - minikube (1.02 GB) durch kind/k3s ersetzen? (Install-Größe und Performanz)
  - Findings:
    - Kind ist unwesentlich kleiner (823 MB), und es ist deutlich umständlicher, ein Kubernetes-Dashboard zum laufen zu bekommen
    - k3s läuft nicht auf MacOS
    - k3d wesentlich kleiner in images: 161 + 39 + 18 MB, schnell
    -> k3d könnte sich lohnen, wenn aufsetzen reibungslos geht

skaffold-zeug:
 - FileSync, damit nicht immer neu gebaut werden muss

 backend:
- Warum funktionieren probes nicht?
- liquibase in initcontainer
- https://redhat-scholars.github.io/spring-boot-k8s-tutorial/spring-boot-tutorial/03-kubernetes.html
