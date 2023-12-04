// Author: edwardnvv57k

// Advent of Code 2023, Day 4 - P1

import java.util.Scanner
import kotlin.math.max

fun main (args: Array<String>) {
    val reader = Scanner (System.`in`);
    
    var ans: Int = 0;
    var num: Int = 0;
    var token: Int = 0;
    var cardscore: Int = 0;
    var a: String? = "a";
    var occ: HashMap <Int, Int> = HashMap <Int, Int> ();
    
    
    while (true){
        a = readLine();
        if (a == null) break;
        cardscore = 0;
        token = 0;
        for (i in 0 until a.length){
            if (a[i] == ':') token = 1;
            else if (token == 1){
                if (a[i] <= '9' && a[i] >= '0') num = num * 10 + (a[i].toInt() - '0'.toInt());
                else if (a[i] == ' '){
                    if (num > 0) occ.put (num, 1);
                    num = 0;
                }
                else{
                    token = 2;
                }
            }
            else if (token == 2){
                if (a[i] <= '9' && a[i] >= '0') num = num * 10 + (a[i].toInt() - '0'.toInt());
                if (a[i] == ' ' || i == a.length - 1){
                    if (num > 0 && occ.containsKey(num)){
                        if (cardscore == 0) cardscore++;
                        else cardscore *= 2;
                    }
                    num = 0;
                }
            }
        }
        ans += cardscore;
        occ.clear();
    }
    
    println (ans);
}