pipeline {

    agent any

    environment {
        registry = "mniyonshuti/test"
        registryCredential = 'niyo-docker'
        dockerImage = ''
        REGION = 'us-east-1'
        SUBNET_ID = 'subnet-1c07f83d'
    }
    stages{
        stage('SCM Checkout'){
            steps {
                git 'https://github.com/mniyonshuti/jenkins-maven'
            }
        }
        stage('Clean'){
            steps{
                sh 'mvn clean'
            }
        }
        stage('Compile'){
            steps  {
                sh 'mvn compiler:compile'
            }
        }
        stage('test'){
            steps {
                sh 'mvn compiler:testCompile'
            }
        }
        stage('Package'){
            steps {
                sh 'mvn package'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }
        stage('Deploy Docker Image') {
            steps {
                script {
                    docker.withRegistry( '', registryCredential ) {
                        dockerImage.push()
                    }
                }
            }
        }
        stage('Cleaning up') {
            steps {
                sh "docker rmi $registry:$BUILD_NUMBER"
            }
        }

        stage('Deploy to AWS') {
            environment {
               DOCKER_HUB_LOGIN = credentials('niyo-docker')
            }
            steps {
//                 withAWS(credentials: 'niyo-aws-credential', region: env.REGION) {
                  sh 'mvn awsCfnMigrateStack awsCfnWaitStackComplete -PsubnetId=$SUBNET_ID -PdockerHubUsername=$DOCKER_HUB_LOGIN_USR -Pregion=$REGION'
//                 }
            }
        }
    }
}
