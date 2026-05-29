def call(String imageName, String tag, String dockerHubUser) {
    withCredentials([usernamePassword(credentialsId: "docker-HubCred",
        passwordVariable: "dockerHubPass",
        usernameVariable: "dockerHubUser")]) {
        sh """
            echo \$dockerHubPass | docker login -u \$dockerHubUser --password-stdin
            docker image tag ${imageName}:${tag} \$dockerHubUser/${imageName}:${tag}
            docker push \$dockerHubUser/${imageName}:${tag}
        """
    }
}
