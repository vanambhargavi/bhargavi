import java.util.Scanner
fun main(args: Array<String>) {
    var productService=ProductService()
    println("=======================================")
    while(true){
        println("1.insert  2.update  3.delete  4.diplayAllRows  5.Exit")
        println("enter value:")
        var sc=Scanner(System.`in`)
        var value=sc.nextInt()
        when(value) {
            1 -> {
                println("Enter values to insert:")
                productService.insertproduct(getvalues("insert"))
            }

            2 -> {
                println("Enter values to update:")
                productService.updateproduct(getvalues("update"))
            }

            3 -> {
                println("Enter id to delete:")
                productService.deleteproduct(getvalues("delete").id)
            }

            4 -> {
                println("==========view all products===========")
                productService.displayallproducts()
                println("=======================================")

            }

            else -> {
                println("===========execution completed===========")
                break
            }
        }
    }

}
fun getvalues(action:String):Product{
    var sc=Scanner(System.`in`)
    println("Id:")
    var id=sc.nextInt()
    if(action=="insert" || action=="update")
    {
        println("name:")
        var name=sc.next()
        println("modal:")
        var modal=sc.next()
        println("price:")
        var price=sc.nextInt()
        return Product(id,name,modal,price)
    }
    else{
        return Product(id,"","",0)
    }

}