package com.splio.data.cli.launcher

import java.io.File
import java.util.logging.Logger

import com.slio.data.parsing.common.reader.flat.file.FlatFileReader
import com.splio.data.parsing.velib.data.model.VelibData
import com.splio.data.core.processing.logic.MeanVelib._
import com.splio.data.core.processing.logic.MeanStation._
import com.splio.data.core.processing.logic.TopThreeStation._

import scala.util.{Failure, Try}

/**
  * Object containing the launch logic allowing its easy testing. Thus, this code is extracted from the application's
  * main method that remains as simple as possible.
  */
object VelibDataLauncher {

  /**
    * Launch the application from the given source file. 1) Parse file; 2) create Velib Data; 3) execute their
    * actions and print the resulting position.
    * @param sourceFile the source file to be used.
    * @return the launch result as a [[Try]] which type is [[Unit]].
    */
  def launch(sourceFile: File): Try[ Unit ] = FlatFileReader(sourceFile).as[List[VelibData]] match {
    case Left(exception) => Failure(new IllegalArgumentException(exception))
    case Right(parsedVelibData) => Try {
      println("""***************************************************************************************************************************************""")
      println("""nombre moyen de Vélib' disponibles par station et par heure de la journée""")
      getBikeAndEBikeAvailablePerHourAndStation(parsedVelibData)
      println("""***************************************************************************************************************************************""")
      println("""nombre moyen d'emplacements disponibles dans les stations, par heure de la journée""")
      println("""***************************************************************************************************************************************""")
      getDockAndEDockAvailablePerHourAndStation(parsedVelibData)
      println("""***************************************************************************************************************************************""")
      println("""top 3 des stations qui ont le plus de Vélib' disponibles sur la journée""")
      println("""***************************************************************************************************************************************""")
      getTopThreeStationOfTheDay(parsedVelibData)
    }
  }

  private def getBikeAndEBikeAvailablePerHourAndStation(parsedVelibData: List[VelibData]) = {
    getBikeAvailablePerHourAndStation(parsedVelibData).map(
      key => {
        println("timstamps :"+key._1)
        key._2.map(adresse => println("Average Available Bikes In The Following Adress "+adresse._1 + "  And Average Number Of Bike And Ebike Available : " +adresse._2))
      }
    )
  }

  private def getDockAndEDockAvailablePerHourAndStation(parsedVelibData: List[VelibData]) = {
    getDockAvailablePerHourAndStation(parsedVelibData).map(
      key => {
        println("timstamps :"+key._1)
        key._2.map(adresse => println("Average Available Docks In The Following Adress "+adresse._1 + "  And Average Number Of Docks And EDocks Available : " +adresse._2))
      }
    )
  }

  private def getTopThreeStationOfTheDay(parsedVelibData: List[VelibData]) = {
    getTopThreeStation((parsedVelibData)).map( s => println("station :"+s._1) )
  }

}
