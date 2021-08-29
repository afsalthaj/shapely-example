import shapely._

final case class HelloWorld(a: String, b: Int, c: Double)

object SimpleExample extends App {
  println(Shapely.fieldNamesOf[HelloWorld]())
  println(Shapely.generic[HelloWorld](HelloWorld("1", 2, 3.0)))

  // List(a, b, c)
  // CaseClass3(1,2,3.0)
}
