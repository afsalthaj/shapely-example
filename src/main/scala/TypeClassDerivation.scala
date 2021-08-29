import shapely._

object TypeClassDerivation extends App {
  trait Equal[A] {
    def eq(a: A, b: A): Boolean
  }

  object Equal {
    def apply[A](implicit ev: Equal[A]): Equal[A] = ev

    def instance[A](bool: Boolean): Equal[A] =
      (_: A, _: A) => bool

    implicit val eqString: Equal[String] = (a: String, b: String) => a == b
    implicit val eqInt: Equal[Int]       = (a: Int, b: Int) => a == b
    implicit val eqDouble: Equal[Double] = (a: Double, b: Double) => a == b
    implicit val eqLong: Equal[Long]     = (a: Long, b: Long) => a == b

    // Equal has InvariantAp
    implicit val eq: InvariantAp[Equal] = new InvariantAp[Equal] {
      override def pure[A](a: A): Equal[A] =
        instance(true)

      override def product1[A, B](f: A => B)(g: B => A)(fa: Equal[A]): Equal[B] =
        (a: B, b: B) => {
          val a1 = g(a)
          val a2 = g(b)
          fa.eq(a1, a2)
        }

      override def product2[A, B, C](f: (A, B) => C)(g: C => (A, B))(fa: Equal[A], ga: Equal[B]): Equal[C] =
        (a: C, b: C) => {
          val (a1, b1) = g(a)
          val (a2, b2) = g(b)
          fa.eq(a1, a2) && ga.eq(b1, b2)
        }
    }

    // Derive any typeclass for Shapely
    implicit def eqOfA[A, B](implicit ev: Shapely[A, B], ev2: Lazy[Equal, B]): Equal[A] = new Equal[A] {
      override def eq(b1: A, b2: A) = ev2.instance.eq(ev.to(b1), ev.to(b2))
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
    Equal[SixtyFields].eq(
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
