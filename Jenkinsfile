pipeline {
    agent any

    tools {
        jdk 'JDK-14'
        maven 'Maven-3.8'
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
            }
        }
        stage('Build') {
            steps {
                // Run the maven build without tests
                sh 'mvn clean install -DskipTests=true'
            }
        }
        stage('Test') {
            steps {
                // Run the maven build with tests
                sh 'mvn clean install --batch-mode --errors --fail-at-end'
            }
            post {
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'

                    withChecks('Integration Tests') {
                        junit '**/target/failsafe-reports/TEST-*.xml'
                    }
                }
            }
        }
    }
}