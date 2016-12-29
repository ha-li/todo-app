package com.gecko.repository;

import com.gecko.domain.ToDoItem;

import java.util.List;

/**
 * Created by hlieu on 12/27/16.
 */
public interface ToDoRepository {
   List<ToDoItem> findAll ();
   ToDoItem findById (Long id);
   void update (ToDoItem item);
   Long insert (ToDoItem item);
   void delete (ToDoItem item);
}
