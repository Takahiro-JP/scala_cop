def append[Int](xs: List[Int], ys: List[Int]): List[Int] =
  xs match {
    case List() => ys
    case x :: xs1 => x :: append(xs1, ys)
  }