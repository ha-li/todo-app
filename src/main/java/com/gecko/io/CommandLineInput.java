package com.gecko.io;

/**
 * Created by hlieu on 12/27/16.
 */
public enum CommandLineInput {
   VIEW_ALL('a'),
   FIND_ALL('f'),
   CREATE('i'),
   UPDATE ('u'),
   DELETE ('d'),
   EXIT('e');

   CommandLineInput(char a) {
      value = a;
   }

   public static CommandLineInput fromVal(char i) {
      for(CommandLineInput c: CommandLineInput.values()) {
         if(c.getShortCmd() == i) {
            return c;
         }
      }
      throw new IllegalArgumentException("No such CommandLineInput found for " + i);
   }

   private char value;

   public char getShortCmd () {
      return value;
   }

   public static CommandLineInput getCommandLineInputForInput (char in) {
      return fromVal(in);
   }
}
