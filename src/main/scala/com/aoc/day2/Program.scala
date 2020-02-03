package com.aoc.day2

object Program {
  def nextInstruction(array: Array[Int], arg: Int): Array[Int] = {
    val operation = array(arg)
    operation match {
      case 1 => nextInstruction(performOperation(array, arg, (x: Int, y: Int) => x + y), arg + 4)
      case 2 => nextInstruction(performOperation(array, arg, (x: Int, y: Int) => x * y), arg + 4)
      case 99 => array
    }
  }

  def performOperation(array: Array[Int], index: Int, func: (Int, Int) => Int): Array[Int] = {
    val arg1 = array(array(index + 1))
    val arg2 = array(array(index + 2))
    val position = array(index + 3)
    array.updated(position, func.apply(arg1, arg2))
  }

  def runProgram(input: Array[Int], noun: Int, verb: Int):Int = {
    val programInput = input.updated(1, noun).updated(2, verb)
    nextInstruction(programInput, 0)(0)
  }
}
