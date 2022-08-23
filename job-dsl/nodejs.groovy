job('NodeJS example') {
    scm {
        git('https://github.com/wardviaene/docker-demo.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('XI3391-asingh')
            node / gitConfigEmail('abhishek.singh5@xebia.com')
        }
    }
//     triggers {
//         scm('H/5 * * * *')
//     }
    wrappers {
        nodejs('NodeJS Latest') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        shell("npm install")
        shell("npm fund")
    }
}
