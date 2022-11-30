package com.axis.Database


import java.sql.DriverManager

fun main() {

    val myurl = "jdbc:mysql://localhost:3306/kotlindb"
    val connection = DriverManager.getConnection(myurl, "root", "Vanam123@")
    println("connection establish successfully")

    //Delete table data
    val stmt = connection.createStatement()
    var res=stmt.executeUpdate("delete from user where id=2")
    if (res > 0) {
        println("successfully updated record in users db !!!")
    } else {
        println("Update Not sucessful")
    }