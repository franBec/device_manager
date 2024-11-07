# Device Manager API

## Overview
This repository contains the solution to the Device Manager API coding challenge, developed by **Franco Exequiel Becvort**. This project is implemented in **Java Spring Boot 3** and provides a RESTful API for managing a device database, supporting various CRUD operations and search functionality.

## Features
- **API**: Manages devices with CRUD operations (Create, Retrieve, Update, Delete).
- **Search**: Allows devices to be searched by brand.
- **OpenAPI Documentation**: API specifications can be found in the `src/main/resources/openapi/deviceManager.yaml`.

## Getting Started

### Prerequisites
- For running with Maven:
  - **Java 21**
  - **Maven**
- For containerized deployment 
  - **Docker**

### Run with Maven
1. Clone the repository:
    ```bash
    git clone https://github.com/franBec/device_manager
    ```
2. Navigate to the project directory:
    ```bash
    cd device_manager
    ```
3. Build and run the application using Maven:
    ```bash
    mvn spring-boot:run
    ```
### Run with Maven
1. Clone the repository:
     ```bash
     git clone https://github.com/franBec/device_manager
     ```
2. Navigate to the project directory:
    ```bash
    cd device_manager
    ```
3. Build the Docker image:
    ```bash
    docker build -t device_manager .
    ```
4. Run the Docker container:
     ```bash
     docker run -p 8080:8080 device_manager
     ```
## API Documentation
The OpenAPI documentation for the API can be found in the src/main/resources/openapi/deviceManager.yaml file. This file provides detailed information on the endpoints, request/response formats, and models used in the API.

## Author
Franco Exequiel Becvort <🐤/>
- [Linkedin](https://www.linkedin.com/in/franco-becvort/)
- [Website](https://pollito.dev/)

This project is intended as a coding challenge solution. No references to the original brand are included in the codebase or documentation.
