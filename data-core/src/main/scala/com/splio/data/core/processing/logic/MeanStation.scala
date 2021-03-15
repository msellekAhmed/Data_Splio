package com.splio.data.core.processing.logic

import com.splio.data.parsing.velib.data.model.VelibData

import scala.util.Try


/**
  * MeanStation Object used to contains utility function to calculate available docks and edock from List of Velib Data.
  */
object MeanStation {

  /**
    * calculate available docks and edock from List of Velib Data
    * @param velibDataList List of Velib Data.
    * @return Map of the hours with a map of station and available docks.
    */
  def getDockAvailablePerHourAndStation(velibDataList : List[VelibData]) : Map[String, Map[String, Long] ] = {

    val recordsList = velibDataList.map( velibData => velibData.records )
    recordsList.flatMap(records => records.map(record => record.record_timestamp.substring(0, 13) -> (records.map(rec => rec.fields.station_name -> (rec.fields.nbdock + rec.fields.nbedock)) toMap)) toMap).toMap
  }

}
