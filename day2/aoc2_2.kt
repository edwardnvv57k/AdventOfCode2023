// Author: edwardnvv57k

// Advent of Code 2023, Day 2 - P2

import java.util.Scanner
import kotlin.math.max

fun main (args: Array<String>) {
    val reader = Scanner (System.`in`);
    
    var ans: Int = 0;
    var num: Int = 0;
    var col: Int = 0;
    var r: Int;
    var g: Int;
    var b: Int;
    var value: Int;
    var a: String? = "a";
    
    while (true){
        a = readLine();
        if (a == null) break;
        
        r = 0; g = 0; b = 0;
        
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
                
                if (col == 17) r = max (r, num);
                else if (col == 6) g = max (g, num);
                else if (col == 1) b = max (b, num);
                
            }
        }
        
        value = r * g * b;
        ans += value;
    }
    
    println (ans);
}