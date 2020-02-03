package com.aoc.day2

import com.aoc.common.AOCInputProxy

object Day2Solution extends App {

  val inputHandler = new AOCInputProxy(2)
  val input = inputHandler.getAllInput.split(",").map(value => value.toInt)
  val out = Program.runProgram(input, 12, 2)
  println(out)

  val requiredOut = 19690720

  val allPairs = for {
    x <- 0 to 100
    y <- 0 to 100
  } yield (x, y)

  val requiredIn = allPairs.find(pair => {
    val output = Program.runProgram(input, pair._1, pair._2)
    output == requiredOut
  }).get

  println(requiredIn._1 * 100 + requiredIn._2)
}
