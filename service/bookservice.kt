package com.axis.service

import com.axis.model.Book
import com.axis.util.BookUtil

class BookService {

    var bookUtil=BookUtil()


    fun insertBookDetail(book: Book){
        var records=bookUtil.insertBookInput(book)
        if (records>0) println("$records rows inserted successfully")
        else println("record not found")
    }

    fun displayAllBooks(){
        var bookResult = bookUtil.selectAllBook()
        println("$bookResult")
    }

    fun modifyBook(bookId:String,tittle:String){
        var records=bookUtil.modify(bookId,tittle)
        if (records>0) println("$records rows updated successfully")
        else println("record not found")
    }

    fun deleteBook(bookId:String){
        var records=bookUtil.delete(bookId)
        if (records>0) println("$records rows deleted successfully")
        else println("record not found")
    }

    fun searchBookByAuthor(author:String){
        var records=bookUtil.searchByAuthor(author)
        println("$records")
    }

    fun searchBookByTittle(tittle: String){
        var records=bookUtil.searchByTittle(tittle)
        println("$records")
    }

    fun displaySpecificBook(bookId: String){
        var bookResult=bookUtil.displayById(bookId)
        println("$bookResult")
    }
}