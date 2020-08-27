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
echo 'build ....'
}
}
stage('Deploy') {
steps {
echo 'deploy ....'
}
}
}
}