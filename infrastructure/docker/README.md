# Login with aws cli
aws ecr get-login-password --region us-east-2 | docker login --username AWS --password-stdin 209479286878.dkr.ecr.us-east-2.amazonaws.com

# Tag image
docker tag postgres 209479286878.dkr.ecr.us-east-2.amazonaws.com/intellibus-hackerton-repo:latest

# Push Image
docker push 209479286878.dkr.ecr.us-east-2.amazonaws.com/intellibus-hackerton-repo:latest

# Convert docker compose file to generated kubernetes files
kompose convert -f docker-compose.yml

# Add load balance type under spec to service file to expose it
type: LoadBalancer

# Deploy to kubernetes
kubectl apply -f db-service.yaml

# View external ip address
kubectl get svc