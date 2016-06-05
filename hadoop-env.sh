#!/bin/sh

echo 'Run `cd $HADOOP_PREFIX` after container starts'
echo 'Visit https://hub.docker.com/r/sequenceiq/hadoop-docker/ for more info'
echo '======================================================================='

docker run -it -v $(pwd):/usr/local/hadoop/workspace --workdir=/usr/local/hadoop sequenceiq/hadoop-docker:2.7.0 /etc/bootstrap.sh -bash
