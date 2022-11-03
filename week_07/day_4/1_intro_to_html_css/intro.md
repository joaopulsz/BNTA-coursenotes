# HTML, CSS & JavaScript

Lesson duration: 60mins

## Learning Objectives:​
- Understanding the basics of HTML, CSS & JavaScript
- Having a basic understanding of the Chrome Developer tools
- Gain the ability to create a simple static website

## Front-End Web Development 

Let's get visual. So far during your time on the course, we have been focussing on back-end web development—Java, SQL and Spring Boot—and while Java does provide means to creating a Graphical User Interface (GUI), that isn't the approach we'd use on the web. During the assessment centre days before the course, we explored the beginnings of what HTML, CSS and JavaScript provide and it's from this learning that we will be moving forwards. These first couple of days will focus on a recap of the HTML and CSS content alongside some new topics.

But before we delve into the session, let's first take a moment, high-level, to discuss what we mean when we say "front-end web development" and how that connects to your future careers. There are two sides to every website. You have the underlying data management, authentication and whatever other potential functionality related to information processing and storing externally on one side; and then you have the visual, front-facing, consumer-focussed structure on the other. Front-end web development is concerned with the latter. This isn't to mean however that *all* functionality of our site is housed on the "back-end" with the front simply looking pretty. Indeed, much of the following content is going to look at how we can create not only visually appealing sites but also those which are dynamic and ideally accessible to all.

## Responsive Design

The most common example of dynamic behaviour on the front end comes from **responsive design**. We won't do in-depth here on the *"How?"* within this chapter as we will be covering it a bit later but for now, let's collect it together into one question:

*"Why have many individual designs for each device size, when we could instead use one design which adapts as needed?"*

As a web developer, generally how it goes is, that about 70% of your traffic will come from mobile devices. That's not an exact number, but if you research it you will notice that the majority of users on your website will have mobile devices. Therefore there has been an increasing demand for websites to be designed with a *"mobile-first"* approach.

This means designing a website for mobile first, and moving up to larger screens once we're happy with the mobile design. But if we compare a phone screen to a computer monitor, there is such a significant difference in size and orientation that it isn't always easy to envision how a site's layout can all come from one dynamic design. Wireframing is the first step toward creating such a design and we'll be looking at how we can go about this process a little later.

## The Marriage of HTML, CSS and JS

At points during your career, you may take a step back and realise that you're swimming in a sea of letters and acronyms, each almost indescribable from the next. It's an issue within this sector and is partly what defines the large barrier to entry for many related topics. In the first part of our recap, let's take a look at each of HTML, CSS and JS, in turn, to define what they mean and how we will make use of them during the following chapters.

### HTML - HyperText Markup Language

Starting at the foundation of all webpages, we have HTML. Breaking the acronym in two, we have **HT** for **H**yper**T**ext and **ML** for **M**arkup **L**anguage. **HyperText** relates to the connection and hence relational systems of content on a webpage—hyperlinks and how those connect different parts of your page. A **Markup Language** is a computer programming paradigm which refers to the use of data within the body of a document—in this case, elements and properties such as `<body>` and `id=""`—which are used to provide additional information to the computer regarding webpage structure. These tags are not rendered on the webpage themselves but instead provide additional information about the content they contain.

This is quite wordy when what we simply mean is: **HTML defines the structure of our webpage.**

Let's jump into some code to help our understanding of HTML. Firstly, create a new directory named `hello_world` wherever you see fit and add a file to it named `index.html`.

*OR* we can run this command - 
```sh
mkdir hello_world && touch hello_world/index.html
```

Open the `hello_world` folder within Visual Studio Code. A nice little trick to get started with any HTML file is to hit the `"!"` key (Shift + 1) and hit enter. 

This is called `Emmet Abbreviation` and can speed up a lot of processes for you as a developer! You'll notice a lot of code appears in your file, and it should look something like this:

```html
<!-- index.html -->
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
    </head>
    <body>
        
    </body>
</html>
```

> NOTE: You'll notice comments are different in HTML compared to Java. Instead of a `//` for a comment, we use `<!-- Comment here -->`.

Don't worry if this stresses you out. If you haven't seen HTML before this can feel like a lot right away, but there are only a few things you need to know right now.

- All the code is wrapped in the `<html>` tag. You'll notice at the end we close the tag by writing `</html>`.
- Within this tag, there is a `<head>` and a `<body>` tag. The `<head>` tag contains *metadata* for the HTML file. This is intended to be for the browser to understand. For example, the `<title>` tag tells the Browser what to display on the Browser tab. 
- The `<body>` is the content of the website, and is what will be displayed to the user.

Let's go ahead and add some content to the `<body>` of our website.

```html
<!-- index.html -->
 <body>
   <h1>Hello World</h1>
   <p>Here is a paragraph</p>
 </body>
```

Once you've added the content, we can open the file in our browser to preview it. This can be done by running the following command:

```sh
open index.html -a Google\ Chrome
```

You should see a very simple website with the content that was added above. 

Congratulations! You've built your very first website 🎉.

You'll notice in the above code we used a `<h1>` and a `<p>`. There are many different tags that you can use in HTML, but there are a few rules when it comes to them. 

With a `<h1>`, you should only use it once on a web page, and it should always be the main heading. You can also use `h2`, `h3`, `h4`, etc. But it is important to have a hierarchy and remain consistent throughout your website. These are design principles that we will go through in more detail during wireframing.

