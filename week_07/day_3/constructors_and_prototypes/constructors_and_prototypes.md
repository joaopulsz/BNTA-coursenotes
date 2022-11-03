# Constructors & Prototypes

We've seen how to implement some of the fundamental fetaures common to most programming languages in JavaScript but so far we're restricted to using a single file with limited scope for reusing code. This has been fine so far but as our applications get larger we will need to pay more attention to how they are structured.

To help us we will make use of **classes**. Classes are the foundation of object-oriented programming and just like in OO languages such as Java or Python we can use them to create a reusable "template" which will define certain properties and behaviours. JavaScript isn't strictly object-oriented but it follows many of the same conventions, meaning many OO principles can be applied here.

Since JavaScript isn't strictly OO, we don't have a "class" construct in the same way as we do in other OO langauges. We can achieve the same result using a special function known as a **constructor**. They are used slightly differently but the end result is the same: we create an object to represent some data.

## Constructor Functions

Let's say we want to create an object to represent a  `Student`. Where we might define a class in other languages, in JavaScript we will use a constructor function. They look similar to other functions and can be defined in the same way, using either named, annonymous or arrow functions.

```sh title="Terminal"
touch student.js
```

```js title="student.js"
const Student = function () {

}

const alice = Student();

console.log('alice:', alice);
// alice: undefined
```

We aren't returning anything from our function so the value stored in the `alice` variable will be `undefined`. Given that we want to create an object that's a little inconvenient, but we can fix this by calling our constructor function in a slightly different way.

In JavaScript we can add the `new` operator before our function call, changing its behaviour. Instead of returning `undefined` it will now return a `Student` object.

```js title="student.js"
const Student = function () {

}

const alice = new Student(); 

console.log('alice:', alice);
// alice: Student {}
```

Because we used the `new` operator there is now a type associated with our object. This only works if we **don't** return anything from the constructor. If we do then we still get an object back but we lose the type.

```js title="student.js"
const Student = function () {
  return { name: 'Alice' }; 
}

const alice = new Student();

console.log('alice:', alice);
// alice: { name: 'Alice' }
```

## Setting Properties with `this`

When we define a class we can set up the structure which all instances of that class must adhere to. One aspect of this is defining a class's **properties** - values which must exist for each object of that type, but which can have different values for each object. In our example we may want our `Student`s to have names. Every `Student` needs one, but they should all be different.

To define a property for a class we set it inside the constructor function. It takes the form of a key-value pair just like any other with the key being the name we want to associate with the property and the value being a parameter of the constructor. We need to introduce another keyword to make this work properly: `this`

```js title="student.js"
const Student = function () {
  console.log('this:', this); 
  // this: Student {}
}

const alice = new Student();
```

When we call our constructor `this` gives it the ability to refer to the specific instance of the class which is generated. When we use it in conjunction with the name of a property we are assigning the value for **that particular object**. If we call the constructor a second time and pass a different argument the second object will have a different value for that property.

```js title="student.js"
const Student = function (name) {
  this.name = name; 
}

const alice = new Student('Alice');
const bob = new Student('Bob');

console.log('Alice's name:', alice.name); 
// Alice's name: Alice

console.log('Bob's name':, bob.name);
// Bob's name: Bob
```
  
Notice that we can to access a `Student`'s name property directly. Unlike some other languages JavaScript has no access modifiers. Encapsulation is possible but is a fairly advanced topic in JavaScript.

## Adding Behaviours

We've already seen that functions are objects which can be stored in variables in JavaScript. One of the ways in which that can be done is by setting them as values in key-value pairs, meaning we can attach methods to our objects in exactly the same way that we attach properties.

We do this by using the `this` keyword again and assigning an annonymous function to a key. These functions specify behaviours which every instance of the class can perform and are given the special name **methods**. We can call one of these methods as if we were accessing a property by using the dot notation then adding invocation brackets (`()`).

