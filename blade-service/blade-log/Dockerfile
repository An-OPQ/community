FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER liuxian0728@foxmail.com

RUN mkdir -p /blade/log

WORKDIR /blade/log

EXPOSE 8103

ADD ./target/blade-log.jar ./app.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]

CMD ["--spring.profiles.active=test"]
