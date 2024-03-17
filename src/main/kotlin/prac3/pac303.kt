package prac3

import kotlin.math.exp
import kotlin.math.log10
import kotlin.math.pow
import kotlin.math.sqrt

// Метал
fun main() {

    var b = 3.0;
    var l = 2.0;
    var x = 2.0;
    var m = 7.0 / 1000.0;
    var d = 0.5 / 1000.0
    var Lw = 0.1;
    val N = 4;
    val p = 2.81e-8;

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
        var yy = 0.03* sqrt(i * p)
        val Gamma = Math.pow((1 - 3.14 * (m / i)), 6.0) * Math.pow((i / R), 1.0 / 3.0);

        val Y1 = Gamma * sqrt((yy/p) * Ze) * exp(2 * 3.14 * d / m)
        val Y2 = Gamma * sqrt((yy/p) * Zh) * exp(2 * 3.14 * d / m)

        println("""
            
            beta = $beta    x = $xx
            A = $A          B = $B
            Ze = $Ze        Zh = $Zh
            Gamma = $Gamma  yy = $yy
            YYe = ${20 * log10(Y2)}       YYh = ${20 * log10(Y1)}  
            
        """.trimIndent())

        println("-----------------------------------------------------------")
    }
}