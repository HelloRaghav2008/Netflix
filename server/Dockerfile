FROM gradle:9.8.2-jdk25 AS build
WORKDIR /workspace
COPY . .
RUN gradle :server:installDist --no-daemon

FROM eclipse-temurin:25-jre
WORKDIR /app
COPY --from=build /workspace/server/build/install/server/ ./
EXPOSE 8080
ENTRYPOINT ["bin/server"]
