import java.io.{BufferedReader, File, FileReader}

/////////////////////////////////////////////////////////////////
/////////////////////////   隐式类型       ///////////////////////
/////////////////////////////////////////////////////////////////

//场景一，现在我们要为Java的File类提供一个获得所有行数的方法：
implicit class Files(file: File) {
    def lines: Array[String] = {
        val fileReader: FileReader = new FileReader(file)
        val reader = new BufferedReader(fileReader)
        try {
            var lines = Array[String]()
            var line = reader.readLine()

            while (line != null) {
                lines = lines :+ line
                line = reader.readLine()
            }
            lines
        } finally {
            fileReader.close()
            reader.close()
        }
    }
}

val filePath = "/home/pudgebd/hosts"
private val file: File = new File(filePath)

file.lines foreach println


//场景二，我期望可以像操作集合那样来操作一个文件中的所有行。比如，对所有的行映射（map）一个指定函数。

implicit def file2Array(file: File): Array[String] = file.lines

def map[R](source: Array[String])(fn: String => R) = {
    source.map(fn)
}

map(new File(filePath))(println)


/////////////////////////////////////////////////////////////////
//////////////////////   类型+隐式视图      ///////////////////////
/////////////////////////////////////////////////////////////////

class Strings(str: String) {
    def compress = str.filter(_ != ' ').mkString("")
}

implicit def strings(str: String): Strings = new Strings(str)

" a b c d ".compress
