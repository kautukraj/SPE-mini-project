pipeline {
    // The “agent” section configures on which nodes the pipeline can be run.
    // Specifying “agent any” means that Jenkins will run the job on any of the
    // available nodes.

	agent any

    stages {
        stage('Git Pull') {
            steps {
                // Get code from a GitHub repository
                // Make sure to add your own git url and credentialsId
				git url: 'https://github.com/kautukraj/MINI_PROJECT.git',
				branch: 'main',
                credentialsId: 'GitCredential'
            }
        }
        stage('Maven Build') {
            steps {
                // Maven build, 'sh' specifies it is a shell command
                sh 'mvn clean install'
            }
        }
        stage('Build Docker Images') {
            steps {
                sh 'docker build -t kautukraj/docker-push .'
            }
        }

            stage('Publish Docker Images') {
      steps {
        withCredentials([usernamePassword(credentialsId: 'dockerHub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
          sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
          sh 'docker push kautukraj/docker-push:latest'
        }
      }
    }



        /*stage('Publish Docker Images') {
            steps {
                withDockerRegistry([ credentialsId: "dockerHub", url: "https://registry.hub.docker.com" ]) {
                    sh 'docker push kautukraj/docker-push'
                }
            }
        }*/

        stage('Clean Docker Images') {
            steps {
                sh 'docker rmi -f kautukraj/docker-push'
            }
        }
        stage('Deploy and Run Image'){
            steps {
                ansiblePlaybook becomeUser: null, colorized: true, disableHostKeyChecking: true, installation: 'Ansible', inventory: 'inventory', playbook: 'playbook.yml', sudoUser: null
            }
        }

    }

    /* post {
        always {
            sh 'docker logout'
        }
    } */
}
