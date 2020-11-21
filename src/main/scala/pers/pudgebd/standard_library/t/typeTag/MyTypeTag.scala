package pudgebd.standard_library.t.typeTag

import com.sun.tools.javac.code.TypeTag
import com.sun.xml.internal.bind.v2.model.core.TypeRef

import scala.reflect.ClassTag

object MyTypeTag {

  def main(args: Array[String]): Unit = {
    val list = List(1, "string1", List(), "string2")
    val result = extract[String](list)
    println(result) // List(1, string1, List(), string2)
  }

  //提取了非string
  def extract[T](list: List[Any]) = list.flatMap {
    case element: T => Some(element)
    case _ => None
  }

  //只提取string
  def extractWithCt[T: ClassTag](list: List[Any]) = list.flatMap {
    case element: T => Some(element)
    case _ => None
  }

//  def paramInfo[T](x: T)(implicit tag: TypeTag[T]): Unit = {
//    val targs = tag.tpe match {
//      case TypeRef(_, _, args) => args
//    }
//    println(s"type tag of $x has type arguments $targs")
//  }
//
//
//  def weakParamInfo[T](x: T)(implicit tag: WeakTypeTag[T]): Unit = {
//    val targs = tag.tpe match {
//      case TypeRef(_, _, args) => args
//    }
//    println(s"type tag of $x has type arguments $targs")
//  }

}
