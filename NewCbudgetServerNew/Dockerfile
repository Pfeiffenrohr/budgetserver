FROM ubuntu:latest

RUN apt-get update && \
    apt-get install -y openjdk-8-jdk && \
    apt-get install -y ant && \
    apt-get clean;

# Fix certificate issues
RUN apt-get update && \
    apt-get install ca-certificates-java && \
    apt-get clean && \
    update-ca-certificates -f;

# Setup JAVA_HOME -- useful for docker commandline
ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64/
RUN export JAVA_HOME

RUN apt-get update && apt-get install -y dos2unix
RUN mkdir /var/lib/cbudgegetserver
WORKDIR /var/lib/cbudgegetserver/
ADD target/NewCbudgetServerNew-0.0.1-SNAPSHOT.jar /var/lib/cbudgetbatch/budgetserver.jar
ADD scripts/budgetserver.sh /var/lib/cbudgegetserver/budgetserver.sh
RUN chmod 777 /var/lib/budgetserver/budgetserver.sh
RUN dos2unix /var/lib/budgetserver/budgetserver.sh
OPY lib/*.jar /var/lib/budgetserver/
COPY target/lib/*.jar /var/lib/budgetserver/
ENTRYPOINT ["/var/lib/budgetserver/budgetserver.sh"]