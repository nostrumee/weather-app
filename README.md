# Cadence Weather Info application
## How to run it
Run Cadence Server Using Docker Compose
```sh
curl -O https://raw.githubusercontent.com/uber/cadence/master/docker/docker-compose.yml
docker-compose up
```

Register a Domain Using the CLI

```sh
docker run --network=host --rm ubercadence/cli:master --do weather-app domain register -rd 1
```

Run a Spring Boot application locally and make an HTTP request with the name of the city to get weather information
```sh
curl -X GET http://localhost:8080/info?city=Minsk
```

Application uses MySQL database.
