SRC ?= src
DST ?= build/classes

.PHONY: clean compile run-dnd run-workbalance

clean:
	rm -f $$(find $(DST) -name *.class)

compile:
	mkdir -p $(DST)
	javac -d $(DST) $$(find $(SRC) -name *.java)

run-dnd:
	java -ea -cp $(DST) dnd.Main

run-workbalance:
	java -ea -cp $(DST) workbalance.Main
