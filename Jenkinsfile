pipeline {
    agent any

    tools {
        jdk 'JDK-17'
        maven 'Maven-3.9'
    }

    options {
        timeout(time: 30, unit: 'MINUTES')
        timestamps()
        disableConcurrentBuilds()
        buildDiscarder(logRotator(numToKeepStr: '10'))
    }

    stages {
        stage('Prepare') {
            steps {
                // Get code from GitHub repository
                echo 'Pulling branch ' + env.GIT_BRANCH
                sh 'mvn clean'
            }
        }
        stage('Build') {
            steps {
                // Run the maven build
                sh 'mvn compile'
            }
        }
        stage('Test (UT)') {
            steps {
                // Run the maven build with tests
                sh 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
        stage('Test (IT)') {
            steps {
                // Run the maven build with integration tests
                sh 'mvn verify'
            }
            post {
                always {
                    junit '**/target/failsafe-reports/TEST-*.xml'
                }
            }
        }
    }
}
