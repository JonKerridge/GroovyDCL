package groovyDCL

import groovyJCSP.PAR
import jcsp.net2.NetChannel
import jcsp.net2.mobile.CodeLoadingChannelFilter
import jcsp.net2.tcpip.TCPIPNodeAddress
import jcsp.net2.Node

def sendIP = "127.0.0.1"
def po1IP = "127.0.0.2"
def po2IP = "127.0.0.3"

def sendAddress = new TCPIPNodeAddress(sendIP, 1000)
Node.getInstance().init(sendAddress)

def po1IPAddress = new TCPIPNodeAddress(po1IP, 1000)
def toNext = NetChannel.one2net(po1IPAddress, 1, new CodeLoadingChannelFilter.FilterTX())

def send = new Sender(toNext: toNext)

new PAR([send]).run()