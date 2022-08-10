job('DockerBuildandPublishDSL') {
    description('Build and Publish vickyrajagopal Tomcat server Image to docker repository')
     scm {
        git {
        remote {
                url('https://github.com/PrabhuVignesh/Docker-Tomcat.git')
            }
            wrappers {
                preBuildCleanup()
            } 
            branch('*/' + 'master')
        }
    }

    steps {
        dockerBuildAndPublish {
            repositoryName('vickyrajagopal/tomcat')
            registryCredentials('docker-hub')
        }
    }
}
