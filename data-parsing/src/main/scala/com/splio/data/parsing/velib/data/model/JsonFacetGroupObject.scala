package com.splio.data.parsing.velib.data.model

import com.splio.data.parsing.common.reader.Reader


/**
  * FacetGroup Object used to represent facet group attribut of json line.
  */
class JsonFacetGroupObject private(val name: String, val facets : Array[JsonFacetObject]) {}


/**
  * Companion object used to define the apply method allowing an easy use of the underlying [[JsonFacetGroupObject]]'s constructor.
  */
object JsonFacetGroupObject {

  def apply(name: String, facets: Array[JsonFacetObject]): JsonFacetGroupObject = new JsonFacetGroupObject(name, facets)
}
