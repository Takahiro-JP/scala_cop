object Element {
  
  def elem (contents: Array[String]): Element = 
    new ArrayElement (contents)
  
  def elem (chr: Char, width: Int, height: Int): Elements =
    new UniformElement(ch, width, height)

  def elem (line: String): Elements =
    new LineElement(line)
}