package com.splio.data.parsing.velib.data.model


/**
  * VelibData Object used to represent the json line.
  */
class VelibData private(val nhits : Long, val parameters : JsonParameterObject, val records : Array[JsonRecordObject], val facet_groups : Array[JsonFacetGroupObject]) {}


/**
  * Companion object used to define the apply method allowing an easy use of the underlying [[VelibData]]'s constructor.
  */
object VelibData {

  def apply(nhits: Long, parameters: JsonParameterObject, records: Array[JsonRecordObject], facet_groups: Array[JsonFacetGroupObject]): VelibData = new VelibData(nhits, parameters, records, facet_groups)

}