FROM azul/zulu-openjdk:17 as builder

ARG SKIP_UNIT_TESTS_ON_BUILD=true
RUN mkdir build
COPY ../../ /build
WORKDIR /build
RUN ./mvnw install -Dmaven.test.skip=${SKIP_UNIT_TESTS_ON_BUILD} -Djib.skip


FROM azul/zulu-openjdk-alpine:17-jre-headless

RUN mkdir /app
WORKDIR /app
COPY --from=builder /build/packages/backend/target/*.jar ./app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]