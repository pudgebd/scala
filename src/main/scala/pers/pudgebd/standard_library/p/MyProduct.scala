package pudgebd.standard_library.p

import com.sun.xml.internal.rngom.parse.host.Base

class MyProduct extends Product  { self: Base =>

  override def productElement(n: Int): Any = {
    n + 1
  }

  override def productArity: Int = {
    1
  }

  override def canEqual(that: Any): Boolean = {
    true
  }


  def getSelf: Base = {
    self
  }


}
