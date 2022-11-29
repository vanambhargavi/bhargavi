package com.axis.app

import com.axis.model.Book
import com.axis.service.BookService
import java.util.Scanner

fun main() {

    var dbConnection = DBConnection()
    var connection = dbConnection.connect()

    var bookService = BookService()

    var scan = Scanner(System.`in`)

    for (i in 1..1) {

        println("Enter the Book $i Details: ")
        print("Enter Book ID: ")
        var bookId: String = scan.next()
        print("Enter Author: ")
        var author: String = scan.next()
        print("Enter the Tittle: ")
        var tittle: String = scan.next()
        print("Enter the Category: ")
        var category: String = scan.next()
        print("Enter the Price: ")
        var price: Float = scan.nextFloat()

        //object creation
        var book = Book(bookId, author, tittle, category, price)
        //function call to ProductService
        bookService.insertBookDetail(book)

    }
    println("---------------------------BOOK MENU------------------------------")
    println("\n1.Add Book\n2.Modify\n3.Delete\n4.Display All Book\n5.Display Specific Book\n6.Search by Author\n7.Search by Tittle\n8.Exit\n")
    println("Enter the choice: ")
    var choice = scan.nextInt()
    while (choice < 9) {
        when (choice) {
            1 -> {
                //adding Book
                print("Enter Book ID: ")
                var bookId: String = scan.next()
                print("Enter Author: ")
                var author: String = scan.next()
                print("Enter the Tittle: ")
                var tittle: String = scan.next()
                print("Enter the Category: ")
                var category: String = scan.next()
                print("Enter the Price: ")
                var price: Float = scan.nextFloat()

                var book = Book(bookId, author, tittle, category, price)
                bookService.insertBookDetail(book)
            }

            2 -> {
                //modify Book
                print("Enter the BookId to modify: ")
                var bookIdUpdate = scan.next()
                print("Enter updated Book Tittle: ")
                var bookTittleUpdate = scan.next()
                bookService.modifyBook(bookIdUpdate, bookTittleUpdate)
            }

            3 -> {
                //delete Book
                print("Enter the Book Id to Delete: ")
                var bookToDelete = scan.next()
                bookService.deleteBook(bookToDelete)
            }

            4 -> {
                //display All Book
                println("----------------------Book Details-------------------------")
                bookService.displayAllBooks()
            }

            5 -> {
                //display Specific Book
                print("Enter the specific BookId: ")
                var specificBook = scan.next()
                bookService.displaySpecificBook(specificBook)
            }

            6 -> {
                //search by author
                print("Enter the Author: ")
                var searchAuthor = scan.next()
                bookService.searchBookByAuthor(searchAuthor)
            }

            7 -> {
                //search by tittle
                print("Enter the Tittle: ")
                var searchTittle = scan.next()
                bookService.searchBookByTittle(searchTittle)
            }

            8 -> {
                //Exit
                println("Program Ended Successfully!!!!....")
                System.exit(0)
            }
        }
    }
}


