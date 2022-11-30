package com.axis.Database


import java.sql.DriverManager

fun main() {

    val myurl = "jdbc:mysql://localhost:3306/kotlindb"
    val connection = DriverManager.getConnection(myurl, "root", "Revathi123@")
    println("connection establish successfully")

    //Update table data
    var updateRes=connection.createStatement().executeUpdate("update user set name='Ganesh' where id=2")
    if( updateRes > 0){
        println("successfully updated record in users db !!!")
    } else{
        println("Update Not sucessful")
    }
}