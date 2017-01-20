#!/bin/sh
mvn  package -Dmaven.test.skip=true

scp ./core/target/spring-boot-simple-1.0.0.jar root@60.205.183.125:/var/webapps/