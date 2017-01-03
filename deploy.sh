#!/bin/sh
mvn  package -Dmaven.test.skip=true

scp ./target/spring-boot-simple-1.0.0.jar root@188.166.242.162:~/webapps/