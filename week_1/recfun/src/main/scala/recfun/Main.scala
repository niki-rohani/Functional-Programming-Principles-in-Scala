package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")

    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }

    println()

    println(balance("this is (a) (test(of) my func)".toList))

    println()

    println(countChange(1, List(1,2)))
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      var pascal_number = 1
      if (c != 0 && c!=r)
        pascal_number = pascal(c-1, r-1) + pascal(c, r-1)
      pascal_number


    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def balance_checking(chars: List[Char], open: Int): Boolean = {
        var return_value = true
        if (chars.isEmpty)
          return_value = true
        else if (chars.head == ')')
          if (open == 0)
            return_value = false
          else
            return_value = balance_checking(chars.tail, open - 1)
        else if (chars.head == '(')
          return_value = balance_checking(chars.tail, open + 1)
        else
          return_value = balance_checking(chars.tail, open)
        return_value
      }
      balance_checking(chars, 0)
    }







  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
        var result_value = 0

        if (coins.isEmpty)
          result_value = 0
        else if (money <= 0)
          result_value = 0
        else {

          def countChange_checking (money: Int, coins: List[Int]): Int = {
            var result_value = 0
            if (money == 0)
              result_value = 1
            else if (money < 0)
              result_value = 0
            else if (coins.isEmpty)
              result_value = 0
            else {
              // for (i <- coins) {
              //  println("money :" + money + "   checking with : " + i)
                val r = countChange_checking(money - coins.head, coins) + countChange_checking(money, coins.tail)
                result_value = result_value + r
            }
            result_value
          }
          result_value = countChange_checking(money, coins)
        }
      result_value
    }






  }
