pipeline {
    agent any

    environment {
        IMAGE_NAME = "corporatewebsite"
        IMAGE_TAG = "latest"
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build Application') {
            steps {
                bat 'mvnw clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat "docker build -t %IMAGE_NAME%:%IMAGE_TAG% ."
            }
        }

        stage('Run Docker Container') {
            steps {
                bat '''
                docker rm -f corporatewebsite || exit 0
                docker run -d --name corporatewebsite -p 8081:8081 corporatewebsite:latest
                '''
            }
        }
    }

    post {
        success {
            echo 'Build and deployment successful!'
        }

        failure {
            echo 'Build failed!'
        }
    }
}