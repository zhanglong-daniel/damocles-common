#!/bin/bash

gradle clean

gradle assembleRelease

rm -rf ./output/
mkdir output
cp ./library/build/intermediates/bundles/default/classes.jar ./output/
time=`date +%Y%m%d%H%M%S`
mv ./output/classes.jar ./output/damocles-common-$time.jar
ls -l ./output/