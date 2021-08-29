name := "shapely-example"

version := "0.1"

scalaVersion := "3.0.1"

libraryDependencies ++=
  Seq(
    "com.fommil" % "shapely" % "0.1.5",
    "org.typelevel" % "shapeless3-deriving_3" % "3.0.2"
  )
