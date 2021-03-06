import sbt._

trait Defaults {
	def androidPlatformName = "android-7" // Android 2.1-update1
}
class MyLogProject(info: ProjectInfo) extends ParentProject(info) {
  override def shouldCheckOutputDirectories = false
  override def updateAction = task { None } 

  lazy val main  = project(".", "my-log", new MainProject(_))
  //lazy val tests = project("tests",  "tests", new TestProject(_), main)

  class MainProject(info: ProjectInfo) extends AndroidProject(info) with Defaults {    
    val scalatest = "org.scalatest" % "scalatest" % "1.0" % "test"
  }

  //class TestProject(info: ProjectInfo) extends AndroidTestProject(info) with Defaults
}