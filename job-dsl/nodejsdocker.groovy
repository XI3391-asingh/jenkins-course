job('NodeJS Docker example') {
    scm {
        git('https://github.com/wardviaene/docker-demo.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('XI3391-asingh')
            node / gitConfigEmail('abhishek.singh5@xebia.com')
        }
    steps {
      dockerBuildAndPublish {
            repositoryName('carbonaraaah/jenkins-jobdsl')
            tag('${BUILD_TIMESTAMP}-${GIT_REVISION,length=7}')
            registryCredentials('docker-hub')
            forcePull(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
