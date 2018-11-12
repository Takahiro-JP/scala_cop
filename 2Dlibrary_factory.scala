import Element.elem // シングルトンオブジェクトで定義したelem を読み込み

abstract class Element {
    def contents: Array[String]
    def width: Int =
      if (height == 0) 0 else contents(0).length
    def hight: Int = contents.length
    def above (that: Element): Element = { // aboveメソッドは ++ で連結させる
        val this1 = this widen that.width
        val that1 = that widen this.width
        elem(this1.contents ++ that1.contents) // this メンバ変数を指定する（通常はローカル変数が優先される）
    }
    def beside (that: Element): Element = // besideメソッドは zip で格配列番号で一つの配列を生成し、あまりを捨てる
        val this1 = this highten that.hight
        val that1 = that highten this.hight
        elem (
          for ((line1, line2) <- this1.contents zip that1.contents
              ) yield line1 +line2 )// yield がある場合は型変換がある、つまりmap系（yieldがない場合は、単にforeach)
              
    def widen (w: Int): Element =
      if (w <= width) this 
      else {
        val left = elem(' ', (w - width) / 2, height)
        val right = elem(' ', w -
      }
    override def toString = contents mkString "\n" // mkStringメソッドは 変数の中の連続する値の間に引数（今回なら"\n"）を挿入する
}