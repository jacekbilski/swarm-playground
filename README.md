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

## Swarm

### Preparations

First: install [Docker Engine](https://docs.docker.com/engine/install/).

Then initialize the swarm with simple `docker swarm init`.

We'll also need a temporary image registry, start with `docker service create --name registry --publish published=5000,target=5000 registry:2`

### Building

Same as with pure compose: `docker compose build`. Do make sure that in `docker-compose.yml` images are prefixed with registry address. And no, `localhost` doesn't work.

Before running we need to push the images to the registry with `docker compose push`.

### Deploying

`docker stack deploy --compose-file docker-compose.yml swarm-playground`

To check status: `docker stack services swarm-playground`.
