#!/bin/bash

for cmds in "`cat jars/$1.txt`"
do
    if [ "$cmds" != '' ]; then
        $cmds &
    fi
done
