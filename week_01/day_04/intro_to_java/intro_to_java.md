# Intro to Java: Our First Program

## What Java Is
As we mentioned in the our [Intro to Programming](../../../programming_fundamentals/what_is_programming.md) chapters, a programming language is a means for us, as programmers, to write instructions which the computer can understand. Programming languages can be high-level (more human readable), or low level (more machine-readable). The most low level language is called binary—which is composed of only 0's and 1's. This is the language in which a computer's processor *thinks*.

Since humans don't think in binary, we need intermediary languages which fall somewhere between machine code (binary) and human languages (such as English). This is where **high-level languages**, such as Java, come in to play: we write our code in Java,  which then it gets **compiled** down to a lower level language, called **bytecode**. Bytecode runs almost as fast as binary, via a JVM (Java Virtual Machine). 

### Cross-platform
Java is cross-platform—this means you can **write anywhere, run anywhere**. You can write Java code on any major OS, compile it, and the bytecode it generates **will run on any machine with a valid JVM**. That's fantastic! Not all programming languages move from system to system with that kind of ease.



## Our First Java Program with IntelliJ
You could write your first Java program in a plain text editor and run it from the terminal if you wanted to, but instead we'll use IntelliJ, because it's a good IDE with a lot of cool features like intellisense, code completion, boilerplate automation etc. If any of those terms sound foreign, don't worry, it'll all become clearer soon.

### Please launch IntelliJ and select **New Project**:
![Creating a new java project](../../../assets/java/intro_to_java/create_new_project.png)

- **Name** the project `GettingStarted`

- Check your **JDK** value. The default setting of `17` is fine

- Tick `"Add sample code"`

- For our **Module Name**, let's go with `com.bnta`:

You should now see the following, with a bare-bones `Main.java` class generated for you by IntelliJ:

![A fresh Java project in IntelliJ](../../../assets/java/intro_to_java/new_project.png)

Press the **Run** button alongside the code snippet (white box below) to execute the program:

![Running our new Java project](../../../assets/java/intro_to_java/running_main.png)

Once you have executed the code once by this means, you can run the same configuration again from the top panel, using the button outlined in yellow.

As shown within the image, you should see "Hello World!" printed in the console. 

**Congratulations**, you've just built and run your very first Java program!


## Compiling and Running using **Terminal**

As mentioned before, you don't actually need an IDE to write, build or run Java code. It can be done just using the terminal. Let's learn how to do it that way now:

1. Open the terminal inside **IntelliJ**
2. `cd src`
3. `javac com/bnta/Main.java` - This creates a file called `Main.class`
4. `java com.bnta.Main`

You should see `Hello World` in the terminal. The full terminal printout after completing the above sequence of operations should look something like this:

```
~ path-to-directory\GettingStarted cd src
~ path-to-directory\GettingStarted\src javac com/bnta/Main.java
~ path-to-directory\GettingStarted\src java com/bnta/Main

Hello World 
```

> After running the compiler with **javac** (compiler), notice the **new Main.class** file in *src/com/bnta/* - this is the class in it's **compiled** form

If you would like to use the default terminal provided within the MacOS, then note that between Steps 1 and 2 above, you will need to move to the relevant directory.

## Create Command-line Launcher
While we're here, it will be very useful to enable the Command-line Launcher for Intellij. 

Click on the `Tools` menu at the top of your screen and select `Create Command-line Launcher...`. A pop-up should appear asking what your script should be called and where it should be stored. Intellij should have made a sensisble suggestion for you (usually: `/usr/local/bin/idea`).
Click `OK`.

You will now be able to launch Intellij from Terminal.

## Bytecode

In our intro above, we mentioned that Java compiles to a low-level language called bytecode. This is what the Java Virtual Machine (JVM) **understands**. There are a few other languages which similarly compile to bytecode: 

- Groovy
- Scala
- Kotlin
- Closure

This means that we only need to have the **JDK** installed to write and run code in any of the above languages.

Our beginners Java example is shown below:

```java
package com.bnta;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("Hello World");
    }
}
```

If we wanted to have a look into how the bytecode corresponds for this example we need to first ensure that the correct file is selected:

Select the file called `Main` under `GettingStarted/out/production/GettingStarted/com/bnta`

![Screenshot 2021-08-17 at 18 15 40](../../../assets/java/intro_to_java/select-main.jpg)

Next, select **View** from the primary navigation bar and then **"Show Bytecode"** as shown below

![Screenshot 2021-08-17 at 18 18 04](../../../assets/java/intro_to_java/show-byte-code.jpg)

You should see a preview of the generated byte code, as follows:

![Screenshot 2021-08-17 at 18 18 26](https://user-images.githubusercontent.com/40702606/129771733-aa00a7d5-16d7-4d55-97c9-b77ef676f84f.png)

The above code is what is fed to the JVM to run our program. You don't need to understand it or be able to write it - just know that under the hood, the code you write is compiled into this language before it is run by the JVM.

Note that this bytecode is both longer than our original code and harder to parse. While it may take a little while as a beginner to get your head around the structure of a Java application, know that it has been built in such a way that additional information is provided to a dev easily and efficiently. 

For example, the nested structure of our application, with our print statement housed within our `main` method of the `Main` class, quickly communicates relationships within our application. This is information which is more difficult to isolate within the bytecode as there is a lot more code returned to the developer within this view.

## Video Recap
![type:video](../../../assets/java/intro_to_java/1-java-intro.mp4)
