// Author: edwardnvv57k

// Advent of Code 2023, Day 4 - P1

import java.util.Scanner
import kotlin.math.max
import java.util.Vector

fun main (args: Array<String>) {
    val reader = Scanner (System.`in`);
    
    var ans: Int = 1;
    var num: Int = 0;
    var token: Int = 0;
    var line: Int = 0;
    var a: String? = "a";
    var times = Vector<Int>();
    var dists = Vector<Int>();
    
    
    while (true){
        a = readLine();
        if (a == null) break;
        token = 0;
        for (i in 0 until a.length){
            if (a[i] == ':') token = 1;
            if (a[i] >= '0' && a[i] <= '9'){
                num = num * 10 + (a[i].toInt() - '0'.toInt());
            }
            else{
                if (num > 0){
                    if (line == 0) times.addElement (num);
                    else dists.addElement (num);
                }
                num = 0;
            }
        }
        if (num > 0){
            if (line == 0) times.addElement (num);
            else dists.addElement (num);
            num = 0;
        }
        line++;
    }
    
    for (i in 0 until times.size){
        num = 0;
        for (j in 0 .. times[i]){
            if ((times[i] - j) * j > dists[i]) num++;
        }
        ans *= num;
    }
    
    println (ans);
}