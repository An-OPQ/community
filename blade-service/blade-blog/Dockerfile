FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER liuxian0728@foxmail.com

RUN mkdir -p /blade/blog

WORKDIR /blade/blog

EXPOSE 8803

ADD ./target/blade-blog.jar ./app.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]

CMD ["--spring.profiles.active=dev"]
