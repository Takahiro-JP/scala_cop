object Element {
  private class ArrayElemet( //　シングルトンオブジェクト内にArrayElemet,LineElement,UniformElementを
      val contents: Array[String] //　プライベート定義しておくことでクライアントから見えない、けれどElemetクラスからは呼べる
      ) extends Element
      
  private class LineElement(s: String) extends Element {
    val contents = Array(s)
    override def width = s.length
    override def height = 1
  }
  
  private class UniformElement(
      ch: Char,
    override val width: Int,
    override val height: Int
    ) extends Element {
      private val line = ch.toString * width
      def contents = Array.fill(height)(line)
}
  def elem (contents: Array[String]): Element = 
    new ArrayElement (contents)
  
  def elem (chr: Char, width: Int, height: Int): Elements =
    new UniformElement(ch, width, height)

  def elem (line: String): Elements =
    new LineElement(line)
}