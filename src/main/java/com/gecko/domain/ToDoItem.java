package com.gecko.domain;

/**
 * Created by hlieu on 12/27/16.
 *
 * POJO for tracking the items to do.
 *
 **/

public class ToDoItem implements Comparable<ToDoItem> {

   private Long id;
   private String name;
   private boolean completed;

   public Long getId () {
      return id;
   }

   public void setId (Long id) {
      this.id = id;
   }

   public String getName () {
      return name;
   }

   public void setName (String name) {
      this.name = name;
   }

   public boolean isCompleted () {
      return completed;
   }

   public void setCompleted (boolean completed) {
      this.completed = completed;
   }

   public int compareTo (ToDoItem other) {
      if (this.id == other.id) { return 0; }
      else if (this.id < other.id) { return -1; }
      else {
         return 1;
      }
   }
}
