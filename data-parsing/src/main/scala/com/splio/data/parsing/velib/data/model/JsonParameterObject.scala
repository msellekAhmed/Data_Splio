package com.splio.data.parsing.velib.data.model


/**
  * JsonParameterObject Object used to represent parameters attribite in the json line.
  */
class JsonParameterObject private(val dataset: Array[String],val timezone: String,val rows : String,val format: String,val geofilterdistance : Array[Double],val facet : Array[String]) {}


/**
  * Companion object used to define the apply method allowing an easy use of the underlying [[JsonGeometryObject]]'s constructor.
  */
object JsonParameterObject {

  def apply(dataset: Array[String], timezone: String, rows: String, format: String, geofilterdistance: Array[Double], facet: Array[String]): JsonParameterObject = new JsonParameterObject(dataset, timezone, rows, format, geofilterdistance,facet)
}