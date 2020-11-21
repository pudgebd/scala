val nums = Array(1, 2, 3, 4, 5, 6)


//map对列表中的每个元素应用一个函数，返回应用后的元素所组成的列表。
nums.map((i: Int) => i * 2)

//或传入一个部分应用函数
def timesTwo(i: Int): Int = i * 2
nums.map(timesTwo _)