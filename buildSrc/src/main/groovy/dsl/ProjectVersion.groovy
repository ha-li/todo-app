package dsl

/**
 * a class to hold the project release version info.
 */
class ProjectVersion {
   Integer major
   Integer minor
   Boolean release

   ProjectVersion (Integer major, Integer minor, Boolean release) {
      this.major = major
      this.minor = minor
      this.release = release;
   }

   ProjectVersion (Integer major, Integer minor) {
      this(major, minor, Boolean.FALSE)
   }

   // this method needs to be defined
   @Override
   String toString () {
      "$major.$minor${release ? '':'-SNAPSHOT'}"
   }
}