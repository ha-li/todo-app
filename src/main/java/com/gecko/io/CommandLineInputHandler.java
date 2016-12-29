package com.gecko.io;

import java.util.Scanner;

import static java.lang.System.out;

/**
 * Created by hlieu on 12/27/16.
 */
public class CommandLineInputHandler {

   public void printOptions () {
      out.println();
      out.println ("--- To Do Application ---");
      out.println (" Please make a choice: ");
      out.println ("  (a)ll items");
      out.println ("  (f)ind a specific item");
      out.println ("  (i)nsert a new item");
      out.println ("  (u)pdate an existing item");
      out.println ("  (d)elete an existing item");
      out.println ("  (e)xit");
   }

   public void tryAgain () {
      out.println ("  No such option. Try again.");
   }

   public String readInput () {
      Scanner scan = new Scanner (System.in);
      String s = scan.next ();
      return s;
   }

   public void processInput (CommandLineInput input) {

   }
}
