compile:
	mvn clean compile

build:
	mvn clean package

benchmark: build
	java -jar target/benchmarks.jar
  