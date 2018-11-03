#!/usr/bin/env bash

# Docker file starts with: FROM mongo:4.0.3
# local image: 317/mongodb:1.0 => remote image: mongo:4.1.3

#setup
# REMOTE_IMAGE=mongo:3.4.3
REMOTE_IMAGE=mongo:4.0.3
LOCAL_IMAGE=317/mongodb:1.0

# delete any existing image with same name
docker rmi $LOCAL_IMAGE

# create new image
docker build --build-arg SOURCE_IMAGE=$REMOTE_IMAGE --no-cache -t $LOCAL_IMAGE .

# delete downloaded remote image, to free disk space
docker rmi $REMOTE_IMAGE

# show all images
docker images
