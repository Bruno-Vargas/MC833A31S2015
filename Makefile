all: build

build:
	javac src/*.java

run: build
	cd src;\
		java Main ../data/data.dump;

server: build
	java -classpath src \
	-Djava.rmi.server.hostname=localhost \
	-Djava.rmi.server.codebase=file:$(HOME)/Downloads/carta_aos_missionarios/projeto03/src/ \
	Rental data/data.dump

client: build
	java -classpath src \
	-Djava.rmi.server.hostname=localhost \
	LibraryClient $(ARGS)

clean:
	rm -f src/*.class
