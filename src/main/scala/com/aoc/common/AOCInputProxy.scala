package com.aoc.common

import io.Source

class AOCInputProxy(day: Int) {
  def getInputLines: List[String] = LazyList.from(getAllInput.linesIterator).toList
  def getAllInput: String = Source.fromFile("src/main/resources/input/day_%d.txt".format(day)).mkString
  def getTestFile: String = Source.fromFile("src/main/resources/input/test.txt".format(day)).mkString
}

