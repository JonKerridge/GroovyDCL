package groovyDCL

import jcsp.lang.CSProcess
import jcsp.lang.ChannelInput
import jcsp.lang.ChannelOutput

class PassOn1 implements CSProcess{

  ChannelInput fromPrevious
  ChannelOutput toNext
  int offset1

  @Override
  void run() {
    for ( i in 1..10){
      def in1 = (TestObject1)fromPrevious.read()
      TestObject2 out2 = new TestObject2 (data2: offset1, to1: in1)
      toNext.write(out2)
      println " PassOn1: ${out2.toString()}"
      offset1 += 100
    }
  }
}
