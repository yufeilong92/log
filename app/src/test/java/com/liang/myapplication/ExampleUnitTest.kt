package com.liang.myapplication

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    @Test
    fun text(){
         val list= mutableListOf<A>()
        list.add(A("1111"))
        list.add(A("2222"))
        list.add(A("3333"))
        list.add(A("4444"))
        list.add(A("5555"))
       for ((item ,index) in list.withIndex()){
          println("$item $index")
       }

        val lists= mutableListOf<String>()
        lists.add("a")
        lists.add("b")
        lists.add("c")
        lists.add("d")
        lists.add("e")
        for ((item ,index) in lists.withIndex()){
            println("$item $index")
        }

        print(getString("a"))


    }

    fun getString(com:String):String=when(com){
         "a"->{"a"}
         "b"->{"b"}
        else->{""}
    }

    data class A(
        val name:String=""
    )

}