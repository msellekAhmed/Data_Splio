package com.splio.data.core.processing.logic

import com.splio.data.parsing.velib.data.model.{JsonRecordObject, VelibData}

/**
  * MeanVelib Object used to contains utility function to calculate available bike and ebike from List of Velib Data.
  */
object MeanVelib {


  /**
    * calculate available docks and edock from List of Velib Data
    * @param velibDataList List of Velib Data.
    * @return Map of the hours with a map of station and available bikes.
    */
  def getBikeAvailablePerHourAndStation(velibDataList : List[VelibData]) : Map[String, Map[String, Long] ] = {

    val recordsList = velibDataList.map( velibData => velibData.records )
    recordsList.flatMap(records => records.map(record => record.record_timestamp.substring(0, 13) -> (records.map(rec => rec.fields.station_name -> (rec.fields.nbbike + rec.fields.nbebike)) toMap)) toMap).toMap
  }


}
