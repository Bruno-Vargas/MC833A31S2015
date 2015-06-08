#!/bin/bash

#rm time_*

for count in $(seq 1 50); do
    java -cp src LibraryClient dump 2>>time_dump
done

for count in $(seq 1 50); do
    java -cp src LibraryClient desc 1122334455667 2>>time_desc
done

for count in $(seq 1 50); do
    java -cp src LibraryClient info 1122334455667 2>>time_info
done

for count in $(seq 1 50); do
    java -cp src LibraryClient list 2>>time_list
done

for count in $(seq 1 50); do
    java -cp src LibraryClient update 1122334455667 10 2>>time_update
done

for count in $(seq 1 50); do
    java -cp src LibraryClient count 1122334455667 2>>time_count
done
