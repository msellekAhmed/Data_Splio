package com.splio.data.cli.parser

import java.io.File
import scopt.OptionParser

/**
 * Parser of command-line's arguments filling its result inside a [[CommandLineParsingResult]] instance and
 * displaying an usage output if the input is invalid.
  *
  * @see [[OptionParser]]
 */
object CommandLineParser extends OptionParser[CommandLineParsingResult]("splio-data-cli") {

  arg[File]("<file>") text "source file path" action { (argument, parsingResult) =>
    parsingResult.copy(file = argument)
  } validate { argument =>
    if (argument.isFile) success else failure("Argument <file> must be a valid json file")}

  /**
   * Parse the given arguments filling the result inside a [[CommandLineParsingResult]]. Parsing is delegating to the
   * [[OptionParser.parse( )]] method.
   * @param args the arguments to be parsed.
   * @return the parsing result as an [[Option]] of [[CommandLineParsingResult]].
   */
  def parseArguments(args: Seq[String]) = parse(args, CommandLineParsingResult())
}
