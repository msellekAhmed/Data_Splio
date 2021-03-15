package com.splio.data.parsing.velib.data.model

/**
  * JsonFieldsObject Object used to represent fields attribute of the records attribite in the json line.
  */
class JsonFieldsObject private(val station_state: String,
                               val dist : String,
                               val densitylevel : String,
                               val nbbikeoverflow : Long,
                               val maxbikeoverflow : String,
                               val nbedock : Long,
                               val station_name : String,
                               val kioskstate : String,
                               val nbfreeedock : Long,
                               val station_type : String,
                               val station_code : String,
                               val creditcard : String,
                               val station : String,
                               val nbebike : Long,
                               val duedate : String,
                               val nbebikeoverflow : Long,
                               val nbfreedock : Long,
                               val overflow : String,
                               val nbdock : Long,
                               val geo : Array[Double],
                               val overflowactivation : String,
                               val nbbike : Long)  {}

/**
  * Companion object used to define the apply method allowing an easy use of the underlying [[JsonFieldsObject]]'s constructor.
  */

object JsonFieldsObject {

  def apply(station_state: String,
            dist: String,
            densitylevel: String,
            nbbikeoverflow: Long,
            maxbikeoverflow: String,
            nbedock: Long,
            station_name: String,
            kioskstate: String,
            nbfreeedock: Long,
            station_type: String,
            station_code: String,
            creditcard: String,
            station: String,
            nbebike: Long,
            duedate: String,
            nbebikeoverflow: Long,
            nbfreedock: Long,
            overflow: String,
            nbdock: Long,
            geo: Array[Double],
            overflowactivation: String,
            nbbike: Long): JsonFieldsObject = new JsonFieldsObject(station_state, dist, densitylevel, nbbikeoverflow, maxbikeoverflow, nbedock, station_name, kioskstate, nbfreeedock, station_type, station_code, creditcard, station, nbebike, duedate, nbebikeoverflow, nbfreedock, overflow, nbdock, geo, overflowactivation, nbbike)

}