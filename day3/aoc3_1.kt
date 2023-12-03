// Author: edwardnvv57k

// Advent of Code 2023, Day 3 - P1

import java.util.Scanner
import kotlin.math.max

fun main (args: Array<String>) {
    val reader = Scanner (System.`in`);
    
    var ans: Int = 0;
    var num: Int = 0;
    var counter: Int = 0;
    var part: Int = 0;
    var a: String? = "a";
    var arr: Array<String?> = arrayOfNulls<String?> (150);
    var vis: Array<IntArray> = Array(200) { IntArray(200) };
    
    for (i in 0 until 200){
        for (j in 0 until 200) vis[i][j] = 0;
    }
    
    while (true){
        arr[counter] = readLine();
        if (arr[counter] == null) break;
        for (i in 0 until (arr[counter]?.length ?: 0)){
            if (arr[counter]?.get(i) ?: '0' >= '0' && arr[counter]?.get(i) ?: '0' <= '9') continue
            else if (arr[counter]?.get(i) == '.') continue;
            else{
                for (k in counter - 1 until counter + 2){
                    for (l in i - 1 until i + 2){
                        if (k >= 0 && l >= 0) vis[k][l] = 1;
                    }
                }
            }
        }
        counter++;
    }
    
    for (i in 0 until counter){
        for (j in 0 until (arr[i]?.length ?: 0)){
            if (arr[i]?.get(j) ?: '0' >= '0' && arr[i]?.get(j) ?: '0' <= '9'){
                num = 10 * num + ((arr[i]?.get(j) ?: '0').toInt() - '0'.toInt());
                if (vis[i][j] == 1) part = 1;
            }
            else{
                if (part == 1) ans += num;
                num = 0;
                part = 0;
            }
        }
        if (part == 1) ans += num;
        num = 0;
        part = 0;
    }
    
    println (ans);
}