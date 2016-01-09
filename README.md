# Docker Selenium Demo

This repository contains Dockerfiles for running a simple test using Selenium with JUnit, Maven and Selenium Remote Driver.



## Prerequisites (Mac)

You should have Docker Toolbox installed, see https://www.docker.com/toolbox

### Step 0 - List Docker Machine

```
~/git/docker-ci-tool-stack$ docker-machine ls
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
