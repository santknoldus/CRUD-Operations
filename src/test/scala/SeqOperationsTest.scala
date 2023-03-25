package com.knoldus.crudoperations

import org.scalatest.funsuite.AnyFunSuite

class SeqOperationsTest extends AnyFunSuite {

  //for type int
  val seqOperations = new SeqOperations[Int]

  test("Create operation") {
    assert(seqOperations.create(1) == Seq(1))
    assert(seqOperations.create(2) == Seq(1, 2))
  }
  test("Read operation") {
    assert(seqOperations.read() == Seq(1, 2))
  }
  test("Update operation") {
    seqOperations.update(0, 0)
    assert(seqOperations.read() == Seq(0, 2))
  }
  test("Delete operation") {
    seqOperations.delete(0)
    assert(seqOperations.read() == Seq(2))
  }

  //for type string
  val seqOperationOnString = new SeqOperations[String]

  test("Create operation on string") {
    assert(seqOperationOnString.create("Sant") == List("Sant"))
    assert(seqOperationOnString.create("Narayan") == List("Sant", "Narayan"))
    assert(seqOperationOnString.create("Singh") == List("Sant", "Narayan", "Singh"))
  }
  test("Read operation on string") {
    assert(seqOperationOnString.read() == List("Sant", "Narayan", "Singh"))
  }
  test("Update operation on string") {
    assert(seqOperationOnString.update("Nara", 1) == List("Sant", "Nara", "Singh"))
  }
  test("Delete operation on string") {
    assert(seqOperationOnString.delete("Nara") == List("Sant", "Singh"))
  }
}
