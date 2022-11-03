# Control Flow

### Lesson duration: 60mins

## Lesson Objectives
- Understand what is conditional logic
- When and why use conditional logic
- How to check for equality
- How to use conditional operators
- Understand `if`, `else if`, `else` statements
- An intro to Pseudo Code
- A brief introduction to Scanner
- Ternary Operators
- How to use logical operators (&& / ||)

## Intro
Now that we know something about data types in Java, we can move on to consider some aspects of how our code is structured.

We make decisions based on data all the time. If the weather is hot, we may decide to wear a hat. If it's raining, we may decide to bring an umbrella.

We can think of these outcomes as the result of a 'yes' or 'no' question:

- Is the temperature above 20 degrees? *yes* (outcome: wear a hat)
- Is it raining? *no* (outcome: leave umbrella at home)

We can structure our code in a very similar way. We can give our programs a 'statement', which the computer will then 'evaluate' (to `true` or `false`). This 'evaluation' allows the program to decide what should happen if certain conditions are met. The abilty to write programs that control the flow of the code according to changing conditions is a very powerful tool.

Let's begin by creating a new project.

> Alternatively you could create a new file in the previous lesson's project

Open Intellij and click on `New Project`. Give your project a name (`control_flow`) and a location to save it (the best place is your `bnta_coursework` folder).

Ensure `Java` and `Maven` and `17 Oracle OpenJDK...` are selected, then click `Create`.

Open your `src` directory and right-click on your blue `java` folder. Select `New` > `Java Class`. Give your class the name `ControlFlow`.

As we now know, every Java program needs a `main` function to run, so let's add one in. We can also add in a print statement to check all is working as expected. Run your `main` method to see `"Hello from ControlFlow" in your Terminal.

```java
// ControlFlow.java

public class ControlFlow {

    public static void main(String[] args){
        System.out.println("Hello from ControlFlow");
    }
}
```

## Conditional Operators
Conditional operators are used for checking conditions. Most of it is straightfoward to understand, but the logic can get complicated once we move past simple examples.

### `>` is greater than
Used to evaluate whether the object on the left is greater than the object on the right.

```java
// ControlFlow.java

public class ControlFlow {

    public static void main(String[] args){
        System.out.println(5 > 3); // true
        System.out.println(4 > 9); // false
    }
}
```

### `<` is less than
Used to evaluate whether the object on the left is less than the object on the right.

```java
        
        System.out.println(2 < 3); // true
        System.out.println(10 < 3); // false

```

### `>=` and `<=`
These are variants of the greater than and less than operators, and mean "greater than or equal to" or "less than or equal to".

```java
        
        System.out.println(2 <= 2); // true
        System.out.println(10 <= 3); // false
        System.out.println(10 >= 10); // true

```

## Checking for Equality
Very often we will want to check if something is *the same* as something else. In Java there are a couple of ways in which we can check for equality: `==` and `equals()`. The differences between them are subtle and may take some time to understand.

### `==`
The `==` operator is used for *reference comparison*. In other words, it is checking if both objects point to the same location in memory. As a rule of thumb, we can usually use `==` with primitive types.

Take care not to confuse this with the assignment operator `=`.

### `.equals()`
The `equals()` method is used for *content comparison*. In other words it checks the content/values in the object are the same. Best used when comparing Strings and objects.

As you become more experienced in Java, you may need to put some thought into which kind of equality you're looking for, as using the 'wrong' one can lead to hard-to-catch bugs.

```java
        System.out.println(5 == 3 + 2); // true
        System.out.println(10 == 3 * 3); // false
        System.out.println("cat".equals("cat")); // true
```

> Note: `"cat" == "cat"` will return true in this case, but we have to bear in mind that how we create Strings will have an impact on what we are trying to test. Whether we create string literals or string objects will make a difference to how they are stored and referenced. More on this later, after we learn about classes and the objects we create from them.


## if statements (if, if else, else)
We can ask Java to excecute code, only if certain conditions are met.

Let's suppose we want to write a simple program that allows to take an input from a user and return an output based on an evaluation of that input.

Let's create a new file in our our project. Right-click on your blue Java file and select `New` > `Java Class`. Call your class `WhatChocolate`. 

## Psuedo Code
One of the most powerful coding tools we can show you. It is used for humans to read (rather than machines), you can think of it as a natural language version of the code you intend to write. 
A bit like planning out an essay, the idea is to do your thinking in advance. 

> Tip: Psuedo Code is a very useful tool for technical interviews. We will go into greater depth about the preparing for the technical interview in week 4 or 5.

Let's break down our program into smaller steps

```java

public class WhatChocolate{

    public static void main(String[] args){
        // Prompt a user to input their favourite chocolate
        // Collect user input
        // if chocolate is bounty, print 'Gross'
        // otherwise print 'yum'
    }

}

```

This is a very simple example of pseudo code, but the technique is very helpful for more complex problems.

