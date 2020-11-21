//类型擦除和清单

//正如我们所知道的，类型信息在编译的时候会因为 擦除 而丢失。
// Scala的 清单（Manifests） 功能，使我们能够选择性地恢复类型信息。
// 清单提供了一个隐含值，根据需要由编译器生成。

class MakeFoo[A](implicit manifest: Manifest[A]) {
    def make: A = manifest.erasure.newInstance.asInstanceOf[A]
}

(new MakeFoo[String]).make