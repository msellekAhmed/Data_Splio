package com.splio.data.parsing.velib.data.model



/**
  * Facet Object used to represent facet attribut of facetgroup attribute in the json line.
  */
class JsonFacetObject private(val name: String, val path: String, val count: Long, val state: String) {}


/**
  * Companion object used to define the apply method allowing an easy use of the underlying [[JsonFacetObject]]'s constructor.
  */
object JsonFacetObject {

  def apply(name: String, path: String, count: Long, state: String): JsonFacetObject = new JsonFacetObject(name, path, count, state)

}