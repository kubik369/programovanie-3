SRC ?= src
DST ?= build/classes
MAIN ?= Main

.PHONY: clean compile run

clean:
	rm -f $$(find $(DST) -name *.class)

compile:
	mkdir -p $(DST)
	javac -d $(DST) $$(find $(SRC) -name *.java)

run:
	java -ea -cp $(DST) $(MAIN)