```js title="student.js"
const Student = function (name) {
  this.name = name;
	
  this.greet = function () { 
    console.log(`Hello, my name is ${ this.name }`);
  }
}

const alice = new Student('Alice');
alice.greet(); 
// Hello, my name is Alice
```

Our objects now have a behaviour! Beyond their association with the class in which they are defined there is nothing special about these methods; anything we could do in a function outside of a class can be done here too.

If we create a second `Student` object it will also have an identical `greet` function attached to it.

```js title="student.js"
const bob = new Student('Bob');
bob.greet();
// Hello, my name is Bob
```

All of our `Student`s can use this behaviour but we're actually doing it in a pretty inefficient way. Every time we create a new `Student` we are defining a new function, it just happens to be identical to the functions defined in every other `Student`. 

```js title="student.js"
console.log('alice:', alice);
console.log('bob:', bob);

// alice: { name: 'Alice', greet: [Function] } 
// bob: { name: 'Bob', greet: [Function] } 
```

If we create lots of `Student` objects we use up a lot of memory duplicating the same functions. Fortunately there is a more efficient technique available to us.


## Prototypes

When we use a constructor function to define a class there is an additional object created for us known as a **prototype**. This prototype object acts as a central store of information available to all objects created using that constructor, meaning that any methods we define as part of it will be accessible by any objects using it.

How does this work in practice? There will be no difference in how we call the method, but there's a significant change in how we define it. The prototype object is structured in the same way as any other JavaScript object using key-value pairs. In order to define a function on a prototype we assign it to a key just as we would with ay other object.

```js title="student.js"
const Student = function (name) {
  this.name = name;
}

Student.prototype.greet = function () { 
  console.log(`Hi! My name is ${ this.name }`);
}
```

The functionality is the same, but we have defined our method in a more memory-efficient way.

```js title="student.js"
const alice = new Student('Alice');
alice.greet();
// Hello, my name is Alice

const bob = new Student('Bob');
bob.greet();
// Hello, my name is Bob

console.log('alice:', alice);
console.log('bob:', bob);
// alice: { name: 'Alice' }
// bob: { name: 'Bob' }
``` 

Our objects now only consist of the `name` property but still have access to the `greet` method. This may not seem like much at this scale, but imagine how it would look if we were to create objects representing many students or if those objects had many behaviours defined - the memory overheads would be significantly larger!

## Multiple Classes

Our classes don't exist in isolation, they will usually interact with each other. Let's say we want our `Student`s to have `Laptop`s. First up we need to create a `Laptop` class, then give the `Student`s a property to represent their laptop.

```sh title="Terminal"
touch laptop.js
```

```js title="laptop.js"
const Laptop = function (manufacturer, model, operatingSystem) {
  this.manufacturer = manufacturer;
  this.model = model;
  this.operatingSystem = operatingSystem
}

Laptop.prototype.install = function (program) {
  console.log(`${ this.model } installed ${ program }`);
}
```

```js title="student.js"
const Student = function (name) {
	this.name = name;
	this.laptop = null;
}
```

Note that we have also given `Laptop` an `install` method.

Instead of passing a `laptop` argument to our constructor we initialise the property to be `null`. This is usually done when we want every instance of a class to start with the same value for some property - in this case we want all our students to start without a laptop.

We can modify this property by writing a method which adds a `Laptop` to our `Student`.

```js title="student.js"
// ...

Student.prototype.buyLaptop = function(newLaptop){
	this.laptop = newLaptop;
}

```

Why do we do it this way instead of simply setting the property when we want to update it? Why got to the bother of adding a method? In most programming languages we try to avoid this as it is considered bad practice to allow users to modify properties whenever they want to. In other languages such as Java we use an *access modifier* to prevent this, meaning we *have* to write a method if we want to update anything. This can be done in JavaScript but is a fairly advanced topic.

Now that our `Student`s have `Laptop`s they can use the properties and behaviours of those `Laptop` objects in their own methods. 