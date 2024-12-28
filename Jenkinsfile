
pipeline {
    agent any
    tools {
        maven 'sonarmaven' // Ensure this matches the Maven configuration in Jenkins
    }
    environment {
        SONAR_TOKEN = credentials('sonarqube-token') // Replace with your credentials ID for the SonarQube token
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('sonarqube') { // Ensure the name matches your SonarQube configuration
                    bat """
                        mvn sonar:sonar \
                        -Dsonar.projectKey=maven-pro \
                        -Dsonar.sources=src/main/java \
                        -Dsonar.host.url=http://localhost:9000 \
                        -Dsonar.login=%SONAR_TOKEN%
                    """

                    
                }
            }
        }
    }
    post {
        success {
            echo 'Pipeline completed successfully.'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}
