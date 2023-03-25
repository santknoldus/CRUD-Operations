package com.knoldus.crudoperations

import org.scalatest.funsuite.AnyFunSuite

class ListOperationTest extends AnyFunSuite {

  //for type int
  val listOperationOnInt = new ListOperation[Int]

  test("Create operation using int") {
    assert(listOperationOnInt.create(1) == List(1))
    assert(listOperationOnInt.create(3) == List(1, 3))
  }
  test("Read operation using int") {
    assert(listOperationOnInt.read() == List(1, 3))
  }
  test("Update operation using int") {
    assert(listOperationOnInt.update(2, 0) == List(2, 3))
  }
  test("Delete operation using int") {
    assert(listOperationOnInt.delete(2) == List(3))
    //assert(listOperationOnInt.read() == List(3))
  }

  //for type string
  val listOperationOnString = new ListOperation[String]

  test("Create operation on string") {
    listOperationOnString.create("Sant")
    listOperationOnString.create("Narayan")
    assert(listOperationOnString.create("Singh") == List("Sant", "Narayan", "Singh"))
    //assert(listOperationOnString.read() == List("Sant", "Narayan", "Singh"))
  }
  test("Read operation on string") {
    assert(listOperationOnString.read() == List("Sant", "Narayan", "Singh"))
  }
  test("Update operation on string") {
    assert(listOperationOnString.update("Nara", 1) == List("Sant", "Nara", "Singh"))
    //assert(listOperationOnString.read() == List("Sant", "Nara", "Singh"))
  }
  test("Delete operation on string") {
    assert(listOperationOnString.delete("Nara") == List("Sant", "Singh"))
    //assert(listOperationOnString.read() == List("Sant", "Singh"))
  }
}
