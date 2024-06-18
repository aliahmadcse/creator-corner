# Spring Auth API

## Table of Contents
- [Overview](#overview)
- [Prerequisites](#prerequisites)
- [Setting Up PostgreSQL and Redis Using Docker Compose](#setting-up-postgresql-and-redis-using-docker-compose)
- [Building and Running the Project](#building-and-running-the-project)
- [Contributing](#contributing)

## Overview
This is a Spring Boot API project that requires Java 17, PostgreSQL, and Redis. The project uses Maven for dependency management and build automation.

## Prerequisites
Before running the project, ensure you have the following installed:

1. **Java 17**: Download and install from [here](https://jdk.java.net/17/).
2. **Docker and Docker Compose**: Install Docker from [here](https://docs.docker.com/get-docker/) and Docker Compose from [here](https://docs.docker.com/compose/install/).

## Setting Up PostgreSQL and Redis Using Docker Compose

1. Run the following command to start PostgreSQL and Redis:

    ```bash
    docker-compose up -d
    ```

## Building and Running the Project

1. Ensure Java 17 is installed:

    ```bash
    java -version
    ```

   The output should be similar to:

    ```
    java version "17.0.x"
    Java(TM) SE Runtime Environment (build 17.0.x)
    Java HotSpot(TM) 64-Bit Server VM (build 17.0.x, mixed mode)
    ```

2. Build the project using Maven:

    ```bash
    mvn clean install
    ```

3. Run the project:

    ```bash
    mvn spring-boot:run
    ```

## Contributing
Contributions are welcome! Please fork the repository and submit a pull request.
