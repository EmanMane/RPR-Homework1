# Homework1
First homework on a course called "Development of software solutions"

University in Sarajevo
Faculty of Electrical Engineering Sarajevo
Subject: Development of program solutions 2022/2023

Task 1

Description of Tasks
It is necessary to create a Java Maven console application that will be used to parse and evaluate arithmetic expressions using the Dijkstra expression evaluation algorithm described in the paragraph below. The project should be uploaded to the github repository of each student. When submitting the assignment, you only need to submit a link to the github repository.

For implementation, it is necessary to do the following:

It is necessary to create an ExpressionEvaluator class that will have one public evaluate method that receives a parameter of type String and returns a result of type Double.
The ExpressionEvaluator class needs to use two instances of the java.util.Stack class to implement the Dijkstra algorithm.
It is necessary to create an App class that will have a main method that parses the input from the console from the args parameter and performs its validation.
It is necessary to create an ExpressionEvaulatorTest class that will have a minimum of 5 unit tests to check the correctness of the algorithm.
The project must have javadoc documentation on all classes and methods. It is also useful to add the ja maven javadoc plugin in order to be able to generate HTML documentation.
An input class with a main method must be declared in the maven jar plugin so that the compiled jar program can be invoked from the command line.
In case the entered expression is not arithmetically valid, the program should throw an exception of type RuntimeException. One of the unit tests must cover this case.
It is only necessary to implement the algorithm for expressions delimited by parentheses and which does not support operator precedence.
You can assume that all expressions will be space-separated for easier parsing of the input expression. The expression ( 1 + ( 5 * 20 ) ) is considered valid while the expression ( 1 + ( 5* 20)) is considered invalid. This is one convenience that will help you to code your homework more easily.

IMPORTANT NOTE:
Because of the input through the command line, the star operator will be replaced with 'x' (shell errors, basically the star symbol has a functionality in cmd and cannot be considered as input.
We could bypass this by writing "a '* 'b" but this simply looks ugly
