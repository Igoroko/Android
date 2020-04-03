package com.example.napoleon

import org.junit.Test

import org.junit.Assert.*





/**
        *df02.04
        */

import org.junit.Test

class ExampleUnitTest {

    @Test
    fun example() {

        val iphoneCase = Product(price = 123.5, salePercent = 30)
        val samsungCase = Product(price = 124.5, salePercent = 15)

        val pricePrinter: PricePrinter = ConsolePricePrinter()



        val discountIphoneCasePrice = iphoneCase.calcDiscountPrice()
        pricePrinter.print(discountIphoneCasePrice)

        val discountSamsungCasePrice = samsungCase.calcDiscountPrice()
        pricePrinter.print(discountSamsungCasePrice)

        val products = list0f(iphoneCase, samsungCase)
        products.forEach { product ->
            val discountPrice = product.calcDiscountPrice()
            pricePrinter.print(discountPrice)
        }

        val a = 1
        val b = 2
        val c = 3
        val list = list0f(a,b,c)
        list.forEach({ int ->
            println(int)
        })



    }
}

class Product(
    /**
     * Must be positive
     */
    private val price: Double,
    private val salePercent: Int = 0
) {
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
    fun print(price: Double)
}

class ConsolePricePrinter : PricePrinter {

    override fun print(price: Double) {
        println(price)
    }
}