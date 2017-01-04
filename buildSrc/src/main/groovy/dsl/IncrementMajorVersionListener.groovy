package dsl

import org.gradle.api.Action
import org.gradle.api.Task
import org.gradle.api.execution.TaskExecutionGraph
import org.gradle.api.execution.TaskExecutionGraphListener

/**
 * Created by hlieu on 01/3/17.
 *
 * this is a listener that identifies when the build
 * graph includes the 'incrementMajorVersion' task,
 * and it iterates through the tasks, gets the majorVersionPath
 * then prints out the description property, and tries
 * to find the new version property from the list of actions,
 * which does not exist.
 *
 * to hook this up, a couple lines of code are added to build.gradle
 */
class IncrementMajorVersionListener
        implements TaskExecutionGraphListener {
   final static String majorVersionPath = ':incrementMajorVersion'

   @Override
   void graphPopulated(TaskExecutionGraph taskGraph) {
      if (taskGraph.hasTask(majorVersionPath)) {
         List<Task> allTasks = taskGraph.allTasks
         Task majorTask = allTasks.find { it.path == majorVersionPath }


         String description = majorTask.property('description')
         println "The description is -- $description --"
         for( Action action : majorTask.getActions() ) {
            Map map = action.properties
            println 'contains new version: ' + map.containsKey('newVersion')
         }

      }
   }
}
