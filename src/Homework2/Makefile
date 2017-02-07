GS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
		Datum.java \
        Accelerometer.java \
        GPSDatum.java \
        BluetoothDatum.java\
		OnOffDatum.java\
		ScreenDatum.java\
	 

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
