package groovyDCL

import jcsp.lang.CSProcess
import jcsp.lang.ChannelInput
import jcsp.lang.ChannelOutput

class PassOn2 implements CSProcess{

  ChannelInput fromPrevious
//  ChannelOutput toNext
  int offset2

  @Override
  void run() {
    for ( i in 1..10){
      TestObject2 in2 = fromPrevious.read()
      TestObject3 out3 = new TestObject3 (data3: offset2, to2: in2)
      println " PassOn2: ${out3.toString()}"
      offset2 += 1000
    }
  }
}
