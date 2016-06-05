#!/bin/sh

if [[ -z $1 ]]; then
	echo "Please specify a file as input!"
	exit 255
fi

wd=$(cd $(dirname $0) && pwd)
target=$(cd $(dirname $1) && pwd)
target_fn=$(basename $1)
ori_dir=$(pwd)

cd $HADOOP_PREFIX
bin/hadoop fs -put "$target/$target_fn" ./
bin/hadoop jar "$wd/Infomation-retrieval-trust-propagation-problem.jar" "$target_fn" "${target_fn}.out"
bin/hadoop fs -get "${target_fn}.out" "$ori_dir"
bin/hadoop fs -rmr "${target_fn}.out"
bin/hadoop fs -rmr "$target_fn"

cd $ori_dir
