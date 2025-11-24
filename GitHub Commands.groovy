GitHub Commands
1) git init
2)Create github repository -> First clone git repository ->git init
3)git clone url
4)git status
5)git add .
6)git commit -m "message"
7)git remote -v
8)git remote add origin repository_url
9)git branch -M origin main
10)git push -U origin main
11)git pull origin main
12)git add .
13)git commit -m "Issue Resloved"
14)git push origin main
13)git push origin main --force


Docker Command 
1)create folder
2)create Dockerfile with file name Dockerfile paste 
FROM nginx:latest
COPY . /usr/share/nginx/html
EXPOSE 80
into Dockerfile

3)docker build -t folder_name .
4)docker run -d -p 8080:80 folder_name

Username - prajakta47
Password-Docker@123


Jenkins with Docker 

pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'prajakta47/resturant_website'
        REGISTRY_CREDENTIALS = 'dockerhub-credentials-id'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/PrajaktaJMohite/Resturant_Website.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${DOCKER_IMAGE}:${env.BUILD_NUMBER}")
                }
            }
        }

        stage('Push to Docker Hub') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', REGISTRY_CREDENTIALS) {
                        docker.image("${DOCKER_IMAGE}:${env.BUILD_NUMBER}").push()
                    }
                }
            }
        }

        stage('Test') {
            steps {
                echo "Run tests here"
                // sh 'npm test'
            }
        }

        stage('Deploy') {
            steps {
                echo "Deploy stage"
            }
        }

    } // END stages

} // END pipeline


In docker first create docker file then push it into github
 then go to Jenkins new item-> pipeline-> pipeline script->
paste above script-> build now-> then open docker

****** Jenkins pipeline*****
simple pipeline code 

pipeline {
 agent any
 environment {
 DEPLOY_DIR = 'C:\\inetpub\\wwwroot' // IIS web root folder
 }
 stages {
 stage('Checkout') {
 steps {
 echo 'Cloning project from GitHub...'
 git branch: 'main', url: 'https://github.com/PrajaktaJMohite/To-Do-List.git'
 }
 }
 stage('Build') {
 steps {
 echo 'Build Step: Check files in workspace'
 bat 'dir'
 }
 }
 stage('Deploy') {
 steps {
 echo "Deploying Home.html to IIS folder"
 // Directly copy Home.html to webserver root
 bat "xcopy /Y index.html ${DEPLOY_DIR}\\"
 }
 }
 stage('Run HTTP Server (Optional Test)') {
 steps {
 echo 'Skipping HTTP server (use IIS instead)'
 // For testing, you can use: bat 'python -m http.server 8000'
 }
 }
 }
 post {
 success {
 echo 'Pipeline finished successfully! Visit: http://localhost/index.html'
 }
 failure {
 echo 'Pipeline failed! Check build logs.'
 }
 }
}

pipeline like build , test , deploy , release


3) Maven 

Maven 
1)	Open new window in vs code
2)	Ctrl+shift+p type
3)	Click maven new project
4)	Select maven architect webapp
5)	Save file in desktop
6)	Then past code in index .jsp
7)	Then type mvn clean on terminal
8) then type mvn clean package 

Then open apache tomcat
Program files-> apache foundation -> 
bin -> open cmd-> type startup.bat->  
type on browser localhost 8081->
copy war from project folder to
 then paste it to apche webapp -> 
 then type on browser 
 localhost:8080/project folder name http://localhost:8081/travel2/

If target folder is not removing then manually remove it 



