pipeline {

    agent any

    tools {
        jdk 'JDK25'
        maven 'Maven-3.9.16'
    }

    environment {
        IMAGE_NAME = "likhith99/corporatewebsite"
        IMAGE_TAG = "v1"
    }

    stages {

        stage('Verify Tools') {
            steps {
                echo "Verifying Installed Tools..."

                bat 'java -version'
                bat 'mvn -version'
                bat 'docker --version'
                bat 'kubectl version --client'
            }
        }

        stage('Clean Project') {
            steps {
                echo "Cleaning Project..."
                bat 'mvn clean'
            }
        }

        stage('Compile Project') {
            steps {
                echo "Compiling Project..."
                bat 'mvn compile'
            }
        }

        stage('Run Unit Tests') {
            steps {
                echo "Running Unit Tests..."
                bat 'mvn test'
            }
        }

        stage('Package Application') {
            steps {
                echo "Packaging Spring Boot Application..."
                bat 'mvn package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                echo "Building Docker Image..."
                bat 'docker build -t %IMAGE_NAME%:%IMAGE_TAG% .'
            }
        }

        stage('Push Docker Image') {
            steps {
                echo "Pushing Docker Image to Docker Hub..."

                bat 'docker push %IMAGE_NAME%:%IMAGE_TAG%'
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                echo "Deploying Application..."

                bat 'kubectl apply -f k8s/deployment.yaml'
                bat 'kubectl apply -f k8s/service.yaml'
            }
        }

        stage('Verify Deployment') {
            steps {
                echo "Checking Deployment Status..."

                bat 'kubectl rollout status deployment/corporatewebsite'

                bat 'kubectl get deployments'

                bat 'kubectl get pods'

                bat 'kubectl get svc'
            }
        }
        stage('Docker Diagnostics') {
    steps {
        bat 'docker info'
        bat 'docker images'
        bat 'docker login --username likhith99'
    }
}

    }

    post {

        always {

            echo "====================================="
            echo "Pipeline Finished"
            echo "====================================="

        }

        success {

            echo "====================================="
            echo "BUILD SUCCESSFUL"
            echo "Corporate Website Successfully Deployed"
            echo "====================================="

        }

        failure {

            echo "====================================="
            echo "BUILD FAILED"
            echo "Please Check Jenkins Console Output"
            echo "====================================="

        }

    }

}
