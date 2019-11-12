package groovyDCL

class TestObject1 implements Serializable {
  int data1

  String toString() {
    String s = "TO1: $data1"
    return s
  }
}
