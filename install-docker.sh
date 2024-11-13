#!/bin/sh -e

docker run -v "$PWD":/app -v "$PWD/.m2":/root/.m2 -w /app maven:3.9-eclipse-temurin-17 mvn dependency:go-offline
