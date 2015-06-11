#!/bin/bash
# Memory Limit Exceeded
row=`head file.txt -n1 | grep -o " " | wc -l`
let row=row+1
for i in `seq $row`;do
    awk -vrow_line=$i '{print $row_line}' file.txt | sed ':a N;s/\n/ /g;ta'
done
