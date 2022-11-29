package com.axis.app


import java.sql.Connection
import java.sql.DriverManager

class DBConnection {

    fun connect(): Connection {
        val myurl = "jdbc:mysql://localhost:3306/mysqldb"
        val connection = DriverManager.getConnection(myurl, "root", "Vanam123@")

        return connection
    }
}