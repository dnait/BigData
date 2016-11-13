package ScalaHandsOn

object StringCharFun {
  def main(args: Array[String]) {
        
    //create a list of alphanumeric characters
    val chars = 'a' to 'z'    //NumericRange.Inclusive[Char] = NumericRange(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z)
    val chars2 = ('a' to 'z') ++ ('A' to 'Z')  //immutable.IndexedSeq[Char] = Vector(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z)
  
    //first letter will be capitalized
    val name = "this is my day"
    println(name.capitalize)        //String = This is my day
    
    //.toUpperCase
    println(name.toUpperCase())
    
    //repeat string for multiple times  str * times
    val letters = "abc" * 3        //String = abcabcabc
    val sign = "-" * 30            //String = ------------------------------
    
    //reverse
    val id = "x100"
    println(id.reverse)            //String = 001x
    
    //equal
    val id1 = "x100"
    val id2 = "x" + "100"
    println(id1.equals(id2))       //Boolean = true
    
    //complex equal function
    iscombineequals("abcd", "ab", "cd")        //abcd, true
    iscombineequals("catdog", "cat", "dog")    //catdog, true
    iscombineequals("xxyy", "ef", "gh")        //xxyy, false

       
    // use \n line, like iterator
    val pet = "cat\nbird\nfish and dog"
    for (line <- pet.lines) println(line)
    //cat
    //bird
    //fish and dog
    
    //repeat
    
  
  }
  
  def iscombineequals(combine: String, left: String, right: String): Unit = {
    if (combine == left + right) println(s"$combine, true") else println(s"$combine, false")
  }
}