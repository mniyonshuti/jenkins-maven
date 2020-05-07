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
    stage('Compile'){
            sh 'mvn compiler:testCompile'
    }
    stage('Compile-Package'){
     sh 'mvn package'
    }
}