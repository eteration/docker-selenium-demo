FROM java:openjdk-8-jdk
MAINTAINER Naci Dai <nacidai@acm.org>

ENV MAVEN_VERSION 3.3.9

RUN curl -fsSL https://archive.apache.org/dist/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz | tar xzf - -C /usr/share \
  && mv /usr/share/apache-maven-$MAVEN_VERSION /usr/share/maven \
  && ln -s /usr/share/maven/bin/mvn /usr/bin/mvn

ENV MAVEN_HOME /usr/share/maven




RUN mkdir --parents /code/testing/wiki
WORKDIR /code/testing/wiki

ADD ./test /code/testing/wiki

#This is test meant to run with a Remote Driver
# Use Command and --link selfirefox to setup etc/hosts
#RUN mvn test
