## Spring Microservices in Action - Second Edition. Chapter 5

# Introduction

Welcome to Spring Microservices in Action, Chapter 5. Chapter 5 introduces the Spring Cloud Config service and how you
can use it managed the configuration of your microservices. By the time you are done reading this chapter you will have
built and/or deployed:

1. A Spring Cloud Config server that is deployed as Docker container and can manage a services configuration information
   using a file system/ classpath or GitHub-based repository.
2. A licensing service that will manage licensing data used within Ostock.
3. A Postgres SQL database used to hold the data.

## Initial Configuration

1. Apache Maven (http://maven.apache.org)  All of the code examples in this book have been compiled with Java version
    11.
2. Git Client (http://git-scm.com)
3. Docker(https://www.docker.com/products/docker-desktop)

## How To Use

To clone and run this application, you'll need [Git](https://git-scm.com), [Maven](https://maven.apache.org/)
, [Java 11](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html). From your command
line:

```bash
# Clone this repository
$ git clone https://github.com/ihuaylupo/manning-smia

# Go into the repository, by chaning to the directory where you have downloaded the 
# chapter 5 source code
$ cd chapter5

# To build the code examples for Chapter 5 as a docker image, open a command-line 
# window and execute the following command:
$ mvn clean package dockerfile:build

# Now we are going to use docker-compose to start the actual image.  To start the docker image, stay in the directory containing  your chapter 5 source code and  Run the following command: 
$ docker-compose -f docker/docker-compose.yml up
```

# The build command

Will execute the [Spotify dockerfile plugin](https://github.com/spotify/dockerfile-maven) defined in the pom.xml file.

This is the first chapter we will have multiple Spring projects that need to be be built and compiled. Running the above
command at the root of the project directory will build all of the projects. If everything builds successfully you
should see a message indicating that the build was successful.

# The Run command

This command will run our services using the docker-compose.yml file located in the /docker directory.

If everything starts correctly you should see a bunch of Spring Boot information fly by on standard out. At this point
all of the services needed for the chapter code examples will be running.

# Database

You can find the database script as well in the docker directory.

## Contact

I'd like you to send me an email on <illaryhs@gmail.com> about anything you'd want to say about this software.

### Contributing

Feel free to file an issue if it doesn't work for your code sample. Thanks.

# Hashicorp Vault Secret

- [spring document](https://docs.spring.io/spring-cloud-config/docs/current/reference/html/#spring-cloud-config-server-vault-server)
- [shared k/v](https://docs.spring.io/spring-cloud-config/docs/current/reference/html/#spring-cloud-config-server-vault-server)
- [vault document](https://www.vaultproject.io/docs/secrets/kv/kv-v2)

## docker image

```
docker pull vault:latest
```

## docker run

1. docker run

```
docker run --cap-add=IPC_LOCK -e 'VAULT_DEV_ROOT_TOKEN_ID=myroot' -e 'VAULT_DEV_LISTEN_ADDRESS=0.0.0.0:8200' -p 8200:8200 vault
```

2. set env

```
docker ps
docker exec -it container-id /bin/sh

export VAULT_ADDR='http://0.0.0.0:8200'
export VAULT_TOKEN='myroot'
```

3. set kv version

```
vault secrets enable -version=2 kv
```

## write k/v

```
vault kv put secret/application foo=bar baz=bam
vault kv put secret/licensing-service-vault example.property="I am vault"
```

## read k/v

```
vault kv get secret/application
vault kv get secret/licensing-service-vault
```

## read k/v from config application

- visit http://localhost:8071/application/default

- visit http://localhost:8071/licensing-service-vault/default

## read k/v from licensing-service-vault application

- visit http://localhost:8080/property then check result
- visit http://localhost:8080/shared then check shared results

