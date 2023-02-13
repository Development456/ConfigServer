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
      withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'test', usernameVariable: 'jsilaparasetti', passwordVariable: 'password']]) {
        sh 'docker login -u jsilaparasetti -p $password'
      }
      stage("Pushing Image to Docker Hub"){
	sh 'docker tag configserver jsilaparasetti/configserver1'
	sh 'docker push jsilaparasetti/configserver1'
      }
	stage("SSH Into Server") {
       def remote = [:]
       remote.name = 'CLAIMS-VM'
       remote.host = '20.163.133.102'
       remote.user = 'azureuser'
       remote.password = 'Miracle@1234'
       remote.allowAnyHosts = true
     }
     stage("Deploy"){
	     sh 'docker stop configserver1 || true && docker rm -f configserver1 || true'
	     sh 'docker run -d -p 8888:8888 --name configserver1 configserver1'
     }
}
