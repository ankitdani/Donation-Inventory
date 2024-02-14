#!/bin/bash

# Step 1: Build the Docker image
docker build . -t inventoryv3application:latest

# Step 2: Run the Docker container
docker run -d -p 8080:8080 inventoryv3application:latest
