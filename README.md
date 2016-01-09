# Docker Selenium Demo

This repository contains Dockerfiles for running a simple test using Selenium with JUnit, Maven and Selenium Remote Driver.



## Prerequisites (Mac)

You should have Docker Toolbox installed, see https://www.docker.com/toolbox

### Step 0 - List Docker Machine

```
~/docker-selenium-demo $ docker-machine ls
~/docker-selenium-demo $ docker-machine ls
NAME      ACTIVE   DRIVER       STATE     URL                         SWARM   DOCKER   ERRORS
default   *        virtualbox   Running   tcp://192.168.99.100:2376           v1.9.1   
```

### Step 1 - Start VM

If the docker engine is not running start the engine.

```
docker-machine start default
```

## Getting started

To get all docker containers up and running use:

```
git clone git@github.com:eteration/docker-selenium-demo.git
cd docker-selenium-demo
docker-compose up
```


## Caching Maven Repository

Docker containers running maven does not cache files under the .m2/ folder. Thherefore, maven will download everything from the internet by default.  This is slightly annoying but we can fix it by sharing a local repository with the docker container that runs maven. There are more than one way of caching the repository but this is one of the simpler methods.  Modify the docker-compose.yml file and add a volume that will be mounted on the container.  The example below mount the .m2 from users home folder to /root/.2 (default location for the repository in official maven image):

```
wikipedia-test:
  build: ./wikipedia-test
  command: "mvn test"
  volumes:
    - ~/.m2:/root/.m2
  links:
    - selfirefox:selfirefox

```
