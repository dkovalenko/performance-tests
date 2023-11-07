compile:
	mvn clean compile

build:
	mvn clean package

benchmark: build
	java -jar target/benchmarks.jar

benchmark-sample-time: build
	java -jar target/benchmarks.jar -bm sample -tu ms
  
benchmark-throughput: build
	java -jar target/benchmarks.jar -bm thrpt -tu s

javap:
	javap -c target.classes.org.sample.IsDarkBenchmark > javap_IsDarkBenchmark.txt