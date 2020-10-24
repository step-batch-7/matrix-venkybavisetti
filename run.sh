set -eu


rm -rf out/*
javac -d out -cp lib/hamcrest-core-1.3.jar:lib/junit-4.13.1.jar $(find . -name "*.java" )

TESTFILES=`find test -name "*Test.java"|sed "s/test\///"|sed "s/.java//"|sed "s/\//./g"`

java -cp out:lib/hamcrest-core-1.3.jar:lib/junit-4.13.1.jar org.junit.runner.JUnitCore $TESTFILES