node {
    environment {
        registry = "docker_hub_account/repository_name"
        registryCredential = 'dockerhub'
    }
    agent any
    stage('SCM Checkout'){
        git 'https://github.com/mniyonshuti/jenkins-maven'
    }
    stage('Clean'){
         sh 'mvn clean'
    }
    stage('Compile'){
        sh 'mvn compiler:compile'
    }
    stage('test'){
            sh 'mvn compiler:testCompile'
    }
    stage('Package'){
     sh 'mvn package'
    }

//     stage('Building image') {
//        steps{
//           script {
//             docker.build registry + ":$BUILD_NUMBER"
//           }
//        }
//     }

}