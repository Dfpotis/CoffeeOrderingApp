package com.potis.honorsmobileapps.coffeeorderingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    var quantity:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val plus=findViewById<Button>(R.id.plus)
        plus.setOnClickListener{updateQuantity(1) }
        val minus=findViewById<Button>(R.id.minus)
        minus.setOnClickListener{ updateQuantity(-1)}
        val order=findViewById<Button>(R.id.order)
        order.setOnClickListener{
            submitOrder()
        }
    }
    fun updateQuantity(value: Int){
        if(quantity<2&&value<0)
            Toast.makeText(this, R.string.warning, Toast.LENGTH_SHORT).show()
        else if(quantity>9&&value>0)
            Toast.makeText(this, R.string.warning2, Toast.LENGTH_SHORT).show()
        else
            quantity+=value
        val numbers=findViewById<TextView>(R.id.num)
        numbers.text = quantity.toString()

    }
    fun submitOrder(){
        val name=findViewById<EditText>(R.id.name)
        val info=findViewById<TextView>(R.id.total)
        val cream=findViewById<CheckBox>(R.id.whippedCream)
        val choc=findViewById<CheckBox>(R.id.choclate)
        var total=quantity*5
        val names=name.text
        var order="Thanks, $names!"
        if(quantity==1)
            order+="\n$quantity Coffee"
        else
            order+="\n$quantity Coffees"
            if(choc.isChecked&& cream.isChecked) {
                total += quantity * 3
                order += "\n+Whipped Cream\n+Chocolate"
            }
            else if (choc.isChecked) {
                total+=quantity*2
                order+="\n+Chocolate"
            }
            else if(cream.isChecked) {
                total+=quantity
                order+="\n+Whipped Cream"
            }
            order+="\nTotal:$$total.00"
        info.text=order

    }
}