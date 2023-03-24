package com.knoldus.crudoperations

import org.scalatest.funsuite.AnyFunSuite

class SeqOperationsTest extends AnyFunSuite {

  //for type int
  val seqOperations = new SeqOperations[Int]

  test("Create operation") {
    seqOperations.create(1)
    assert(seqOperations.read() == Seq(1))
  }
  test("Read operation") {
    assert(seqOperations.read() == Seq(1))
  }
  test("Update operation") {
    seqOperations.update(2, 0)
    assert(seqOperations.read() == Seq(2))
  }
  test("Delete operation") {
    seqOperations.delete(2)
    assert(seqOperations.read() == Seq())
  }

  //for type string
  val seqOperationOnString = new SeqOperations[String]

  test("Create operation on string") {
    seqOperationOnString.create("Sant")
    seqOperationOnString.create("Narayan")
    seqOperationOnString.create("Singh")
    assert(seqOperationOnString.read() == List("Sant", "Narayan", "Singh"))
  }
  test("Read operation on string") {
    assert(seqOperationOnString.read() == List("Sant", "Narayan", "Singh"))
  }
  test("Update operation on string") {
    seqOperationOnString.update("Nara", 1)
    assert(seqOperationOnString.read() == List("Sant", "Nara", "Singh"))
  }
  test("Delete operation on string") {
    seqOperationOnString.delete("Nara")
    assert(seqOperationOnString.read() == List("Sant", "Singh"))
  }
}
