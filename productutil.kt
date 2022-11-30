class productutil {

    var dbcon=DbConnection()
    var connection=dbcon.connect()
    fun insertdata(products:Product){
        var stmt=connection.prepareStatement("insert into product values(?,?,?,?);")
        stmt.setInt(1,products.id)
        stmt.setString(2,products.name)
        stmt.setString(3,products.modal)
        stmt.setInt(4,products.price)
        var res=stmt.executeUpdate()
        if(res>0){
            println("${res} rows inserted")
        }
    }
    fun deletedata(id:Int){
        var stmt=connection.prepareStatement("delete from product where id = ?;")
        stmt.setInt(1,id)
        var res=stmt.executeUpdate()
        if(res>0){
            println("${res} rows deleted")
        }
    }
    fun updatedata(products:Product){
        var stmt=connection.prepareStatement("update product set name = ?,model=?, price=? where id = ?;")
        stmt.setString(1,products.name)
        stmt.setString(2,products.modal)
        stmt.setInt(3,products.price)
        stmt.setInt(4,products.id)
        var res=stmt.executeUpdate()
        if(res>0){
            println("${res} rows updated")
        }
    }
    fun displaydata(){
        var allproducts= mutableListOf<Product>()
        var stmt=connection.createStatement()
        var result=stmt.executeQuery("select * from product; ")
        while(result.next()){
            val id = result.getInt("id")
            val name = result.getString("name")
            val model = result.getString("model")
            val price = result.getInt("price")
            allproducts.add(Product(id,name,model,price))
        }
        println("id    name    model      price")
        for(product in allproducts){
            println("${product.id}    ${product.name}      ${product.modal}      ${product.price}")
        }
    }
}