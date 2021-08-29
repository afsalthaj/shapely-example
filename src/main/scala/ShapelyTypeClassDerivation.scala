import shapely._

object ShapelyTypeClassDerivation extends App {
  trait Monoid[A]:
    def empty: A
    def combine(a: A, b: A): A

  object Monoid {
    def apply[A](implicit ev: Monoid[A]): Monoid[A] = ev

    given Monoid[String] with 
      def empty: String = ""
      def combine(a: String, b: String): String = a ++ b

    given Monoid[Int] with
      def empty: Int = 0
      def combine(a: Int, b: Int): Int = a + b

    given Monoid[Double] with
      def empty: Double = 0.0
      def combine(a: Double, b: Double): Double = a + b

    given Monoid[Long] with
      def empty: Long = 0
      def combine(a: Long, b: Long): Long = a + b

    // Equal has InvariantAp
    given eq: InvariantAp[Monoid] = new InvariantAp[Monoid] {
      override def product1[A, B](f: A => B)(g: B => A)(fa: Monoid[A]): Monoid[B] = new Monoid[B] {
        override def empty: B = f(fa.empty)
        override def combine(a: B, b: B): B = f(fa.combine(g(a), g(b)))
      }

      override def product2[A, B, C](f: (A, B) => C)(g: C => (A, B))(fa: Monoid[A], ga: Monoid[B]): Monoid[C] = {
        new Monoid[C] {
          override def empty: C = f(fa.empty, ga.empty)
          override def combine(a: C, b: C): C = {
            val (a1, b1) = g(a)
            val (a2, b2) = g(b)
            val ax = fa.combine(a1, a2)
            val bx = ga.combine(b1, b2)
            f(ax, bx)
          }
        }
      }
    }

    // Derive any typeclass for Shapely
    given eqOfA[A, B](using ev: Shapely[A, B], ev2: Lazy[Monoid, B]): Monoid[A] = new Monoid[A] {
      override def empty: A = ev.from(ev2.instance.empty)
      override def combine(b1: A, b2: A): A = ev.from(ev2.instance.combine(ev.to(b1), ev.to(b2)))
    }
  }

  final case class SixtyFields(
    s11: String,
    s12: Double,
    s13: String,
    s14: Long,
    s15: String,
    s16: Int,
    s21: String,
    s22: Double,
    s23: String,
    s24: Long,
    s25: String,
    s26: Int,
    s31: String,
    s32: Double,
    s33: String,
    s34: Long,
    s35: String,
    s36: Int,
    s41: String,
    s42: Double,
    s43: String,
    s44: Long,
    s45: String,
    s46: Int,
    s51: String,
    s52: Double,
    s53: String,
    s54: Long,
    s55: String,
    s56: Int,
    s61: String,
    s62: Double,
    s63: String,
    s64: Long,
    s65: String,
    s66: Int,
    s71: String,
    s72: Double,
    s73: String,
    s74: Long,
    s75: String,
    s76: Int,
    s81: String,
    s82: Double,
    s83: String,
    s84: Long,
    s85: String,
    s86: Int,
    s91: String,
    s92: Double,
    s93: String,
    s94: Long,
    s95: String,
    s96: Int,
    s101: String,
    s102: Double,
    s103: String,
    s104: Long,
    s105: String,
    s106: Int
  )

  println(
    Shapely.generic[SixtyFields](
      SixtyFields(
        "sdsd",
        1.0,
        "s",
        1L,
        "s",
        1,
        "sdsd",
        1.0,
        "s",
        1L,
        "s",
        1,
        "sdsd",
        1.0,
        "s",
        1L,
        "s",
        1,
        "sdsd",
        1.0,
        "s",
        1L,
        "s",
        1,
        "sdsd",
        1.0,
        "s",
        1L,
        "s",
        1,
        "sdsd",
        1.0,
        "s",
        1L,
        "s",
        1,
        "sdsd",
        1.0,
        "s",
        1L,
        "s",
        1,
        "sdsd",
        1.0,
        "s",
        1L,
        "s",
        1,
        "sdsd",
        1.0,
        "s",
        1L,
        "s",
        1,
        "sdsd",
        1.0,
        "s",
        1L,
        "s",
        1
      )
    )
  )

  println(Shapely.fieldNamesOf[SixtyFields]())

  println(
    Monoid[SixtyFields].combine(
      SixtyFields(
        "sdsd",
        1.0,
        "s",
        1L,
        "s",
        1,
        "sdsd",
        1.0,
        "s",
        1L,
        "s",
        1,
        "sdsd",
        1.0,
        "s",
        1L,
        "s",
        1,
        "sdsd",
        1.0,
        "s",
        1L,
        "s",
        1,
        "sdsd",
        1.0,
        "s",
        1L,
        "s",
        1,
        "sdsd",
        1.0,
        "s",
        1L,
        "s",
        1,
        "sdsd",
        1.0,
        "s",
        1L,
        "s",
        1,
        "sdsd",
        1.0,
        "s",
        1L,
        "s",
        1,
        "sdsd",
        1.0,
        "s",
        1L,
        "s",
        1,
        "sdsd",
        1.0,
        "s",
        1L,
        "s",
        1
      ),
      SixtyFields(
        "sdsd",
        1.0,
        "s",
        1L,
        "s",
        1,
        "sdsd",
        1.0,
        "s",
        1L,
        "s",
        1,
        "sdsd",
        1.0,
        "s",
        1L,
        "s",
        1,
        "sdsd",
        1.0,
        "s",
        1L,
        "s",
        1,
        "sdsd",
        1.0,
        "s",
        1L,
        "s",
        1,
        "sdsd",
        1.0,
        "s",
        1L,
        "s",
        1,
        "sdsd",
        1.0,
        "s",
        1L,
        "s",
        1,
        "sdsd",
        1.0,
        "s",
        1L,
        "s",
        1,
        "sdsd",
        1.0,
        "s",
        1L,
        "s",
        1,
        "sdsd",
        1.0,
        "s",
        1L,
        "s",
        1
      )
    )
  )
}
