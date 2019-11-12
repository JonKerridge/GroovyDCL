package groovyDCL

class TestObject2 implements Serializable {

  int data2
  TestObject1  to1

  String toString(){
    String s = "TO2: $data2 plus ${to1.toString()}"
    return s
  }
}
