node {

    environment {
        registry = "shatsibed"
        registryCredential = 'docker_id'
        dockerImage = ''
    }

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

    stage('Building our image') {
        steps {
            script {
                dockerImage = docker.build registry + ":$BUILD_NUMBER"
            }
        }
    }
    stage('Deploy our image') {
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
}