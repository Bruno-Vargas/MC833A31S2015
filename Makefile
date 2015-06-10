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
	MovieRentalClient $(ARGS)

test1: build
	java -classpath src \
	-Djava.rmi.server.hostname=192.168.1.156 \
	MovieRentalClient listTitlesAndYears

test2: build
	java -classpath src \
	-Djava.rmi.server.hostname=192.168.1.156 \
	MovieRentalClient listByGenre 0

test3: build
	java -classpath src \
	-Djava.rmi.server.hostname=192.168.1.156 \
	MovieRentalClient synopysis 1

test4: build
	java -classpath src \
	-Djava.rmi.server.hostname=192.168.1.156 \
	MovieRentalClient info 5

test5: build
	java -classpath src \
	-Djava.rmi.server.hostname=192.168.1.156 \
	MovieRentalClient list

test6: build
	java -classpath src \
	-Djava.rmi.server.hostname=192.168.1.156 \
	MovieRentalClient update 4 15

test7: build
	java -classpath src \
	-Djava.rmi.server.hostname=192.168.1.156 \
	MovieRentalClient quantity 3

clean:
	rm -f src/*.class
