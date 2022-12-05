package com.sunzw.test.baseTest

import com.sunzw.test.bean.BaseTestbean

fun main() {
    val list= mutableListOf(BaseTestbean("一号",1),BaseTestbean("二号",2))

    val list1=list
    val list2= mutableListOf<BaseTestbean>()
    list2.addAll(list)
    list.add(BaseTestbean("三号",3))
    list.removeAt(1)
    list.add(1,BaseTestbean("二号",5))
    list.forEach {
        println("list:$it")
    }
    list1.forEach {
        println("list1:$it")
    }
    list2.forEach {
        println("list2:$it")
    }
}