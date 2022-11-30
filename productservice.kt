import product.ProductUtil

class productService {
}
    var dbcon=DbConnection()
    var productutil= ProductUtil()
    fun insertproduct(product: Product){
        productUtil.insertdata(product)
    }
    fun deleteproduct(id:Int){
        productUtil.deletedata(id)
    }
    fun updateproduct(product: Product){
        productutil.updatedata(product)
    }
    fun displayallproducts(){
        productutil.displaydata()
    }
}