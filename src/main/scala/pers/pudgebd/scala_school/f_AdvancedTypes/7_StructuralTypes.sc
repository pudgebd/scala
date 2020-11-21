//结构类型
//Scala 支持 结构类型 structural types — 类型需求由接口 构造 表示，而不是由具体的类型表示。

def foo(x: {def get: Int}) = 123 + x.get

foo(new { def get = 10 })

//这可能在很多场景都是相当不错的，但这个实现中使用了反射，所以要注意性能！
