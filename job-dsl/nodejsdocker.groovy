job('DockerBuildandPublishDSL') {
    description('Build and Publish Tomcat server Image to docker repository')
     scm {
        git {
        remote {
                url('https://github.com/XI3391-asingh/Docker-Tomcat.git')
            }
            wrappers {
                preBuildCleanup()
            } 
            branch('*/' + 'master')
        }
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
