job('DockerBuildandPublishDSL') {
    description('Build and Publish vickyrajagopal Tomcat server Image to docker repository')
     scm {
        git {
        remote {
                url('https://github.com/PrabhuVignesh/Docker-Tomcat.git')
                credentials('jenkinsslave-gihub')
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
            registryCredentials('e6a34d22-3562-4e22-a525-012c681fece1')
        }
    }
}
