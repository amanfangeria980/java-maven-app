def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image and pushing it to docker hub..."
    withCredentials([usernamePassword(credentialsId: 'Docker-Hub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
    sh 'docker build -t amanfangeria/java-maven-app:2.0.0 .'
    sh 'echo $PASS | docker login -u $USER --password-stdin'
    sh 'docker push amanfangeria/java-maven-app:2.0.0'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this