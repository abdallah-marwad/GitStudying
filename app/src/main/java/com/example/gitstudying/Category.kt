package com.example.gitstudying

data class Category(
//    @PrimaryKey(autoGenerate = true)
    var id : Int = 0,
    var categoryName : String ? = null,
    var image:String? = null,
    var isSelected : Boolean = false
)