### Scanner
The first step in our plan requires user input. The simplest way of doing this is Java is to use the `Scanner` class. Let's import it and use it within our code.

```java
import java.util.Scanner;   // ADDED

public class WhatChocolate{

    public static void main(String[] args){
        // Prompt the user to input their favourite chocolate
        System.out.println("What is your favourite chocolate?");  //ADDED 

        // Collect user input
        Scanner reader = new Scanner(System.in); // ADDED (creates a Scanner object)
        String favouriteChocolate = reader.nextLine(); //ADDED (read user input)

        // if chocolate is bounty, print 'Gross'
        // otherwise print 'yum'
    }

}

```

We will talk about the classes and objects later in the course, but for now it is best to accept that we have created an Scanner object which allows us to use methods that grab user input. Run your program to check the prompt is working.

We can now use control flow to determine what sort of output we want from our program, depending on the conditions we describe.

```java
import java.util.Scanner;   

public class WhatChocolate{

    public static void main(String[] args){
        // Prompt the user to input their favourite chocolate
        System.out.println("What is your favourite chocolate?");  

        // Collect user input
        Scanner reader = new Scanner(System.in); 
        String favouriteChocolate = reader.nextLine(); 

        // if chocolate is bounty, print 'Gross'
        // otherwise print 'yum'
        if (favouriteChocolate.equals("Bounty")){ // ADDED
            System.out.println("Gross");
        } else {
            System.out.println("Yum");
        }
    }
}

```
Run your code to check it works, test both outcomes.

Let's suppose we wish to test another condition. We can do so using the ` if else` clause. 

```java
import java.util.Scanner;   

public class WhatChocolate{

    public static void main(String[] args){
        // Prompt the user to input their favourite chocolate
        System.out.println("What is your favourite chocolate?");  

        // Collect user input
        Scanner reader = new Scanner(System.in); 
        String favouriteChocolate = reader.nextLine(); 

        // if chocolate is bounty, print 'Gross'
        // otherwise print 'yum'
        if (favouriteChocolate.equals("Bounty")){ 
            System.out.println("Gross");
        } else if (favouriteChocolate.equals("Crunchie")) { //ADDED
            System.out.println("The best!");  // ADDED
        } else {
            System.out.println("Yum");
        }
    }
}

```
Run your code to check it works, test all outcomes.

## Ternary Operators (short hand `if...else`)

It can be very useful to know about ternary operators. They act as a sort of short hand for if else statements.

The structure of a ternary operator looks like this:

`variable = (condition) ? expressionTrue : expressionFalse;`

We can could refactor our first `if...else` statement like so:

```java
String result = favouriteChocolate.equals("Bounty") ? "Gross" : "Yum";
System.out.println(result);
```


## Logical Operators (&& and ||)
Logical operators are used to determine the logic between variables and/or values. They allow us to check more than one condition.

### `&&` logical and
For an expression created with `&&`, *both* expressions on either side of the operator must evaluate to `true` if the whole statement is to return `true`.

In your `control_flow` project, right-click on your blue java file and create a new Java class called `LogicalOperators`. Create a new `main()` method to run your code.

```java

public class LogicalOperators {

    public static void main(String[] args) {

        boolean labHandedIn = true;
        boolean studentPresent = true;

        if (labHandedIn && studentPresent) {
            System.out.println("Happy trainers");
        } else {
            System.out.println("Sad trainers");
        }

    }

}

//  Output: "Happy trainers"

```
Run the code and you should see that your program outputs `Happy trainers`. If you changed just one of the conditions to false, your program would output `Sad trainers`.

Note that as both conditions must be true, both conditions will be checked.

```java

public class LogicalOperators {

    public static void main(String[] args) {

        boolean labHandedIn = true;
        boolean studentPresent = false; // MODIFIED

        if (labHandedIn && studentPresent) {
            System.out.println("Happy trainers");
        } else {
            System.out.println("Sad trainers");
        }

    }

}

// Output: "Sad trainers"

```


### `||` logical or
For an expression created with `||`, *one* expression on either side of the operator must evaluate to `true` if the whole statement is to return `true`.

Note that as only one condition needs to be `true`, if the first statement is `true`, the second statement will not be checked.

```java

public class LogicalOperators {

    public static void main(){

    // ...

        boolean hasTraining = true; // ADDED
        boolean hasExperience = false;  // ADDED

        if (hasTraining || hasExperience){  // ADDED
            System.out.println("Hired!")
        }

    }

}

```

## Self-study: Switch statements
Switch statements can be useful, especially if you think you will need to write many ``if``/``else`` statements. It's just a slightly different syntax, intented to make the syntax cleaner and more terse when handling many cases which all depend on one common variable. Generally, excessive use of ``if``/``else``/``switch`` statements are not preferred in object oriented design (see Bob Martin), since the use of them can lead to unnecessarily complex dependency chains. Like most things in programming, it comes down to context.

[Orcale docs on switch statements](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html)
