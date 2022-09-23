package com.sunzw.test

fun main() {
    /**
     * ?:
     */
//    var s:String?="444444"
//    println(s?:"2")
    /**
     * 运算符重载
     */
//    val a = A(2)
//    val b = A(3)
//    println(a + b)

}

class A(age: Int) {
    var age1 = age
    operator fun plus(a: A): Int {
        return age1 + a.age1
    }
}



