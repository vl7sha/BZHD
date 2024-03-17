package prac2

fun main() {

    var X = 0.55;
    var VB = 2.1;
    var trz = 27.0;
    var tnm = 24.0;
    var Crz = 16.5;
    var C0 = 11.0;
    var PDK = 14.5;

    var t0 = tnm - 1;

    println("t0 = ${t0}");

    var Pt = (trz - tnm) / (trz - t0);

    println("Pt = ${Pt}");

    var n3 = 4.5;
    var n4 = 3.4;
    var n5 = 3.1;
    var n = 3.1;

//    var F03 = Math.pow((X + 5.3 * Pt - 3.2) / (0.75 * n3), 2.0);
//    var F04 = Math.pow((X + 5.3 * Pt - 3.2) / (0.75 * n4), 2.0);
    var F05 = Math.pow((X + 5.3 * Pt - 3.2) / (0.75 * n5), 2.0);

    var F0 = 0.36;
    var m = 5.3;

//    println("F03 = ${F03}");
//    println("F04 = ${F04}");
    println("F05 = ${F05}");
    println("F0 = ${F0}");
    println("m = ${m}");

    var v0 = VB / (0.7 + 0.1 * (0.8 + m * Math.sqrt(F0) - X));

    println("v0 = ${v0}");

    var L0 = F0 * v0;

    println("L0 = ${L0}");

    var XHt = 0.6 * n * Math.sqrt(F0);

    println("X = ${X}");

    println("Xht = ${XHt}");

//---------------------------------------------------------------------------------------—
    println("--------------------------------------------------------------------------");

    var Pk = (Crz - PDK) / (Crz - C0);

    println("Pk = ${Pk}");

    var F10 = Math.pow(((X + 3.7 * Pk - 1.5) / (0.75 * n)), 2.0);

    println("F10 = ${F10}");

    v0 = VB / (0.7 + 0.14 * (0.8 + m * Math.sqrt(F0) - X));

    println("v0 = ${v0}");

    var tox = trz - (trz - tnm) / (0.45 + 0.25 * (0.75 * n * Math.sqrt(F0) - X));

    println("tox = ${tox}");
}