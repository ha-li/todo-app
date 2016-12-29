package com.gecko.repository;

import com.gecko.domain.ToDoItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by hlieu on 12/27/16.
 */
public class InMemoryRepository implements ToDoRepository {

   private ConcurrentMap<Long, ToDoItem> todos = new ConcurrentHashMap<Long, ToDoItem> ();
   private AtomicLong currentId = new AtomicLong ();

   @Override
   public List<ToDoItem> findAll () {
      List<ToDoItem> items = new ArrayList<ToDoItem> (this.todos.values());
      Collections.sort(items);
      return items;
   }

   @Override
   public ToDoItem findById (Long id) {
      return todos.get(id);
   }

   @Override
   public Long insert (ToDoItem item) {
      Long id = currentId.incrementAndGet ();
      item.setId(id);
      todos.putIfAbsent(id, item);
      return id;
   }

   @Override
   public void update (ToDoItem item) {
      todos.replace(item.getId(), item);
   }

   @Override
   public void delete (ToDoItem item) {
      todos.remove(item.getId());
   }
}
