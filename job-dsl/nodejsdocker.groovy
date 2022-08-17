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
            tag('0.1.0')
            registryCredentials('docker-hub')
            forcePull(true)
            createFingerprints(true)
            skipDecorate()
        }
    }
}
