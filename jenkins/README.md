# Jenkins

## From the respository
To start Jenkins using docker on port 999 using ~/jenkins as the data folder
```
docker run -d -p 9999:8080 -v ~/jenkins:/var/jenkins_home:z -t jenkins
```

You can now open Jenkins using localhost:9999

To get the Jenkins password, you need to find the docker instance and then execute the cat command
```
docker ps
docker exec c20168770758 cat /var/jenkins_home/secrets/initialAdminPassword
```

More details here http://www.asktomash.com/create-jenkins-docker-container-and-run-first-maven-job-in-less-than-10-minutes/


## Building the Jenkns image

Build a new Jenkins image using Dockerfile
```
docker build -t myjenkins:latest .
```

