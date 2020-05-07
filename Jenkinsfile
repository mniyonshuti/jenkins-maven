node {
    stage('SCM Checkout'){
        git 'https://github.com/mniyonshuti/jenkins-maven'
    }
    stage('Compile-Package'){
     sh 'mvn package'
    }
}