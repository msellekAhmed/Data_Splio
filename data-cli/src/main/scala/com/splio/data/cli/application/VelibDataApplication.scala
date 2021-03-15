package com.splio.data.cli.application

import com.splio.data.cli.launcher.VelibDataLauncher
import com.splio.data.cli.parser.CommandLineParser
import com.splio.data.cli.parser.CommandLineParser._
import com.splio.data.cli.launcher.VelibDataLauncher._

import scala.Console.err
import scala.sys.exit

/**
  * Main class of the project that must remain an entry point with as little logic as possible. Delegate the arguments
  * parsing to a [[CommandLineParser]] and the application launch to a [[VelibDataLauncher]].
  */
object VelibDataApplication extends App {

  parseArguments(args.toSeq) match {
    case Some(arguments) => launch(arguments.file).recover { case e: Throwable => err.println(e.getMessage); exit(2)}
    case None => exit(1)
  }
}
