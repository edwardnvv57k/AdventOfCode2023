// Author: edwardnvv57k

// Advent of Code 2023, Day 2 - P1

import java.util.Scanner

fun main (args: Array<String>) {
    val reader = Scanner (System.`in`);
    
    var ans: Int = 0;
    var num: Int = 0;
    var col: Int = 0;
    var counter: Int = 1;
    var a: String? = "a";
    
    while (true){
        a = readLine();
        if (a == null) break;
        
        for (i in 0 until a.length - 1){
            num = 0;
            col = 0;
            if ((a[i] == ':' || a[i] == ';' || a[i] == ',') && a[i + 1] == ' '){
                for (j in i + 2 until a.length){
                    if (a[j] == ' '){
                        col = a[j + 1].toInt() - 'a'.toInt();
                        // b - 1, r - 17, g - 6
                        break;
                    }
                    else{
                        num = 10 * num + (a[j].toInt() - '0'.toInt());
                    }
                }
                
                if (col == 17 && num > 12) col = -1;
                else if (col == 6 && num > 13) col = -1;
                else if (col == 1 && num > 14) col = -1;
                
                if (col == -1) break;
            }
        }
        
        if (col != -1) ans += counter;
        counter++;
    }
    
    println (ans);
}