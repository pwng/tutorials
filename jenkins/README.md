# Jenkins


## Building the Jenkins image

Build a new Jenkins image using Dockerfile
```
docker build -t myjenkins:latest .
```

## Starting the docker image
To start Jenkins using docker on port 999 using ~/jenkins as the data folder
```
docker run -d -p 9999:8080 -v ~/jenkins:/var/jenkins_home:z -t myjenkins
```

You can now open Jenkins using localhost:9999

To get the Jenkins password, you need to find the docker instance and then execute the cat command
```
docker ps
docker exec c20168770758 cat /var/jenkins_home/secrets/initialAdminPassword
docker logs c20168770758
```
Docker exec command above can use the password if you have a standard jenkins docker installation, but with a docker image built using my Dockerfile, you need to use docker logs to retrieve the password



