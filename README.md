# Eureka-service
Implementation of Spring Cloud Netflix Eureka Server . 

## Use

This helps microservices to register to a Discovery server(eureka-server) which enables them to locate other registered microservices . \This helps us to eliminate the hard coding of url to the other microservices.

## Setup 

1. After cloning, navigate to the root project directory (it's where you can find pom.xml).
2. Run `mvn clean install`

## How to run

In the project directory, you can run:

### `mvn spring-boot:run`

Runs the app in the development mode.\
Runs on [http://localhost:8761](http://localhost:8761). 

Now open your browser and access [http://localhost:8761](http://localhost:8761). 

You should probably see something like this and now its running

![Eureka - Google Chrome 06-Aug-21 9_46_34 AM](https://user-images.githubusercontent.com/62425476/128455272-6c36354b-8cdb-476e-933c-b25b4fd8bd0b.png)

