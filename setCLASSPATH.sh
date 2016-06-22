#!/bin/csh
setenv OpenORB jars/lib
setenv CLASSPATH "."
foreach i (`ls $OpenORB/*.jar`)
    setenv CLASSPATH "$CLASSPATH":$i
end
setenv CLASSPATH $CLASSPATH
