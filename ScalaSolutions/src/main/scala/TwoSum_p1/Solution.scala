package TwoSum_p1

object Solution {

  def main(args: Array[String]): Unit = {
    println(twoSum(Array(2,7,11,15), 18).mkString("[", ",", "]")) // [1,2]
    println(twoSum(Array(2,7,11,15), 9).mkString("[", ",", "]"))  // [0,1]
    println(twoSum(Array(2,7,11,15), 26).mkString("[", ",", "]")) // [2,3]
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    def twoSum(index: Int, previous: Map[Int, Int]): Array[Int] = {
      previous.get(target - nums(index)) match {
        case Some(previousIndex) => Array(previousIndex, index)
        case None => twoSum(index + 1, previous ++ Map(nums(index) -> index))
      }
    }
    twoSum(0, Map.empty)
  }
  //leetcode submit region end(Prohibit modification and deletion)
}
