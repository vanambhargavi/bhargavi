package com.axis.Database

import java.sql.DriverManager
import java.util.Scanner

fun main() {

    val myurl = "jdbc:mysql://localhost:3306/kotlindb"
    val connection = DriverManager.getConnection(myurl, "root", "Vanam123@")
    println("connection establish successfully")
//select query - Read
    println("***Enter id for retrieve data from User Table***")
    var scan=Scanner(System.`in`)
    print("Enter Id: ")
    var id=scan.nextInt()

    val prepare1 = connection.prepareStatement("select * from user where id=(?)")
    prepare1.setInt(1,id)

    val result = prepare1.executeQuery()
    val user = mutableListOf<User>()

    while (result.next()) {
        val id = result.getInt("id")
        val name = result.getString("name")
        user.add(User(id, name))
    }
    for (user in user){
        println(user)
    }
}
