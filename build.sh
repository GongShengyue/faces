#!/bin/bash
echo "build start"
JAR_PATH=lib

#生成依赖的jar包 列表
for file in ${JAR_PATH}/*.jar;
do
jarfile=${jarfile}:${file}
done
echo "jarfile= "$jarfile

#编译
java -cp target/classes:$jarfile test