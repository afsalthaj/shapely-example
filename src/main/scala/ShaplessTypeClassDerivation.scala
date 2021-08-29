import shapeless3.deriving.*

/**
 * Shapeless Monoid, fails for over 32 fields in case class with:
 *
 * println(Monoid[SixtyFields2])
 * [error]     |                              ^
 * [error]     |                   Maximal number of successive inlines (32) exceeded,
 * [error]     |                   Maybe this is caused by a recursive inline method?
 * [error]     |                   You can use -Xmax-inlines to change the limit.
 */
//object ShaplessTypeClassDerivation extends App {
//  trait Monoid[A]:
//    def empty: A
//    def combine(x: A, y: A): A
//    extension (x: A) def |+| (y: A): A = combine(x, y)
//
//  object Monoid:
//    def apply[A](using ev: Monoid[A]) = ev
//
//    given Monoid[Unit] with
//      def empty: Unit = ()
//      def combine(x: Unit, y: Unit): Unit = ()
//
//    given Monoid[Boolean] with
//      def empty: Boolean = false
//      def combine(x: Boolean, y: Boolean): Boolean = x || y
//
//    given Monoid[Int] with
//      def empty: Int = 0
//      def combine(x: Int, y: Int): Int = x+y
//
//    given Monoid[Double] with
//      def empty: Double = 0
//      def combine(x: Double, y: Double): Double = x+y
//
//    given Monoid[Long] with
//      def empty: Long = 0
//      def combine(x: Long, y: Long): Long = x+y
//
//    given Monoid[String] with
//      def empty: String = ""
//      def combine(x: String, y: String): String = x+y
//
//    given monoidGen[A](using inst: K0.ProductInstances[Monoid, A]): Monoid[A] with
//      def empty: A =
//        inst.construct([t] => (ma: Monoid[t]) => ma.empty)
//      def combine(x: A, y: A): A =
//        inst.map2(x, y)([t] => (mt: Monoid[t], t0: t, t1: t) => mt.combine(t0, t1))
//
//    inline def derived[A](using gen: K0.ProductGeneric[A]): Monoid[A] = monoidGen
//
//  final case class SixtyFields2(
//    s11: String,
//    s12: Double,
//    s13: String,
//    s14: Long,
//    s15: String,
//    s16: Int,
//    s21: String,
//    s22: Double,
//    s23: String,
//    s24: Long,
//    s25: String,
//    s26: Int,
//    s31: String,
//    s32: Double,
//    s33: String,
//    s34: Long,
//    s35: String,
//    s36: Int,
//    s41: String,
//    s42: Double,
//    s43: String,
//    s44: Long,
//    s45: String,
//    s46: Int,
//    s51: String,
//    s52: Double,
//    s53: String,
//    s54: Long,
//    s55: String,
//    s56: Int,
//    s61: String,
//    s62: Double,
//    s63: String,
//    s64: Long,
//    s65: String,
//    s66: Int,
//    s71: String,
//    s72: Double,
//    s73: String,
//    s74: Long,
//    s75: String,
//    s76: Int,
//    s81: String,
//    s82: Double,
//    s83: String,
//    s84: Long,
//    s85: String,
//    s86: Int,
//    s91: String,
//    s92: Double,
//    s93: String,
//    s94: Long,
//    s95: String,
//    s96: Int,
//    s101: String,
//    s102: Double,
//    s103: String,
//    s104: Long,
//    s105: String,
//    s106: Int
//  )
//
//  println(Monoid[SixtyFields2])
//}
