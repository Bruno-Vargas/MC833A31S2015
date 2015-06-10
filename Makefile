all: build

build:
	javac src/*.java

run: build
	cd src;\
		java Main ../data/data.dump;

server: build
	java -classpath src \
	-Djava.rmi.server.hostname=192.168.1.114 \
	LibraryServer data/data.dump

client: build
	java -classpath src \
	-Djava.rmi.server.hostname=192.168.1.114 \
	LibraryClient listTitlesAndYears

clean:
	rm -f src/*.class
