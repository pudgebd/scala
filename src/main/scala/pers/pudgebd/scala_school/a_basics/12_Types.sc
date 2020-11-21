//类型(泛型?)
trait Cache[K, V] {

    def get(key: K): V

    def put(key: K, value: V)

    def del(key: K)

}

def remove[K](key: K)