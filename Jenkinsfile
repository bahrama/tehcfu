pipeline{
agent any

stages {
stage('Checkout') {
steps {
git 'https://github.com/bahrama/tehcfu.git'
}
}
stage('Build') {
steps {
sh 'mvn clean install'
}
}
stage('Deploy') {
steps {
sh 'yes | cp /var/lib/jenkins/workspace/Etehadie_pip/mokh1-ear/target/mokh1.ear /home/wildfly/wildfly-18.0.1.Final/standalone/deployments'
}
}
}
}