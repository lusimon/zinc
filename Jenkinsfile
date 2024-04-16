pipeline {
	agent any
	tools {
        	maven 'Maven 3.6.3'
    	}
	stages {
		stage('Build') {
			steps {
				echo 'Building...'
				git url: 'https://github.com/lusimon/zinc.git'
				withMaven {
          				sh "mvn -f jsflib/pom.xml clean verify"
        			} // withMaven will discover the generated Maven artifacts, JUnit Surefire & FailSafe reports and FindBugs reports
				echo 'Running ${env.BUILD_ID} ${env.BUILD_DISPLAY_NAME} on ${env.NODE_NAME} and JOB ${env.JOB_NAME}'
			}
		}
		
		stage('Test') {
			steps {
				echo 'Testing...'
			}
		}
		
		stage('Deploy') {
			steps {
				echo 'Deploying...'
			}
		}
	}
}
