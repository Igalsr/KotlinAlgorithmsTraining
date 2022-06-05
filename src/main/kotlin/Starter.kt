

fun main() {

    val searchList = listOf(1,2,3,4,5,6,7,8,9,10)

    // Linear Search
    isTargetInList("Linear",runLinearSearch(searchList, 2))

    // Binary Search
    isTargetInList("Binary", runBinarySearch(searchList, 9))


}

private fun runLinearSearch(list: List<Int>, target: Int): Int? {
    // Return the index of the position of the target if exists else null
    var answer: Int? = null
    for(item in list.indices){
        if (list[item] == target){
            answer = item
        }
    }
    return answer
}


private fun runBinarySearch(list: List<Int>, target: Int): Int? {

    var bottomIndex = 0
    var topIndex = list.lastIndex
    var guessIndex = topIndex/2
    println("Guess Index $guessIndex")

   while (bottomIndex <= topIndex){
       when {
           list[guessIndex] == target -> {
               return guessIndex
           }
           list[guessIndex] < target -> {
               bottomIndex = guessIndex + 1
               guessIndex = (topIndex + bottomIndex)/2
               println("Guess Index $guessIndex Bottom:$bottomIndex Top:$topIndex")
           }
           list[guessIndex] > target -> {
               topIndex = guessIndex - 1
               guessIndex = (bottomIndex + topIndex)/2
               println("Guess Index $guessIndex Bottom:$bottomIndex Top:$topIndex")
           }
       }
   }

    return null
}



private fun isTargetInList(algoType: String,target: Int?){
    if (target != null){
        println("$algoType target is in index $target")
    } else {
        println("$algoType target not found")
    }
}