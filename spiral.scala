import Element.elem

object Spiral {
  val space = elem(" ")
  val corner = elem("+")
  def spiral (nEdge: Int, direction: Int): Elment = {
    if (nEdge == 1) elem("+")
    else 
      val sp = spiral(nEdge - 1, (direction + 3) % 4 )
      def verticalBar = elem('|', 1, sp.height)
      
  }
}