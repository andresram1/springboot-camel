# Sprint Boot - Apache Camel integration

## Introduction

This is a small example that combines the use of Spring Boot with Apache Camel

- It uses Spring Boot
- [Spring Initializer](https://start.spring.io/) is used. The following dependencies are included
  - Web
  - Apache Camel
- It shows how routes are chained using Apache Camel

A small set of tests is included

## Usage

Run the application

```bash
mvn spring-boot:run
```

Call the endpoint 

```bash
# With http
http -v localhost:8080/hello

# With cUrl
curl -v localhost:8080/hello
```

Run a particular test
```bash
mvn -Dtest=HelloAnotherTests test
```