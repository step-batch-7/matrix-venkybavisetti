rm -rf out/*

javac -d out -cp lib/hamcrest-core-1.3.jar:lib/junit-4.13.1.jar $(find . -name "*.java" )

java -cp out:lib/hamcrest-core-1.3.jar:lib/junit-4.13.1.jar org.junit.runner.JUnitCore com.step.maths.MatrixTest