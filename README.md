# ReactiveMongoDemo
A Spring Boot app connecting to Mongo in a reactive way


- start the mongodb docker-compose app (on macOs or linux)
  make sure there is a folder named: ~/Infra/db/mongodb/data
  cd into $PROJECT_HOME/docker/stages/317
  docker-compose up &

- start the non reactive mongo client (spring profile = local)

- post a tweet to it
  - http://localhost:9080/mongo-client/api/tweet/save
  - http-method: post
  - header:"Content-Type" = "application/json"
  - body: { "text": "test-message" }

- start the reactive client (also spring profile = local)

- use chrome browser to follow tweets
  - http://localhost:9081/reactive-mongo-client/reactive-api/stream/tweets
