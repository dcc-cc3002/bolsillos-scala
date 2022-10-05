ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.9"

lazy val root = (project in file("."))
  .settings(
    name := "pokemon-scala",
    idePackagePrefix := Some("cl.uchile.dcc.poke")
  )
libraryDependencies += "com.beautiful-scala" %% "scalastyle" % "1.5.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.14" % Test
libraryDependencies += "org.scalatest" %% "scalatest-funsuite" % "3.2.14" % Test
libraryDependencies += "org.scalatestplus" %% "scalacheck-1-16" % "3.2.14.0" % Test