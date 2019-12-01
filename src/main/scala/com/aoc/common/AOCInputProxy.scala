package com.aoc.common

import io.Source

class AOCInputProxy(day: Int) {
  def getInputLines: LazyList[String] = LazyList.from(getAllInput.linesIterator)
  def getAllInput: String = Source.fromFile("src/main/resources/input/day_%d.txt".format(day)).mkString
}

