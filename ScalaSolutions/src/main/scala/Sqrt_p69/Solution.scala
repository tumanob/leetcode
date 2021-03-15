package Sqrt_p69

/**
 * https://leetcode.com/problems/sqrtx/
 * Given a non-negative integer x, compute and return the square root of x.
 * Since the return type is an integer, the decimal digits are truncated, 
 * and only the integer part of the result is returned.
 */
object Solution {
  /**
   * I am gonna Use Newton's method to calculate it as it is fun 
   * and used in many functional programing courses as a reference
   * 
   * Some external reading about the method 
   * https://blogs.sas.com/content/iml/2016/05/18/newtons-method-babylonian-square-root.html
   */
  val tolerance = 0.001 // when it is good enough as well a start guess
 
  def mySqrt(x: Int): Int = {
    def isGoodEnough(guess: Double): Boolean =
      Math.abs(guess * guess - x) < tolerance
      
    def improve(guess: Double): Double =
      (guess + x / guess) * 0.5
      
    def iterator(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else iterator(improve(guess))
      
    iterator(tolerance).toInt
  }
  
  def main(args: Array[String]): Unit = {
    println(mySqrt(3)) // 1
    println(mySqrt(4)) // 2
    println(mySqrt(8)) // 2
  }
}
