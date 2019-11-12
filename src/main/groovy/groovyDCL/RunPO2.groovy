package groovyDCL

import groovyJCSP.PAR
import jcsp.net2.NetChannel
import jcsp.net2.Node
import jcsp.net2.mobile.CodeLoadingChannelFilter
import jcsp.net2.tcpip.TCPIPNodeAddress

def sendIP = "127.0.0.1"
def po1IP = "127.0.0.2"
def po2IP = "127.0.0.3"

def po2IPAddress = new TCPIPNodeAddress(po2IP, 1000)
Node.getInstance().init(po2IPAddress)

def fromPrevious = NetChannel.numberedNet2One( 1, new CodeLoadingChannelFilter.FilterRX())

def po2 = new PassOn2(fromPrevious: fromPrevious)

new PAR([po2]).run()

