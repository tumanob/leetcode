//val dottyVersion = "0.26.0-RC1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "LeetCode Scala Solutions",
    version := "0.1.0",

    scalaVersion := 3.1,

    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test"
  )
