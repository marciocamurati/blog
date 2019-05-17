# golang base image
FROM golang:1.12.5

LABEL MAINTAINER="saikris12@gmail.com"

# WorkDir inside the container. Creates one if does not exist already
WORKDIR $GOPATH/src/print-go

# Copy the go project on to the container
COPY print/ .

# Download depdendencies
RUN go get -d -v ./...

# Install the go package
RUN go install -v ./...

# This container exposes port 8817 to the outside world
EXPOSE 8817

# This variable is required in the go routine
ENV PORT=8817

# Run the executable
CMD ["print-go"]
