package com.knoldus.crudoperations

import org.scalatest.funsuite.AnyFunSuite

class ListOperationTest extends AnyFunSuite {

  //for type int
  val listOperationOnInt = new ListOperation[Int]

  test("Create operation using int") {
    listOperationOnInt.create(1)
    listOperationOnInt.create(3)
    assert(listOperationOnInt.read() == List(1, 3))
  }
  test("Read operation using int") {
    assert(listOperationOnInt.read() == List(1, 3))
  }
  test("Update operation using int") {
    listOperationOnInt.update(2, 0)
    assert(listOperationOnInt.read() == List(2, 3))
  }
  test("Delete operation using int") {
    listOperationOnInt.delete(2)
    assert(listOperationOnInt.read() == List(3))
  }

  //for type string
  val listOperationOnString = new ListOperation[String]

  test("Create operation on string") {
    listOperationOnString.create("Sant")
    listOperationOnString.create("Narayan")
    listOperationOnString.create("Singh")
    assert(listOperationOnString.read() == List("Sant", "Narayan", "Singh"))
  }
  test("Read operation on string") {
    assert(listOperationOnString.read() == List("Sant", "Narayan", "Singh"))
  }
  test("Update operation on string") {
    listOperationOnString.update("Nara", 1)
    assert(listOperationOnString.read() == List("Sant", "Nara", "Singh"))
  }
  test("Delete operation on string") {
    listOperationOnString.delete("Nara")
    assert(listOperationOnString.read() == List("Sant", "Singh"))
  }
}
