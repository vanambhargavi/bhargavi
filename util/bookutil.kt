package com.axis.util

import com.axis.app.DBConnection
import com.axis.model.Book

class BookUtil {

    var dbConnection=DBConnection()
    var connection=dbConnection.connect()

    fun insertBookInput(book:Book):Int{

        val preparestmt=connection.prepareStatement("insert into Book values(?,?,?,?,?)")
        preparestmt.setString(1,book.bookId)
        preparestmt.setString(2,book.author)
        preparestmt.setString(3,book.tittle)
        preparestmt.setString(4,book.category)
        preparestmt.setFloat(5,book.price)

        val row = preparestmt.executeUpdate()

        return row

    }

    fun selectAllBook() {
        var books = mutableListOf<Book>()
        val query = connection.prepareStatement("select * from Book")
        val result = query.executeQuery()

        while (result.next()) {
            val bookId = result.getString("bookId")
            val author = result.getString("author")
            val tittle = result.getString("tittle")
            val category = result.getString("category")
            val price = result.getFloat("price")


            books.add(Book(bookId, author, tittle, category, price))
        }

        for (book in books) {
            println(book)
        }
    }

    fun modify(bookId:String,tittle:String):Int{


        var preparestmt = connection.prepareStatement("update Book set tittle=? where bookId=?")
        preparestmt.setString(1,tittle)
        preparestmt.setString(2,bookId)

        var row=preparestmt.executeUpdate()

        return row
    }

    fun delete(bookId:String):Int{

        val preparestmt=connection.prepareStatement("delete from Book where bookId=?")
        preparestmt.setString(1,bookId)
        var row=preparestmt.executeUpdate()
        return row
    }

    fun searchByTittle(tittle: String){
        var books= mutableListOf<Book>()
        val query=connection.prepareStatement("select * from Book where tittle=?")
        val result=query.executeQuery()
        while (result.next()){
            val bookId=result.getString("bookId")
            val author=result.getString("author")
            val tittle=result.getString("tittle")
            val category=result.getString("category")
            val price=result.getFloat("price")

            books.add(Book(bookId,author,tittle,category,price))
        }
        for (book in books){
            println(book)
        }


    }

    fun searchByAuthor(author:String){

        var books= mutableListOf<Book>()
        val query=connection.prepareStatement("select * from Book where tittle=?")
        val result=query.executeQuery()
        while (result.next()){
            val bookId=result.getString("bookId")
            val author=result.getString("author")
            val tittle=result.getString("tittle")
            val category=result.getString("category")
            val price=result.getFloat("price")

            books.add(Book(bookId,author,tittle,category,price))
        }
        for (book in books){
            println(book)
        }
    }

    fun displayById(bookId: String){

        var books= mutableListOf<Book>()
        val query=connection.prepareStatement("select * from Book where tittle=?")
        val result=query.executeQuery()
        while (result.next()){
            val bookId=result.getString("bookId")
            val author=result.getString("author")
            val tittle=result.getString("tittle")
            val category=result.getString("category")
            val price=result.getFloat("price")

            books.add(Book(bookId,author,tittle,category,price))
        }
        for (book in books){
            println(book)
        }
    }
}