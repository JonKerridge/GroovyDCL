package groovyDCL

import groovyJCSP.PAR
import jcsp.lang.Channel


def send2PO1 = Channel.one2one()
def PO1toPO2 = Channel.one2one()

def send = new Sender(toNext: send2PO1.out())
def po1 = new PassOn1(fromPrevious: send2PO1.in(),
    toNext: PO1toPO2.out(),
    offset1: 100)
def po2 = new PassOn2(fromPrevious: PO1toPO2.in(),
    offset2: 1000)

new PAR([send, po1, po2]).run()