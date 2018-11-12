abstract class Element {
    def contents: Array[String]
    def width: Int =
      if (height == 0) 0 else contents(0).length
    def hight: Int = contents.length
    def above (that: Element): Element = // aboveメソッドは ++ で連結させる
      new ArrayElement (this.contents ++ that.contents) // this メンバ変数をしてする（通常はローカル変数が優先される）
    def beside (that: Element): Element = // besideメソッドは zip で格配列番号で一つの配列を生成し、あまりを捨てる
      new ArrayElement (
          for (
              (line1, line2) <- this.contents zip that.contents
              ) yield line1 +line2 // yield がある場合は型変換がある、つまりmap系（yieldがない場合は、単にforeach)
              )
    override def toString = contents mkString "\n" // mkStringメソッドは 変数の中の連続する値の間に引数（今回なら"\n"）を挿入する
}

class ArrayElement (
    val contents: Array[String]
    ) extends Element
}
class LineElement (s: String) extends Element (Array(s)) {
  override def width = s.length
  override def height = 1
}
class UniformElement(
    ch: Char,
    override val width: Int,
    override val height: Int
    ) extends Element {
  private val line = ch.toString * width
  def contents = Array.fill(height)(line)
}