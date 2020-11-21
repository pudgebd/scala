//drop 将删除前i个元素

val nums = List(1, 2, 3, 4, 5, 6)
nums.drop(5)

//dropWhile 将删除元素直到找到第一个匹配谓词函数的元素。例如，如果我们在numbers列表上使用dropWhile奇数的函数, 1将被丢弃（但3不会被丢弃，因为他被2“保护”了）。

nums.dropWhile(_ % 2 != 0)