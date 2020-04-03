package com.example.napoleonapplication

import org.junit.Test

class ExampleUnitTest {

    @Test
    fun example() {

        val iphoneCase = Product(price = 125.0, salePercent = 30)
        val samsungCase = Product(price = 150.0, salePercent = 5)

        val pricePrinter: PricePrinter = CleanKotlinPriceFormatt()

        val discountIphoneCasePrice: Double = iphoneCase.calcDiscountPrice()
        val discountSamsungCasePrice: Double = samsungCase.calcDiscountPrice()

        val formattedIphonePrice = pricePrinter.format(discountIphoneCasePrice)
        val formattedSamsungCasePrice = pricePrinter.format(discountSamsungCasePrice)

        println("Iphone Case: $formattedIphonePrice")
        println("Samsung Case: $formattedSamsungCasePrice")
    }
}



class Product(
    /**
     * Must be positive
     */
    private val price: Double,
    private val salePercent: Int = 0)
{
    /**
     * @return price with applied discount determined by [salePercent]
     *
     * If [salePercent] is more than 100 than product will have negative price
     * If [salePercent] less than 0 product price will be increased
     */
    fun calcDiscountPrice(): Double = price * (1 - salePercent / 100.0)
}

interface PricePrinter {

    /**
     * Outputs price in <PRICE>P format.
     * If price have not fractional part than it will be printed as integer
     * If price have fractional part than it will be rounded for 2 symbols after "."
     */
    fun format(price: Double): String

}

class CleanKotlinPriceFormatt : PricePrinter{
    override fun format(price: Double): String {
        if (Math.floor(price)==price){
            return String.format("%.0f"+"р", price)
        }
        else{
            return String.format("%.2f"+"р", price)
        }

    }

}