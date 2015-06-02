#!/bin/bash
while read -a line ;do
    for ((i=0; i<${#line[@]}; ++i));do
        if [[ "T${result[$i]}T" == "TT" ]];then
            result[$i]=${line[$i]};
        else
            result[$i]=${result[$i]}" "${line[$i]};
        fi
    done
done<file.txt

for ((i=0; i<${#result[@]}; ++i));do
    echo "${result[$i]}";
done
