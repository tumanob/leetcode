/**
 * https://leetcode.com/problems/valid-parentheses/
 * 
 * stack Data structure example
 * https://initjs.org/data-structure-stack-in-javascript-714f45dbf889
 * 
 */

/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function (s) {
	if (s.length == 1) return false
	if (s.length == 0) return true

	let stack = []
	let myMap = new Map()
	myMap.set('(', ')')
	myMap.set('{', '}')
	myMap.set('[', ']')

	for (char of s) { // complexity in O(N) as we go throught the string once
		if (char === '(' || char === '{' || char === '[') {
			stack.push(char) // in worst case it gives another O(N) in space and time "((((((..."
		} else {
			if (char !== myMap.get(stack[stack.length - 1])) 
				return false
			stack.pop()
		}
	}

	return stack.length === 0
};