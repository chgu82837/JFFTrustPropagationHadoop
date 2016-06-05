#!/bin/sh

docker run -it --rm --name Infomation-retrieval-trust-propagation-problem -v "$PWD":/usr/src/mymaven -w /usr/src/mymaven maven:3.2-jdk-7 mvn clean package
mv target/Infomation-retrieval-trust-propagation-problem-0.0.1-SNAPSHOT-jar-with-dependencies.jar ./Infomation-retrieval-trust-propagation-problem.jar
