package com.knoldus.crudoperations

abstract class CRUD[T] {
  def create(element: T): Unit

  def read(): Iterable[T]

  def update(newElement: T, index: Int): Unit

  def delete(element: T): Unit
}

class ListOperation[T] extends CRUD[T] {

  private var list = List[T]()

  //method to create a list and insert an element
  override def create(element: T): Unit = {
    list = list :+ element
  }

  //method to read the list
  override def read(): List[T] = {
    list
  }

  //method to update the list at given index
  override def update(newElement: T, index: Int): Unit = {
    list = list.updated(index, newElement)
  }

  //method to delete an element
  override def delete(element: T): Unit = {
    list = list.filterNot(_ == element)
  }
}

class SeqOperations[T] extends CRUD[T] {

  private var sequence = Seq[T]()

  //method to create a list and insert an element
  override def create(element: T): Unit = {
    sequence = sequence :+ element
  }

  //method to read the list
  override def read(): Iterable[T] = {
    sequence
  }

  //method to update the list at given index
  override def update(newElement: T, index: Int): Unit = {
    sequence = sequence.updated(index, newElement)
  }

  //method to delete an element
  override def delete(element: T): Unit = {
    sequence = sequence.filterNot(_ == element)
  }
}