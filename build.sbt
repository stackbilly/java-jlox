// This is an sbt build file
// It is needed to run sbt
// To run unit tests, you also need project/plugins.sbt to contain:
//   addSbtPlugin("net.aichler" % "sbt-jupiter-interface" % "0.11.1")
name := "jlox"
version := "1.0"

// For Java
javacOptions ++= Seq("-source", "17", "-target", "17")
Compile / run / mainClass := Some("com.craftinginterpreters.lox.Lox") 

// For Junit5 https://junit.org/junit5/docs/current/user-guide/
libraryDependencies ++= Seq(
  "net.aichler" % "jupiter-interface" % JupiterKeys.jupiterVersion.value % Test
)
