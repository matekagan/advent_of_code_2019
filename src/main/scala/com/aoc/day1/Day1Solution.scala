package com.aoc.day1

import com.aoc.common.AOCInputProxy

class Day1Solution {
  def calculateValue: Int => Int = (value: Int) => {
     val result = (value / 3) - 2
     if (result > 0) result else 0
  }

  def calculateFuelForFuel: Int => Int = (mass: Int) => {
    val result = (mass / 3) - 2
    if (result <= 0) 0 else result + calculateFuelForFuel(result)
  }

  def calculate(stream: List[String], mapping: Int => Int) : Int = {
    val sum = (x: Int, y : Int) => x + y
    stream.map(value => value.toInt)
      .map(mapping)
      .reduce(sum)
  }

  def solution(): Unit = {
    val inputHandler = new AOCInputProxy(1)
    val input = inputHandler.getInputLines
    val sum1 = calculate(input, this.calculateValue(_))
    val sum2 = calculate(input, this.calculateFuelForFuel(_))
    println("basic sum: %d".format(sum1))
    println("sum with fuel: %d".format(sum2))
  }
}
