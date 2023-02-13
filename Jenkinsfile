node {
      stage("Git Clone"){

        git branch: 'main', url: 'https://github.com/Development456/ConfigServer.git'
      }
    stage('Build Project'){
        def mvnHome = tool name: 'maven', type: 'maven'
          sh "mvn clean package"
          echo "Executed Successfully Project1"
    }
      stage("Docker build"){
        sh 'docker build -t configserver1 .'
        sh 'docker image ls'
      }
      withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'test', usernameVariable: 'apurva', passwordVariable: 'password']]) {
        sh 'docker login -u apurva@09 -p $password'
      }
      stage("Pushing Image to Docker Hub"){
	sh 'docker tag configserver apurva/configserver1'
	sh 'docker push apurva/configserver1'
      }
	stage("SSH Into Server") {
       def remote = [:]
       remote.name = 'DEV-VM'
       remote.host = '20.62.171.46'
       remote.user = 'dev_azureuser'
       remote.password = 'AHTgxKmRGb05'
       remote.allowAnyHosts = true
     }
     stage("Deploy"){
	     sh 'docker stop configserver1 || true && docker rm -f configserver1 || true'
	     sh 'docker run -d -p 8888:8888 --name configserver1 configserver1'
     }
}
