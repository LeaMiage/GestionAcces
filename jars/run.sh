#!/bin/bash

for cmds in "`cat $1.txt`"
do
    if [ "$cmds" != '' ]; then
        osascript -e "tell app \"terminal\"" -e "do script\"cd $(pwd); $cmds\"" -e "end tell"
    fi
done
