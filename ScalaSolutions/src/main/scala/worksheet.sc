/**
 * For tests and checks
 */


// Creating a map
val OpenToClose: Map[Char, Char] = Map('{' -> '}', '[' -> ']', '(' -> ')')

// Applying contains method
val result = OpenToClose.contains(2)
val result2 = OpenToClose.contains(3)

// Displays output
println(result)
println(result2)