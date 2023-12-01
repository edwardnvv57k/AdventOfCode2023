// Author: edwardnvv57k

// Advent of Code 2023, Day 1 - P1

import java.util.Scanner

fun main (args: Array<String>) {
    val reader = Scanner (System.`in`);
    
    var ans: Int = 0;
    var a: String? = "a";
    while (true){
        a = readLine();
        if (a == null) break;
        
        for (i in 0 until a.length){
            if (a[i] in '0'..'9'){
                ans += (a[i].toInt() - '0'.toInt()) * 10;
                break;
            }
        }
        
        for (i in 0 until a.length){
            if (a[a.length - 1 - i] in '0'..'9'){
                ans += a[a.length - 1 - i].toInt() - '0'.toInt();
                break;
            }
        }
        
    }
    
    println (ans);
}
