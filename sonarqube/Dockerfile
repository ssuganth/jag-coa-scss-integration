#############################################################################################
###              Stage where Docker is building curl container to setup SonarQube         ###
#############################################################################################
FROM alpine:3.13.6 as build

RUN apk add --no-cache curl bash coreutils sed postgresql-client jq

ENV PATH $PATH:/usr/bin

COPY . .

# Remove non-unix newline character
RUN sed -i 's/\r//g' init.sh

ENTRYPOINT ["/bin/bash", "init.sh"]
#############################################################################################
