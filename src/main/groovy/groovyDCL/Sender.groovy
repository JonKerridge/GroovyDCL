package groovyDCL

import jcsp.lang.CSProcess
import jcsp.lang.ChannelOutput

class Sender implements CSProcess{

  ChannelOutput toNext

  @Override
  void run() {
    println "Sender has started"
    for ( i in 1 .. 10) {
      def obj1 = new TestObject1(data1: i)
      toNext.write(obj1)
      println "Sender: ${obj1.toString()}"
    }
    println "Sender has finished"
  }
}
