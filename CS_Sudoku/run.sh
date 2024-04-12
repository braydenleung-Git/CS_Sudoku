#!/bin/bash

for file in *.jar; do
    java -jar "$file"
done
