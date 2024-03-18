package prac4

import java.lang.Math.pow
import kotlin.math.sqrt

fun main() {

    val a = 0.7;
    val b = 0.7;
    val Q = 1050.0;
    val Wn = 0.3;
    val h = 1.3;
    val G = 77;
    val Gp = 16;
    val Lv = 0.3;
    val PDK = 25;
    val Cpp = 16;
    val schema = 3;

    var Llprot: Double = 0.0
    var Um: Double = 0.0
    var Lctp: Double = 0.0

    val A = (a + (0.24 * h)) / 2
    val B = (b + (0.24 * h)) / 2

    val hp = h + b / 0.24
    val R = 1.128 * sqrt(A * B)
    val r = 1.128 * sqrt(a * b)

    if (schema == 1) {
        Llprot = 3 - 2 * R / r;
        Um = 0.0425 * pow((Q / r), 1 / 3.0) * pow((h / r), 1 / 3.0)
        Lctp = ((3.14 * r * r) / 3) * Um

    } else if (schema == 2) {
        Llprot = 3.4 - 2.4 * R / r;
        Um = 0.0425 * pow((Q / r), 1 / 3.0) * pow((h / r), 1 / 3.0)
        Lctp = ((3.14 * r * r) / 3) * Um

    } else if (schema == 3) {
        Llprot = 3.1 - 2.1 * A / a;
        Um = 0.03 * pow(Q, 1 / 3.0) * pow((hp / b), 38 / 100.0)
        Lctp = a * b * Um
    } else println("Не выбрана схема зонта")


    val F1 = 4 * A * B
    val F2 = 3 * a * b

    val Kp = 1 + ((3 - (F1 / F2)) * (Wn / Um))
    val Lprot = Kp * Lctp * Llprot
    val Cpred = G/Lprot + Cpp
    val deltaCpred = (Cpred - Cpp)/(PDK - Cpp)
    val M = (Gp/G) * deltaCpred - Lv/Lprot

    val Kn =

}