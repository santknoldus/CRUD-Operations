package com.knoldus.crudoperations

import scala.util.{Failure, Success, Try}

abstract class CRUD[T] {
  def create(element: T): Iterable[T]

  def read(): Iterable[T]

  def update(newElement: T, index: Int): Iterable[T]

  def delete(element: T): Iterable[T]
}

class ListOperation[T] extends CRUD[T] {

  private var list = List[T]()

  //method to create a list and insert an element
  override def create(element: T): List[T] = {
    Try {
      list = list :+ element
      list
    } match {
      case Success(result) => result
      case Failure(exception) => throw exception
    }
  }

  //method to read the list
  override def read(): List[T] = {
    Try {
      list
    } match {
      case Success(result) => result
      case Failure(exception) => throw exception
    }
  }

  //method to update the list at given index
  override def update(newElement: T, index: Int): List[T] = {
    Try {
      list = list.updated(index, newElement)
      list
    } match {
      case Success(result) => result
      case Failure(exception) => throw exception
    }
  }

  //method to delete an element
  override def delete(element: T): List[T] = {
    Try {
      list = list.filterNot(_ == element)
      list
    } match {
      case Success(result) => result
      case Failure(exception) => throw exception
    }
  }
}

class SeqOperations[T] extends CRUD[T] {

  private var sequence = Seq[T]()

  //method to create a sequence and insert an element
  override def create(element: T): Seq[T] = {
    Try {
      sequence = sequence :+ element
      sequence
    } match {
      case Success(result) => result
      case Failure(exception) => throw exception
    }
  }

  //method to read the list
  override def read(): Iterable[T] = {
    Try {
      sequence
    } match {
      case Success(result) => result
      case Failure(exception) => throw exception
    }
  }

  //method to update the sequence at given index
  override def update(newElement: T, index: Int): Seq[T] = {
    Try {
      sequence = sequence.updated(index, newElement)
      sequence
    } match {
      case Success(result) => result
      case Failure(exception) => throw exception
    }
  }

  //method to delete an element
  override def delete(element: T): Seq[T] = {
    Try {
      sequence = sequence.filterNot(_ == element)
      sequence
    } match {
      case Success(result) => result
      case Failure(exception) => throw exception
    }
  }
}