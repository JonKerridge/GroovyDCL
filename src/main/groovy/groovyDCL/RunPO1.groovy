package groovyDCL

import groovyJCSP.PAR
import jcsp.net2.NetChannel
import jcsp.net2.mobile.CodeLoadingChannelFilter
import jcsp.net2.tcpip.TCPIPNodeAddress
import jcsp.net2.Node

def sendIP = "127.0.0.1"
def po1IP = "127.0.0.2"
def po2IP = "127.0.0.3"

def po1IPAddress = new TCPIPNodeAddress(po1IP, 1000)
Node.getInstance().init(po1IPAddress)

def fromSend = NetChannel.numberedNet2One(1, new CodeLoadingChannelFilter.FilterRX())

def po2IPAddress = new TCPIPNodeAddress(po2IP, 1000)
def toNext = NetChannel.one2net(po2IPAddress, 1, new CodeLoadingChannelFilter.FilterTX())

def po1 = new PassOn1(fromPrevious: fromSend, toNext: toNext)

new PAR([po1]).run()


