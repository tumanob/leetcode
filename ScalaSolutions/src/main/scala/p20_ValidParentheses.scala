import scala.collection.mutable.Stack

/**
 * https://leetcode.com/problems/valid-parentheses/
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets
 * Open brackets must be closed in the correct order.
 *
 * @tags: easy
 */
object p20_ValidParentheses {

  import scala.collection.mutable.Stack
  val stack = new Stack[Char]()
  val OpenToClose: Map[Char, Char] = Map('{' -> '}', '[' -> ']', '(' -> ')')

  def checkPar(char: Char): Boolean = 
    if (OpenToClose.contains(char)) {
      stack.push(char)
      true
    } else if (stack.size > 0 && OpenToClose.get(stack.top) == Some(char)) {
      stack.pop()
      true
    } else {
      false
    }
  
  def isValid(s: String): Boolean = {
    stack.clear()
    
    s.size > 0 && // check edge case for empty string
      s.forall(checkPar) && // run validation agains string elements
      stack.size == 0 // if after check stack is not empty this is fail case
  }

  def main(args: Array[String]): Unit = {
    println(!isValid("[")) // all should be true
    println(isValid("()[]{}")) 
    println(isValid("()"))
    println(!isValid("(]"))
    println(isValid("[()]"))
    println(isValid("{[()]}"))
    println(isValid("([{{[(())]}}])"))
    println(!isValid("{{[]()}}}}"))
    println(!isValid("{{[](A}}}}"))
    println(!isValid("{[(])}"))
  }
}
