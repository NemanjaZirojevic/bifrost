pipeline {
	agent any
	tools {
		jdk 'JAVA_11'
	}
	stages {
		stage('Build') {
                agent {
                    docker {
                        image 'neomantra/flatbuffers'
                        reuseNode true
                     }
                }
                steps {
                    sh 'flatc -j -b repos_schema.fbs repos_json.json'
                }
        }
		stage('Test'){
			steps{
				bat "mvn test"
			}
		}
		stage('Deploy') {
			steps {
			    bat "mvn jar:jar deploy:deploy"
			}
		}
	}
}
