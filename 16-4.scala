def isort(xs: List[Int]): List[Int] =
   if (xs.isEmpty)  Nil
   else insert(xs.head, isort(xs.tail))             //リストを先頭要素とそれ以外に分け、insertに打ち込む
def insert(x: Int, xs: List[Int]): List[Int] =
  if (xs.isEmpty || x <=xs.head) x :: xs            // xsが空 or xの方が小さいとき
  else xs.head :: insert(x, xs.tail)                // それ以外つまりxの方が大きいとき、xs.tail.head xs.head xs.tail.tailの順番に入れ替える、