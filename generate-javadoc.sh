#!/bin/bash
# Script to generate JavaDoc documentation
# Usage: ./generate-javadoc.sh

mkdir -p docs
javadoc -d docs -sourcepath src -subpackages . -author -version src/*.java
echo "JavaDoc documentation generated in docs/ directory"
