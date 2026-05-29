 def call(String imageName, String tag, String dockerHubUser) {
    sh "docker build -t ${imageName}:${tag} ."
}
