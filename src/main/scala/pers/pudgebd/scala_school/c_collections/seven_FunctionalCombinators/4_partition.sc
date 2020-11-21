//partition将使用给定的谓词函数分割列表。
val numbers = List(1, 2, 3, 4, 5, 6)

numbers.partition(_ % 2 == 0)