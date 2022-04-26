#!/bin/bash

set -ev
if [ "$TRAVIS_OS_NAME" == "osx" ]; then
	if [ "${TRAVIS_PULL_REQUEST}" != "false" ]; then
		echo "Build on MacOSX: Pull Request"
		mvn -f org.example.parent/pom.xml clean verify -Pall
		
	else
		echo "Skipping build on MacOSX for standard commit"		
	fi
  
else
	echo "Build on Linux"
	mvn -f org.example.parent/pom.xml clean verify -Pall
fi 
