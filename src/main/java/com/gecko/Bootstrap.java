package com.gecko;

import com.gecko.io.CommandLineInput;
import com.gecko.io.CommandLineInputHandler;
import org.apache.commons.lang3.CharUtils;

/**
 * Created by hlieu on 12/27/16.
 */
public class Bootstrap {

   public static final char DEFAULT_INPUT = '\u0000';
   public static void main (String[] args) {
      CommandLineInputHandler commandLineInputHandler = new CommandLineInputHandler ();
      char command = DEFAULT_INPUT;
      CommandLineInput commandLineInput = null;

      while (CommandLineInput.EXIT.getShortCmd() != command) {

         commandLineInputHandler.printOptions ();
         String input = commandLineInputHandler.readInput ();
         command = CharUtils.toChar (input, DEFAULT_INPUT);
         //char[] inputs = input.length() == 1 ? input.toCharArray () : new char[] {DEFAULT_INPUT};
         //command  = inputs[0];

         try {
            commandLineInput  = CommandLineInput.getCommandLineInputForInput (command);
         } catch (IllegalArgumentException ae) {
            commandLineInputHandler.tryAgain ();
            //continue;
         }
         commandLineInputHandler.processInput(commandLineInput);

      }
   }
}
