// Author: edwardnvv57k

// Advent of Code 2023, Day 1 - P2

import java.util.Scanner

fun main (args: Array<String>) {
    val reader = Scanner (System.`in`);
    
    var ans: Int = 0;
    var token: Int = 0;
    var a: String? = "a";
    var b: String? = "";
    
    var lets: HashMap <String, Int> = HashMap <String, Int> ();
    
    lets.put ("one",  1);   lets.put ("two",  2);   lets.put ("three",  3);
    lets.put ("four",  4);  lets.put ("five",  5);  lets.put ("six",  6);
    lets.put ("seven",  7); lets.put ("eight",  8); lets.put ("nine",  9);
    
    while (true){
        a = readLine();
        if (a == null) break;
        
        for (i in 0 until a.length){
        
            b = "";
            token = 0;
            
            for (j in i until i + 5){
                if ((j >= a.length) || (a[j] in '0'..'9')) break;
                b += a[j];
                if (lets?.get(b) != null){
                    ans += (lets[b] ?: 0) * 10 // why does this work?
                    token = 1;
                    break;
                }
            }
            
            if (token == 1) break;
            
            if (a[i] in '0'..'9'){
                ans += (a[i].toInt() - '0'.toInt()) * 10;
                break;
            }
        }
        
        for (i in 0 until a.length){
            
            b = "";
            token = 0;
            
            for (j in a.length - 1 - i until a.length + 4 - i){
                if ((j >= a.length) || (a[j] in '0'..'9')) break;
                b += a[j];
                if (lets?.get(b) != null){
                    ans += (lets[b] ?: 0) // why does this work?
                    // Elvis Operator or "null coalescing operator"
                    // Kinda like ternary, if !null returns it, else returns right side
                    token = 1;
                    break;
                }
            }
            
            if (token == 1) break;
            
            if (a[a.length - 1 - i] in '0'..'9'){
                ans += a[a.length - 1 - i].toInt() - '0'.toInt();
                break;
            }
        }
        
    }
    
    println (ans);
}
