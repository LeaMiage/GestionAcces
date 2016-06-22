#!/bin/csh
echo "Setting CLASSPATH"
source ./setCLASSPATH.sh
echo $CLASSPATH
echo "Starting Naming Service ...."
java -Dorg.omg.CORBA.ORBClass=org.openorb.CORBA.ORB org.openorb.util.MapNamingContext -ORBPort=2001 -print
