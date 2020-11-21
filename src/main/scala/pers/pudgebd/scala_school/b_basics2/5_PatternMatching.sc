val times = 1

times match {
    case 1 => "one"
    case 2 => "two"
    case _ => "other"

}


def bigger(any: Any): Any = {
    any match {
        case i: Int if i < 0 => i - 1
        case i: Int => i + 1
        case d: Double if d < 0.0 => d - 0.1
        case d: Double => d + 0.1
        case s: String => s + "_Str"
    }
}

bigger(12)

