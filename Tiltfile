load('ext://helm_resource', 'helm_resource', 'helm_repo')
helm_repo('bitnami', 'https://charts.bitnami.com/bitnami')
helm_resource('db', 
  'bitnami/postgresql', 
  namespace="otto",
  flags=['--values=./helm/dev-db-config.yaml']
 )
yaml = helm('./helm/otto',
  name='otto',
  namespace='otto'
)
k8s_yaml(yaml)

k8s_resource("otto-frontend", port_forwards='3000:80')
k8s_resource("otto-backend",port_forwards="8080")

docker_build('ghcr.io/mayflower/otto-frontend','.',dockerfile='packages/frontend/Dockerfile', only=['packages/frontend','packages/api-spec'])
custom_build('ghcr.io/mayflower/otto-backend', 
'./mvnw compile jib:dockerBuild -pl packages/backend -Dimage=$EXPECTED_REF', 
deps=['packages/backend'], ignore=['bin','target'])