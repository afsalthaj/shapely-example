import shapely._

final case class HelloWorld(a: String, b: Int, c: Double)

object ShapelyTest extends App {

 private def fieldNamesOf[A] = FieldNamesOf[A]()

 final class FieldNamesOf[A]() {
    def apply[B]()(implicit S: Shapely[A, B], F: FieldNames[B]) = F.fieldNames
  }

  println(fieldNamesOf[HelloWorld]())
  println(Shapely.generic[HelloWorld](HelloWorld("1", 2, 3.0)))
  
  // List(a, b, c)
  // CaseClass3(1,2,3.0)
}
