package prac5

import java.awt.List
import java.lang.Math.pow
import kotlin.math.sqrt
import kotlin.time.times

fun main() {
    print("Габаритная мощность PГ =")
    val powerGap = readln().toDouble() * 1000
    print("Длина сети l =")
    val L = readln().toDouble()
    println("Фазное напряжение Uф =")
    val faz = readln().toDouble()
    print(
        """
        Схема соединения: 
            1 - треугольник-звезда; 
            2 - звезда-звезда
    """.trimIndent()
    )
    println()
    val schema = readln().toInt()
    print(
        """
        Вид защиты:
            1 - для плавкой вставки;
            2 - для автомата защиты приPГ < 100кВА;
            3 - для автомата защиты приPГ ≥ 100кВА;
    """.trimIndent()
    )
    println()
    val guard = readln().toInt()
    println(
        """
        Тип линии:
            1 - для воздушной линии
            2 - для кабельных линий
    """.trimIndent()
    )
    val typeLine = readln().toInt()
    println("Допустимая плотность тока: Кг = ")
    val Kg = readln().toDouble()


    val P1 = if (schema == 1) {
        powerGap / 3
    } else {
        powerGap / 4
    }

    val k: Number = if (guard == 1) {
        3.0
    } else if (guard == 2) {
        1.4
    } else if (guard == 3) {
        1.25
    } else 0

    if (k.toDouble() < 0 || k.toDouble() > 2) {
        println("не выбран тип защиты")
        return
    }

    val Ih = P1 / faz
    val Ikz = k.toDouble() * Ih
    val Sf = Ih / Kg
    val Siz = Sf / 2

    var A: Double = 0.0
    var B: Double = 0.0

    if (schema == 1) {
        A = 77.95 * 1000
        B = 0.0648 * 1000
    }
    if (schema == 2) {
        A = 22.54 * 1000
        B = -0.1176 * 1000
    }
    var Xlp: Double = 0.0;
    if (typeLine == 1) Xlp = 0.4
    if (typeLine == 2) Xlp = 0.07

    val alpha = pow((faz / 230), 2.0)
    val p = pow(10.0, 6.0)
    val l = 1.75 * pow(10.0, -8.0)

    val Rf = p * l / Sf
    val Riz = p * l / Siz


    val Zt = A * alpha / (powerGap + B)
    val Xp = Xlp * L * 1 * pow(10.0, -3.0)
    val Zp = sqrt(
        pow(Rf + Riz,2.0)+ pow(Xp+ 0.0152 + 0.0152, 2.0)
    )

    val Ikef = faz/(Zt/3 + Zp)

    if (Ikef > Ikz) print("Win")

}