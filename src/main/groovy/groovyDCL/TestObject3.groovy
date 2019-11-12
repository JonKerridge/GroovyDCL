package groovyDCL

class TestObject3 implements Serializable{

  int data3
  TestObject2 to2

  String toString(){
    String s = "TO3: $data3 plus ${to2.toString()}"
    return s
  }
}
