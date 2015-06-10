all: build

build:
	javac src/*.java

run: build
	cd src;\
		java Main ../data/data.dump;

server: build
	java -classpath src \
	-Djava.rmi.server.hostname=192.168.1.156 \
	MovieRentalServer

client: build
	java -classpath src \
	-Djava.rmi.server.hostname=192.168.1.156 \
	MovieRentalClient listTitlesAndYears

clean:
	rm -f src/*.class
