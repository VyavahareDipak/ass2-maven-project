pipeline {
    agent any

    tools {
        maven 'sonarmaven' // Ensure this matches your Jenkins Maven configuration
      
        
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

        stage('Build and test') {
            steps {
                bat 'mvn clean verify'
                
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('sonarqube') { // Replace 'sonarqube' with your SonarQube server configuration name
                    echo 'Running SonarQube Analysis...'
                    bat """
                        mvn sonar:sonar \ 
                        -Dsonar.projectKey=ass2-maven-project \ 
                        -Dsonar.sources=src/main/java \ 
                        -Dsonar.tests=src/test/java \ 
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
            echo 'Pipeline failed. Check the logs for errors.'
        }
    }
}
