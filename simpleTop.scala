 */
 class Top extends Expr {
  def simplifyTop(expr: Expr): Expr = expr match {
  case UnOp("-", UnOp("-", e)) => e //負の数はそのまま
  case BinOp("-", e, Num(0)) => e   //０の加算はそのまま
  case BinOp("*", e, Num(1)) => e   //１の乗算はそのまま
  case _ => expr
  }
}
*/