# Spring Boot with Kubernetes Project

## About Project

This project demonstrates the integration of Spring Boot with Kubernetes. It covers the creation of services and deployments, along with managing pods for the application.


### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/spring-boot-kubernetes-project.git
   ```

2. Navigate to the project directory:
   ```bash
   cd spring-boot-kubernetes-project
   ```

3. Build the Spring Boot application:
   ```bash
   ./mvnw clean package
   # or
   ./gradlew build
   ```

4. Build the Docker image:
   ```bash
   docker build -t your-username/spring-boot-app:latest .
   ```

### Deploying to Kubernetes

1. Push the Docker image to a container registry (e.g., Docker Hub):
   ```bash
   docker push your-username/spring-boot-app:latest
   ```

2. Apply the Kubernetes configuration files:
   ```bash
   kubectl apply -f k8s/
   ```

3. Verify the deployment and pods:
   ```bash
   kubectl get deployments
   kubectl get pods
   ```

4. Access the application:
   - If using Minikube, start the Minikube tunnel:
     ```bash
     minikube tunnel
     ```
   - Retrieve the service URL:
     ```bash
     kubectl get services
     ```

### Features

- Demonstrates a Spring Boot application containerized with Docker.
- Explains how to create Kubernetes Services and Deployments.
- Shows how to manage Pods in a Kubernetes cluster.

