pipeline {
    agent any
  //triggers {pollSCM('* * * * *')}
  stages {
    stage('Checkout') {
      steps {
        // Get some code from a GitHub repository
        git branch: "main", url: 'https://github.com/Benjaminjbonnet/SparkTea.git'
      }
    }
        stage('Build') {
      steps {
        sh 'chmod a+x mvnw'
        sh './mvnw clean package -DskipTests=true'
      }

          post {
        always {
          archiveArtifacts 'target/*.jar'
        }
          }
        }
        stage('DockerBuild') {
      steps {
        sh 'sudo docker build -t benjaminjbonnet/user-rest:latest .'
      }
        }
         stage('DockerRun') {
      steps {
        sh 'docker run  -p 9090:9090 benjaminjbonnet/user-rest'
      }
        }
  }
}