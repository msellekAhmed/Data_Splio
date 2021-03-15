package com.splio.data.parsing.velib.data.model


/**
  * JsonGeometryObject Object used to represent geometry attribute of the records attribite in the json line.
  */
class JsonGeometryObject private(val `type` : String, val coordinates: Array[String]) {}

/**
  * Companion object used to define the apply method allowing an easy use of the underlying [[JsonGeometryObject]]'s constructor.
  */
object JsonGeometryObject {

  def apply(`type`: String, coordinates: Array[String]): JsonGeometryObject = new JsonGeometryObject(`type`, coordinates)

}