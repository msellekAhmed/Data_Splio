package com.splio.data.parsing.velib.data.converter

import com.splio.data.parsing.common.converter.Converter
import com.splio.data.parsing.velib.data.model.VelibData
import net.liftweb.json._

/**
  * Converter from the List of JSON Lines to the List of Velib Data.
  * Inspired by David Galichet's talk (@dgalichet) at Paris Scala User Group.
  *
  * @see http://fr.slideshare.net/dgalichet/writing-dsl-with-applicative-functors
  * @tparam List[String], the input type.
  * @tparam List[VelibData] the output type.
  */
object VelibDataConverter extends  Converter[List[String], List[VelibData]]{
  /**
    * Convert the given instance of type List[String] to an [[Either]] of type List[VelibData].
    *
    * @param input the content to be converted in this case json lines.
    * @return the conversion result which is a List of Velib Data.
    */
   def convert(input: List[String]) = {

    implicit val formats = DefaultFormats
    try {
          val velibList = input.map( jsonLine => {
          val jValue = parse(jsonLine)
          val velibData = jValue.extract[VelibData]
          velibData
        })
        Right(velibList)
    } catch {
      case _: MatchError => Left("Can't convert lawn due to invalid content: ")
    }

  }
}
