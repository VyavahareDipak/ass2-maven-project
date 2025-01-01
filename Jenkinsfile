pipeline {
    agent any

    tools {
        maven 'sonarmaven' // Match the Maven version configured in Jenkins
    }

    environment {
        SONAR_TOKEN = credentials('sonar-global-token') // Replace with your credentials ID
        JAVA_HOME = 'C:\\Program Files\\Java\\jdk-17'  // Ensure the correct Java version is installed
        PATH = "${JAVA_HOME}\\bin;${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Dependency Check') {
            steps {
                echo 'Verifying Maven Dependencies...'
                bat 'mvn dependency:resolve'
            }
        }

        stage('Build and Test') {
            steps {
                echo 'Building and Testing the Maven Project...'
                bat 'mvn clean test'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('sonarqube') { // Replace 'sonarqube' with your SonarQube configuration name in Jenkins
                    echo 'Running SonarQube Analysis...'
                    bat """
                        mvn sonar:sonar ^
                        -Dsonar.projectKey=my-maven-project ^
                        -Dsonar.projectName='My Maven Project' ^
                        -Dsonar.sources=src/main/java ^
                        -Dsonar.host.url=http://localhost:9000 ^
                        -Dsonar.login=%SONAR_TOKEN%
                    """
                }
            }
        }
    }

    post {
        always {
            echo 'Cleaning Up Workspace...'
            cleanWs() // Clean workspace after every run
        }

        success {
            echo 'Pipeline completed successfully.'
        }

        failure {
            echo 'Pipeline failed. Check the logs for errors.'
        }
    }
}
