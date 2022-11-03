# What is Programming?

Life as we know it would be drastically different if it wasn't for the computers we use multiple times every day. Every aspect of our lives involve a computer in some way, even if there are several degrees of separation between them. Some things are only possible because we now have access to the processing and networking power of computers but other things have been changed beyond recognition by the addition of IT.

Think about the process you went through last time you bought something mail-order. As little as thirty years ago you would have browsed a paper catalogue to find the item you wanted, filled in an order form and posted it away along with a cheque to cover the cost. When it arrived at its destination someone had to open it, manually look up records to find where the item was in the warehouse then take it down off the shelf and package it. The box got taken to the post office (assuming the cheque cleared) and made its way to you. The whole process could take weeks.

Fast forward just ten years and the landscape has changed already. The catalogue has been replaced with a website and the trip to the post office is now a simple button click. We don't need to write cheques any more, we can securely send our bank details to a vendor for them to take payment. At the other end the order appears on a screen and can be cross-referenced against a database listing the stock levels and warehouse location of the items which have been ordered.

Bring it even further forward to today and things have changed further. We no longer need a PC to access the website, we can do that using our phones (which are more powerful than those 20-year old computers anyway). Information about stock levels is not only available to the customer, we can even see how many other people are browsing the same thing and we get suggestions about things they bought which we might be interested in. The bank we're paying from doesn't even have a physical building any more, everything is digital. The warehouse might not even have a human reading our order; robotic sytems collect items from shelves, package them up and attach them to drones for delivery. The whole process has shrunk from a couple of weeks to a couple of hours.

These changes are mirrored across many aspects of society and all have something in common: computers. They are incredibly powerful and may seem complex, but in fact they are the result of learning how to use a few specific tools very effectively. In fact interacting with them can be a surprisingly straight-forward process. 


## Architecture of a Computer

It might be a straight-forward process on our end but there is a *lot* happening under the lid to translate our instructions into something the computer can understand. Remember that it's just pieces of silicon connected together by copper and thrown into a metal box. How can any of that make sense of `print("Hello world!")`?

Among those pieces of silicon are billions of transistors and capacitors, tiny electrical components which manage the flow of current and store electrons which are moving through the system. Different parts of the system translate our instructions into pulses of electricity which are directed around the system in order to store, retrieve and manipulate data. Each part of the system interacts with those instructions in a different way, ultimately coming together to execute the program.

### CPU

The **Central Processing Unit** (**CPU**) is the computer's "brain". Every instruction we give passes through here before being sent off to the appropriate part of the system with the results coming back to be processed themselves. The CPU's job is to managed the flow of electrons through its circuits in such a way that our instructions are correctly executed.

Even the very first computers had some notion of a CPU, although they were purely mechanical machines. The mechanisms within Babbage's computation engine enabled its users to manipulate it in such a way that for any given input the same output would always be returned. Changes in the inputs would have a corresponding change in the output. The process of using the machine was slow and complex though, not to mention the engineering time required to build it. The arrival of electricity and the invention of the vacuum tube sped the process up but didn't simplify it, and in fact led to a significant increase in the size and complexity of the hardware.

|![vacuum tube computer](../../../assets/programming_fundamentals/what_is_programming/tube_computer.png)|
|:--:|
|*A vacuum tube computer from 1946*|

Each tube in those early electrical computers could either have a current applied or not, it was either "on" or "off". The way in which current flowed through these tubes determined the output of whatever operation was being performed. They were big, power-hungry and difficult to program but many times quicker than a human and as such found their niche doing complex calculations. Famous examples include the bombe machines used at Bletchley Park to crack the Enigma code during the Second World War.

When the transistor was invented in 1947 it became possible to replicate the workings of a vacuum tube on a much smaller scale. The fundamental principle of current flowing through a circuit still applied but it became possible to build smaller, moveable computers. These computers were still significantly larger than what we are used to today but they no longer had to be stored in large buildings. Writing programs was still a laborious process but as computers became more powerful programmers could do more with them.

