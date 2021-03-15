package com.splio.data.parsing.velib.data.model


/**
  * JsonRecordObject Object used to represent records attribite in the json line.
  */
class JsonRecordObject private(val datasetid : String,
                               val recordid : String,
                               val fields : JsonFieldsObject,
                               val geometry : JsonGeometryObject,
                               val record_timestamp : String) {}

/**
  * Companion object used to define the apply method allowing an easy use of the underlying [[JsonRecordObject]]'s constructor.
  */
object JsonRecordObject {

  def apply(datasetid: String, recordid: String, fields: JsonFieldsObject, geometry: JsonGeometryObject, record_timestamp : String): JsonRecordObject = new JsonRecordObject(datasetid, recordid, fields, geometry, record_timestamp)

}