def call(String toolName, String projectName, String projectKey) {
    withSonarQubeEnv(toolName) {
        sh """
            $SONAR_HOME/bin/sonar-scanner \
            -Dsonar.projectName=${projectName} \
            -Dsonar.projectKey=${projectKey}
        """
    }
}
