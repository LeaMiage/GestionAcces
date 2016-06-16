#!/bin/bash

for cmds in "`cat $1.txt`"
do
    if [ "$cmds" != '' ]; then
        start "`$cmds`"
    fi
done
