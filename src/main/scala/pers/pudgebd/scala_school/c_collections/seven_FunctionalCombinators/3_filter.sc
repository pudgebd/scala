val nums = Array(1, 2, 3, 4, 5, 6)

//filter移除任何对传入函数计算结果为false的元素。返回一个布尔值的函数通常被称为谓词函数[或判定函数]。
nums.filter((i: Int) => i % 2 == 0)

def isEven(i: Int): Boolean = i % 2 == 0
nums.filter(isEven)