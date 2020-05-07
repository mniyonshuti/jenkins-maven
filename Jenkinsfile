node {

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

}