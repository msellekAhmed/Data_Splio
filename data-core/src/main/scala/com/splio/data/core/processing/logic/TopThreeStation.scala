package com.splio.data.core.processing.logic

import com.splio.data.parsing.velib.data.model.VelibData

/**
  * TopThreeStation Object used to contains utility function to calculate top three stations from List of Velib Data.
  */
object TopThreeStation {

  /**
    * calculate top three stations from List of Velib Data
    * @param velibDataList List of Velib Data.
    * @return List of couple Station, number of bikes available in the day
    */
  def getTopThreeStation(velibDataList : List[VelibData]) : List[(String, Long)]  = {

    val recordsList = velibDataList.map( velibData => velibData.records )
    recordsList.flatMap(records => records.map(record => record.fields.station_name -> (record.fields.nbbike + record.fields.nbebike))).groupBy(_._1).mapValues( _.map(_._2).sum ).toList.sortBy(_._2)(Ordering[Long].reverse).take(3)

  }

}
