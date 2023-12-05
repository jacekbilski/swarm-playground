# Why?

As k8s seem complex (see [k8s-playground](https://github.com/jacekbilski/k8s-playground)), switching to a simpler alternative - Docker Swarm. Goal stays the same - get a feeling what that is, what it can do and some basics of using it.

## Application

### Docker images

Nothing fancy, just build and run.

#### Backend

```shell
docker build -t swarm-playground-backend backend
docker run --rm -p 7070:8080 swarm-playground-backend
```

#### Web

```shell
docker build -t swarm-playground-web web
docker run --rm -p 8080:8080 swarm-playground-web
```

### Docker compose

Nothing more complex than `docker compose build`.

Then run with `docker compose up -d`.
