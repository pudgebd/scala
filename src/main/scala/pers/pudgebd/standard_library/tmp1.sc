//val str = "a、b、c、d、e、f、g、h、i、j、k、l、m、n、o、p、q、r、s、t、u、v、w、x、y、z"
//val arr = str.split("、")
//val len = arr.length
//val res = arr.mkString("'", "','", "'")

val listLR = List(3, 4, 5)
//2 + 3*2 = 8
//8 + 4*2 = 16
//16 + 5*2 = 26
listLR.iterator.foldLeft(2)((a, b) => a + b*2)