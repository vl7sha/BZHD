package prac3

import java.lang.Math.pow
import kotlin.math.log10
import kotlin.math.pow
import kotlin.math.sqrt

// Краса
fun main() {

    var b = 1.2;
    var l = 3.6;
    var x = 3.0;
    var m = 2.0 / 1000.0;
    var Rk = 3.2;
    var Lw = 0.2;
    val N = 4;


    val sumblx = b * l * x;
    val R = 0.62 * sumblx.pow((1.0 / 3.0))

    println("sumblx = $sumblx")
    println("R = $R")

    val list: ArrayList<Double> = ArrayList<Double>();

    for (i in 0..N) {
        list.add(
            Lw * 10.0.pow(i.toDouble())
        )
    }

    println("l = $list")

    val Z0 = 150.0 * 3.14;

    for (i in list){
        println("-----------------------------------------------------------")
        println("i = ${i}")
        val beta = (2*3.14)/i;
        val xx = R * beta;
        val B = 1 + xx.pow(2)
        val A = sqrt(
            (1 + xx.pow(6)) / xx.pow(2)
        )

        val Zh = Z0 * B/A;
        val Ze = Z0 * A/B;

        val Gamma = pow((1 - 3.14 * (m/i)), 6.0) * pow((i/R), 1.0/3.0);

        val Y1 = Gamma * 1.25 * 3.14 * sqrt(b * Zh/Rk)
        val Y2 = Gamma * 1.25 * 3.14 * sqrt(b * Ze/Rk)

        println("""
            
            beta = $beta    x = $xx
            A = $A          B = $B
            Ze = $Ze        Zh = $Zh
            Gamma = $Gamma
            YYe = ${20 * log10(Y2)}       YYh = ${20 * log10(Y1)}  
            
        """.trimIndent())

        println("-----------------------------------------------------------")
    }
}