A `<p>` is for a paragraph, and should be used for a body of text.

### CSS - Cascading Style Sheets

While HTML defines the structure of a webpage, **CSS defines how a webpage looks**. It provides so much out of the box that juniors often get a bit lost when adding styling to their site. As web development has grown, so has the number of different properties. We'll be taking the *less-is-more* approach to introducing some of the most commonly used properties in the following chapters.

So remember that great first website you just made? Let's face the facts, it's ugly. But not to worry! We can change that with a little facelift using some CSS.

Let's make a new file in our `hello_world` folder named `style.css`. 

```sh
touch style.css
```

Open the file and let's add in some CSS. We can modify pretty much any HTML that we have already written, but let's start simple. We're going to change the colour of our `h1` to `red`.

```css
/* style.css */
h1 {
    color: red;
}
```
> You'll notice once again our comments are different, as CSS is a different language! You can always trigger a comment by using `CMD` + `SHIFT`.

The keyword `h1` tells the browser to "look for any `<h1>` element within the HTML." and anything within the curly brackets is what we do to that element. So in this case, we are simply changing its colour to red.

But there's a problem here. If you try to open this in the browser, you'll notice our `h1` hasn't changed colour.

The reason for this is we never told our HTML file that we want to use CSS. So head back to your `index.html`, and we are going to link it to our `style.css` in the `<head>` of the file. 

> Remember, the `<head>` of an HTML file contains metadata for the browser. This is a perfect example of it, as the browser needs to know that we want to use CSS.

```html
<!-- index.html -->
<head>
    ...
    <link rel="stylesheet" href="style.css">
</head>
```

> Hot top 🔥: Remember we mentioned Emmet Abbreviations earlier? If you type `link:css` and hit Enter, it will automatically create this line for you!

Now if you refresh the browser page, you'll notice our heading has become red!

There is a lot more that you can do with CSS, and we can't cover everything in this course, but the possibilities are endless.

As a brief overview, we're going to show just a few more properties. But as with any programming language, if you ever want to try something our ol' pal Google will know the answer!

```css
body {
  background: lightblue;
  text-align: center;
}

h1 {
  color: white;
  font-size: 50px;
}

p {
  text-align: center;
  font-weight: bold;
  text-decoration: underline;
}
```

There is a lot going on here and most of it will just click over time. But an important thing to note is to notice we added a `text-align: center;` to the `body`. If you look back in the HTML, you'll notice the `body` element contains both the `h1` and the `p` elements. So when we add styles to the body, CSS knows to apply it to **each element within the selected element**. 

In this case, the `body` is known as the **parent**, and both the `h1` and `p` tags are known as **children**.


### JS - JavaScript

At this point, we have already covered some fundamentals of JavaScript. If you've only seen it run from the server side (i.e. not attached to a website), you're probably wondering what we could use it for within front-end web development. 

Well the answer to this is, pretty much everything 🤷🏻‍♂️ But don't worry, that will become more clear later.

Later on, we will go through JavaScript frameworks, like React. But for now, we're going to show you how JavaScript can be used on a website in a very simple way.

Create a new file in the `hello_world` directory we made previously, called `script.js`. And before we do anything else, just like with CSS, we need to *link* the files.

This is a little different to linking CSS previously. Open up your `index.html`, and add the following code to the `<head>`.

```html
<head>
    ...
    <script src="script.js" defer></script>
</head>
```

Open up the `script.js` file, and add the following code:

```js
console.log("Hello World");
```

Now refresh the Browser page again, and open up the **Developer Tools**. You can do this by right-clicking the page and selecting `Inspect`, or if you want to be fancy, you can use the following shortcut - `OPTION` + `CMD` + `I`.

The developer tools are your best (or only 🥲) friend in web development.

You can see your HTML, CSS and JavaScript code from here, and you can modify stuff in real-time to see how it will look. This is especially helpful for CSS modifications.

> Any changes you make in the browser are **NOT** saved to the code.

After the Developer tools are open, open up the `Console` (usually it is already opened down the bottom), and you should see your `Hello World` print statement in the console. If you don't, you may need to check that your script is linked correctly.

Let's see the capabilities of JS within a website. Go into your `index.html`, and add the following code to the `<body>`:

```html
<!-- index.html -->
<p id="text">Button was pressed 0 times</p>
<button id="btn">Press me</button>
```

We've created a button in the HTML, and given it an `id` of `btn`. The reason for this is it will be easy for our script to find the button by its ID. Open up the `script.js`, and let's add some functionality to our webpage.

```js
// script.js

// get the HTML elements by their ID
const button = document.getElementById("btn");
const text = document.getElementById("text");
let count = 0;

// listen for a button click
button.addEventListener("click", function () {
    count ++;
    // make the <p> display it
    text.innerText = `Button was pressed ${count} times`;
});

```
So let's go through what the above code is doing:
- Get the button and text elements by their IDs (Remember we set an ID for them in the HTML) and assign them to constant variables.
- Declaring a count variable and setting it to zero.
- Set up an `Event Listener` that listens for a `click` on the `button`.
- Once the button is clicked;
    - increment the count by 1, and
    - set the text to show how many times the button was pressed.

Now we've built a full website with HTML, CSS and JavaScript! Woohoo! 🤠
