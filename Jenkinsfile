pipeline {

    agent any

    tools {
        jdk 'JDK21'
        maven 'Maven-3.9.16'
    }

    environment {
        IMAGE_NAME = "corporatewebsite"
        IMAGE_TAG  = "v1"
    }

    stages {

        stage('Verify Tools') {
            steps {
                echo "===== VERIFYING TOOLS ====="
                bat 'java -version'
                bat 'mvn -version'
                bat 'docker --version'
                bat 'kubectl version --client'
            }
        }

        stage('Clean Project') {
            steps {
                echo "===== CLEAN PROJECT ====="
                bat 'mvn clean'
            }
        }

        stage('Compile Project') {
            steps {
                echo "===== COMPILE PROJECT ====="
                bat 'mvn compile'
            }
        }

        stage('Package Application') {
            steps {
                echo "===== PACKAGE APPLICATION ====="
                bat 'mvn package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                echo "===== BUILD DOCKER IMAGE ====="
                bat 'docker build -t %IMAGE_NAME%:%IMAGE_TAG% .'
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                echo "===== DEPLOY TO KUBERNETES ====="
                bat 'kubectl apply -f k8s/deployment.yaml'
                bat 'kubectl apply -f k8s/service.yaml'
                bat 'kubectl rollout restart deployment corporatewebsite'
                bat 'kubectl rollout status deployment/corporatewebsite'
            }
        }

        stage('Verify Deployment') {
            steps {
                echo "===== VERIFY DEPLOYMENT ====="
                bat 'kubectl get deployments'
                bat 'kubectl get pods -o wide'
                bat 'kubectl get svc'
                bat 'kubectl get endpoints'
            }
        }
    }

    post {
        always {
            echo "Pipeline Finished."
        }

        success {
            echo "======================================="
            echo "BUILD SUCCESSFUL"
            echo "Corporate Website Successfully Deployed"
            echo "======================================="
        }

        failure {
            echo "======================================="
            echo "BUILD FAILED"
            echo "Check Jenkins Console Output"
            echo "======================================="
        }
    }
}