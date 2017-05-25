#!/bin/bash

pn=`ps -ef|grep "jar Backend-1.0.jar"|grep -v "grep"|awk '{print $2}'`
if [ -n "$pn" ];then
echo "killing Backend process,excute kill -9 $pn"

kill -9 $pn

fi