A transistor can only be in one state at a time, meaning it can only be involved with one operation. In order to make a computer more powerful, i.e. able to complete more operations in the same amount of time, more transistors had to be added. Improvements in manufacturing processes led to a shrinking in the size of transistors, helping the drive towards the invention of the microprocessor. As transistors got smaller more of them could be added to a computer, making it more powerful without growing in size. In 1965 the engineer Gordon Moore made a prediction that became known as [Moore's Law](https://en.wikipedia.org/wiki/Moore%27s_law): that every two years the number of transistors in a microprocessor would double, leading to more powerful systems. That trend has broadly held up, with each of Apple's newest chips holding *57 billion* transistors, each only 5 nanometers in size.

|![moores law](../../../assets/programming_fundamentals/what_is_programming/moores_law.png)|
|:--:|
|*An illustration of how transistor count has increased in line with Moore's Law*|

### Storage

A key part of the growth in the importance of computers has been their ability to retain and recall information. Back in the days of the vacuum tube the only way to record the outcome of running a program was for the user to make a note of it. If that information was needed again at a later date the program had to be re-entered and re-run, a time-consuming process as we have already discussed. 

To address this enginners began developing tools to encode both the instructions given to a computer and their output. The first hard drive went into production in 1956 and consisted of discs (or "platters") with thin magnetic coatings. An electromagnet passed over the discs writing tiny areas of magnetic north or south to represent the "on" and "off" states of the transistors in the system. Separate magnets could be used to read the information and recreate the process over and over again. This technology was the backbone of computer storage for more than half a century, only being replaced by solid-state drives in recent years, and is still the go-to system for high-density uses such as file servers.

What *did* change was the size. The first hard-disk drive (or **HDD**) was the size of a couple of fridges and cost $50,000, equivalent to just over half a million dollars today when adjusted for inflation. That money got the buyer 5MB of storage which at the time was a ridiculously large amount of space. Today it would be *just* enough for two photos taken on a smart phone, if you lowered the settings a bit. Just like with the transistors in CPUs though, improvements to the manufacturing process mean that today we can buy HDDs which are the size of a small paperback and can store over 10TB of data.

|![IBM 350](../../../assets/programming_fundamentals/what_is_programming/ibm_350.png)|
|:--:|
|*A pair of IBM 350s, the first commercially available HDDs*|

Modern solid-state drives (**SSDs**) work on a similar principle but instead of moving mechanical parts they use special transistors which can retain their charge when powered off. Passing current through these transistors has the same result as passing an electromagnet over an HDD's platters but is a *much* quicker process. The same technology is used in USB flash drives and memory cards in other devices. So-called "flash" storage is quicker to read and write to than a mechanical system and is usually smaller, making it the preferred choice for modern systems. However that efficiency comes at a price and SSDs are much more expensive than similarly-sized HDDs.

### RAM

A modern computer needs to store information about many aspects of its operation. Modern storage devices are big enough to handle it all but they are pretty slow in doing so, at least in computing terms. Even the much faster SSDs aren't fast enough to hanlde all the little bits and pieces a computer needs to run smoothly without a noticeable drop in performance.

The answer to this is **Random-Access Memory**, or **RAM**. RAM is a special type of super-fast memory which is used to store information the system needs to access quickly or which are relevant to the current operation. Unlike an SSD RAM can't retain the information stored in it when the system is powered down. It can be purchased with varying speeds, but size is the most significant factor. A system with more RAM will be able to run more simultaneous processes, or more complex ones. For us to comfortably use a modern computer, for example with an email client, web browser and one or two programs such as photoshop running at the same time, requires multiple gigabytes of RAM.

It is RAM that will have the biggest effect on the programs which we will be writing. The files containing our code will be kept on our laptop's SSD but some aspects of our programs will need to temporarily store information on our systems. When we create a variable, for example, the name we give it and the values we assign to it need to be stored. If we do this using the SSD it will slow our programs down by quite a margin, so instead these values are stored in the RAM. 

Each piece of information we store in this way has its own **memory location**. The programs running our code use these locations to quickly and accurately identify the values needed for their execution. A section of the RAM is allocated for use when our code runs and this is where our values are stored. As values are created they are added to this memory section, also known as the **stack**. Items are added and removed from the stack as our code is executed.

The code we will write in this course is unlikely to be particularly resource-hungry, but it will be a future consideration and may be an issue here if something goes wrong. Our stack is a finite space and needs redundant information to be removed from it after we are finished with it. Most langauges, including those we will be using, have a built-in feature known as **garbage collection** which will take care of this for us but some do not. As redundant data builds up in the stack it can negatively impact the performance of an application, a scenario known as a **memory leak**. Eventually we will reach a point where there is no space in the stack for new data and the program will crash. We are unlikely to find ourselves in this scenario but there are some scenarios where it may happen, for example if we write an infinte loop in our code.

The way in which we make use of the system's memory will have the biggest impact on how well our programs run. As we go through this course we will learn more about different **data structures** and how each of them makes use of memory in different ways. We will also look at some common **algorithms** for searching and sorting data and discuss ways in which we can use them most efficiently.


## History of Programming Languages

So far we have spoken a lot about the low level details of how a computer works, the on/off states of the transistors and how the circuits fit together. We aren't standing next to a computer manually switching things on and off, so how are we making them do what we want them to do?

Our instructions are relayed to a computer in the form of **programs**. As Charles Babbage developed the analytical engine and built the first computer, the mathematician Ada Lovelace was writing the first programs which it would run. Her programs took a long time to write as they had to give detailed instructions to the machine. Step forward to the tube age and things haven't changed much, and even now at the lowest level we have very detailed instructions in the form of the sequence of 0s and 1s we know as **binary**.

Thankfully we don't communicate with computers using binary, it would take forever. Instead we type on a keyboard, click a mouse or even talk to a device sat on our desk. Converting these high-level thoughts and ideas into something the CPU can understand and act upon is doen using **programming languages**.

These languages each have a purpose and are often used in conjunction with each other to build an application or system. Some are designed for low-level manipulation of the system, some are designed for efficient data processing, some are designed to be as user-friendly as possible by abstracting away a lot of the system interaction. The first programming languages as we know them were developed in the 1950s. **Assembly Language** is still underpinning many modern languages and is the closest thing to the machinecode which instructs the CPU. Others such as **FORTRAN** and **COBOL** are used less frequently today but still have their niche in legacy and extreme high-performance systems.

Later developments began to add structure to the way in which programs were constructed and lay down the paradigms which are still followed today. **C** made its first appearance in 1972 with **ML** (for **M**eta **L**anguage) following a year later. These introduced concepts such as **static typing** and involved a **compilation** stage where the user's code was converted into **bytecode** before execution, enabling checks to be made on the soundness of teh code before running it. 1978 saw the arrival of **SQL** for database interaction.

**Interpreted** langauges which did not involve a compilation stage, instead being converted to bytecode line-by-line and running immediately, began to appear in the 1990s. Many familiar names, such as **Ruby**, **Python** and **JavaScript** appeared in this decade although a significant new compiled language arrived in the shape of **Java**. The interpreters for these languages are themselves written in languages developed in the preceding decades, for example the first Ruby interpreters were written in C.

There are undoubtedly "best" languages for use in certain scenarios, but most languages can be used for most purposes. There are exceptions, for example only JavaScript can be embedded in HTML and run by a web browser, but often it is surprising how much can be achieved using different languages.

