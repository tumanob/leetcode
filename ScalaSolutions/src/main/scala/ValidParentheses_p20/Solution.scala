package ValidParentheses_p20

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
object Solution {

  val OpenToClose: Map[Char, Char] = Map('{' -> '}', '[' -> ']', '(' -> ')')
  val CloseToOpen: Map[Char, Char] = OpenToClose.map(_.swap)

  def main(args: Array[String]): Unit = {
    println(!isValid("["))
    println(isValid("()[]{}")) // all should be true
    println(isValid("()"))
    println(!isValid("(]"))
    println(isValid("[()]"))
    println(isValid("{[()]}"))
    println(isValid("([{{[(())]}}])"))
    println(!isValid("{{[]()}}}}"))
    println(!isValid("{{[](A}}}}"))
    println(!isValid("{[(])}"))
  }

  def isValid(s: String): Boolean = {
    stackParenthesisSolution(s) // Stack Solution
    //parenthesesAreBalanced(s) // Tail recursion solution
  }

  import scala.collection.mutable.Stack
  /**
   * Stack solution
   */
  def stackParenthesisSolution(s: String): Boolean = {
    val stack = new Stack[Char]()
    if (s.size == 0) stack.push('f')
    
    s.foreach(char => {
      if (OpenToClose.contains(char)) {
        stack.push(char)
      } else {
        if (stack.size > 0 && OpenToClose.get(stack.top) == Some(char))
          stack.pop()
          else
          stack.push('f')
      }
    })

    stack.size == 0
  }

  /**
   * Tail recursion solution 
   * is taken from https://www.scala-algorithms.com/ParenthesesTailRecursive/
   *
   * @param
   * @return
   */
  def parenthesesAreBalanced(s: String): Boolean = {
    if (s.isEmpty) true
    else {
      @scala.annotation.tailrec
      def go(position: Int, stack: List[Char]): Boolean = {
        if (position == s.length) stack.isEmpty
        else {
          val char = s(position)
          val isOpening = OpenToClose.contains(char)
          val isClosing = CloseToOpen.contains(char)
          if (isOpening) go(position + 1, char :: stack)
          else if (isClosing) {
            val expectedCharForMatching = CloseToOpen(char)
            stack match {
              case `expectedCharForMatching` :: rest =>
                go(position + 1, rest)
              case _ =>
                false
            }
          } else false
        }
      }

      go(position = 0, stack = List.empty)
    }
  }
}
