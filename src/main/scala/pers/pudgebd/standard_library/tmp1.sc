val str = "a、b、c、d、e、f、g、h、i、j、k、l、m、n、o、p、q、r、s、t、u、v、w、x、y、z"
val arr = str.split("、")
val len = arr.length
val res = arr.mkString("'", "','", "'")