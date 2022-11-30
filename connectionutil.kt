package com.axis.Database

import java.util.Scanner

import java.sql.DriverManager

fun main() {

    val myurl = "jdbc:mysql://localhost:3306/kotlindb"
    val connection = DriverManager.getConnection(myurl, "root", "Revathi123@")
    println("connection establish successfully")

    //Preparestatement example
    println("***Enter values for insert into User Table***")
    var scan=Scanner(System.`in`)
    print("Enter Id: ")
    var id=scan.nextInt()
    print("Enter Name: ")
    var name=scan.next()

    val preparestmt=connection.prepareStatement("insert into user values (?,?)")
    preparestmt.setInt(1,id)
    preparestmt.setString(2,name)

    val res=preparestmt.executeUpdate()
    if(res>0){
        println("successfully Insert record in users db !!!")
    } else {
        println("Insert Not sucessful")
    }
}