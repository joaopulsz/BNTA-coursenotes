# An Introduction to React

### Lesson duration: 45mins

## Learning Objectives
- Be able to create your first single component React app using `create-react-app`
- To use JSX, and begin to understand how it is similar (and different) to HTML
- An introduction to the React ecosystem, being to understand why React remains such a popular library

Ever since its release in 2013, React has been prevalent in the web-development space. Created and maintained primarily by Facebook, React is a JavaScript library designed for building user interfaces and provides an experience likened to that of front-end frameworks (e.g. Angular and Vue.JS). Like any library, React builds upon what already exists—creating boosted means to use what is already there, rather than replacing it itself. But that doesn't mean that React looks and feels like vanilla JavaScript; especially owing to the newer additions of the `useEffect` and `useState` hooks, and hence the shift away from class-based components, React provides an individual experience.

Developers benefit from bolstered organisation and maintainability through the creation of discrete, reusable components, however React boasts more about what it can do for your users. Seamless transitions, asynchronous field validation and boosts to performance all benefit the end users of your application and it is from this that React gains an edge over traditional HTML and JavaScript. While for developers the library only provides a different way to play with what exists in the base languages, the means by which React helps render your web application is unique and powerful. Throughout the next section of this course, we aim to cover first the interplay between React and vanilla JavaScript before then exploring how modern React applications use the tools accessible in the library and where they have come from.


## Why React?

According to the annual [State of JS survey](https://2021.stateofjs.com/en-US/libraries/front-end-frameworks) React is the most widely-used front-end framework and has one of the highest satisfaction rates among its users. There isn't anything we can do with React which we can't already achieve by loading a JavaScript file into our HTML, so why the popularity?

React has some key features which improve the experience for both developers and users. From the developers' perspective, we have access to a more easily-reusable structure for our code and built-in tools to help with data management, plus a huge ecosystem of additional libraries. For the end user there are significant performance advantages compared to vanilla JavaScript.

The key characteristics of React are:
- The Virtual DOM
- Component based UI

## The Virtual DOM

We have already seen how the DOM API enables us to build interactive web pages using JavaScript. While the DOM is an impressive tool it has its disadvantages too, primarily concerning efficiency.

It may not seem like it, but in computer terms rendering a page in a browser is actually a very slow process. The HTML must be parsed, any styling applied and then drawn on the page ahead of any JavaScript code being executed. The JavaScript engine is much quicker when reading the code, but if it requires anything on the page to be updated then the DOM must be updated, which slows things down again. 

If React were to directly manipulate the DOM it would likely be *less* efficient than a pure JavaScript application. The way in which it handles data and passes it between files would add a significant overhead, slowing things down further. React avoids this though, choosing instead to first make changes to a **virtual DOM**.

This virtual DOM only exists in memory, meaning it is never actually rendered directly by the browser. Displaying the content on the page (often referred to as "painting" in React documentation) is the time-consuming part, so by avoiding this we instantly see a huge jump in efficiency. Editing the virtual DOM is a purely JavaScript operation which is much faster.

In combination with React's tools for managing data flow this means we can quickly make lots of changes to our app's layout. When the time comes to display them on the screen, however, there's no getting away from the need to "paint" them. React helps us out again here by comparing the version of the app currently being displayed with the structure held in the virtual DOM. It notes the changes (known as a "diff") and modifies only the parts of the DOM which need to be updated. Small changes like this instead of completely redrawing the whole page with each change make React apps incredibly fast.



## Getting Started with React

React is available from [npmjs.com](https://www.npmjs.com/package/react) and can be installed like any library through the command line, however there are a *lot* of moving parts required to fully configure it. In order to minimise the amount of configuration (and therefore the potential for mistakes) Facebook developed the [create-react-app](https://www.npmjs.com/package/create-react-app) package. In addition to the core React libraries it includes support for:

- The bundler [Webpack](https://www.npmjs.com/package/webpack) which compresses our code into a single file before serving it to the user, reducing the number of imports required
- A built-in web server
- The Jest testing framework, enabling us to run unit tests out of the box
- Hot reloading functionality, meaning we don't need to restart the application every time we make a change.

We also get a pre-made `README.md` file and a Git repository initialised for us.

Installation is done through the command line using `npx` to temporarily install `create-react-app`, use it to scaffold the app then remove the tools.

`npx create-react-app my-app-name`

**NOTE:** If you would like to add React functionality to an existing webpage, then you can easily do so by simply including the React initiation `<script>` tags before importing your React component file at the bottom of your page's `<body>` element. See the [official React documentation](https://reactjs.org/docs/add-react-to-a-website.html) for a guide.

On running `create-react-app` a directory will be created which contains the usual files generated by npm. The name of the directory will be the name you specify at the end of the `create-react-app` command (ie. `my-app-name`). Let's create our own React app. In terminal, navigate to where you would like your app to live:

## Our first React app: Hello World

```sh
#Terminal
npx create-react-app hello_world
```
> you may be prompted with `Need to install the following packages: create-react-app OK to proceed? (y)`. Type 'y' and proceed, this first installation may take longer than usual.

```sh
#Terminal

cd hello_world
code .
npm start
```
Open your application in VSCode and launch the server with `npm start`. Notice that `create-react-app` has initialised a git repository for us already. 

A browser window will open automatically (if it doesn't, open a new browser window and go to localhost:3000). The terminal should say that it has *"Compiled successfully!"* and the page should look like below:

![](../../../assets/react/intro_to_react/template_site.png)

### `public/` folder
The `public/` folder holds the resources which on-build, would be held at the root of your application. React doesn't perform any manipulation on these files. It is common to store images within a `images/` folder here as they are easily accessible. 

On installation, this folder will notably contain the React favicon image file alongside a `index.html` file. This HTML file contains the template for your application which everything else will be built onto. If you need to change any information stored in the `<head>` portion of your site, look here.

While we're here, we can delete some of the boilerplate that we don't need:
- `logo192.png`
- `logo512.png`
- `favicon.ico` can also be deleted, although some like to keep it at this stage to distinguish it from other tabs open in your browser

### `src/ folder`

The `src/` folder holds the bulk of your React application. The `App.js` file houses the parent component for your entire application which all your other custom components feed into. The `index.js` file acts as the primary connection between the previously mentioned `index.html` file, simply computing the contents of the `App.js` file before adding it to the `root` element of the site. The remaining files are fairly self-explanatory, such as those relating to the Jest testing, and the associated CSS files for the two main files. 

We will remove:
-`logo.svg` (right-click and delete)
- the contents of `App.css`
- 


#### `App.js`
Remove the content contained within the `return` statement in `App.js` (retain the brackets `()`). 

Lastly, remove the import of the logo from `App.js`. Let's try to render 'Hello world!'.

```js
// App.js

function App(){
    return (
    	<h1>Hello world!</h1> // ADDED
    );
}
```
If we return to our browser, we should now see 'Hello world!' on the page.

You may have noticed during previous steps that there was no need for you to stop the development server; pages update automatically on saving your files (hot reload). This feature is part of what makes developing in React a more pleasant experience for devs. Having one screen automatically displaying your current work in the browser while you code on another makes for a more streamlined approach to web development.


## JSX

The code in our return statement may look like HTML, but it is in fact something called JSX. JSX looks like a markup language, but it is a syntax extension to Javascript (in simple terms, it is Javascript under the hood). This allows us to write (what looks like) HTML and Javascript together.

But enough about the benefits — what is JSX? Alternatively coined as an acronym to mean *"JavaScript XML"* (XML itself meaning, *"eXtensible Markup Language"*, a way we store and transfer data), JSX is used to make our lives easier when developing with React. Often referred to as like "writing HTML within JavaScript", JSX allows us to return structural code from our JS components in a form that is easy to understand as we are already familiar with HTML syntax. 

*there is some further reading on JSX below.


## *`className`* not *`class`* & *`htmlFor`* not *`for`*

Although we can largely write JSX as we write HTML, bear in mind that JSX is simply an extension to vanilla JavaScript. It hence shares all the reserved keywords of JavaScript, some of which eclipse different keywords in HTML. 

The `class` keyword is used in JavaScript to declare a class, a template for creating further, similar, objects; conversely, the `class` keyword in HTML is used to assign classes to structural elements which can later be targeted by CSS or JavaScript. There needs to be a means for the computer to differentiate between the two uses of the same string of characters and so React uses distinct declarations for the HTML use-cases. In place of `class`, we use `className`, note the camelCase. 

The `for` keyword within HTML, which is primarily used to link `<label>` elements to elements with the specified `id`, is replaced with `HTMLFor`.

| HTML | JSX |
| :----: | :----: |
| `class` | `className` |
| `for` | `htmlFor` |


### *A deeper dive into JSX (optional)
Note that using JSX is not a requirement to use React, for you can use vanilla JavaScript code, however you will have an easier time if you do. If we look at our example `App.js` file above, it is using JSX. Remember that JSX *extends* JavaScript and so to demonstrate this point, we are going to break down the component, separating the vanilla JS from the JSX.

**JavaScript:**

```js
import './App.css';

function App() {
  return (

  );
}

export default App;
```

**JSX:**

```jsx
<div className="App"></div>
```

*"But that's just HTML!"* You may exclaim, looking at the JSX excerpt above. Remarkably similar with angle brackets `< >` and the `div` keyword, the face of JSX should be one that you are already familiar with; but there is a lot more going on underneath than you may expect. We briefly mentioned Babel earlier, which is a *transcompiler* that takes modern ECMAScript code (a revised and updated version of JavaScript) and compiles it into a backwards-compatible version of JS. Babel hence takes our JSX code that we write in our documents and turns it into *different code*, that is then passed to our browser to be rendered. This distinction is easy to see when we look at our webpage with Dev Tools. We can see a traditional, HTML webpage listed in the browser but within our files we only have a simple, almost empty `index.html` and then a few references to custom JavaScript components. Separate technology hence collects together and compiles our project consisting of many files, into one cohesive experience on the web.

## Compilation

So what is it that happens when we save our JS component files? As part of the toolchain of `create-react-app`, when we run `npm start`, your JS files are automatically converted on save. The compiled files aren't placed into your working directory as you may have expected with a different toolchain so below we are going to explore how JSX compiles into vanilla JS. 

Essentially, every HTML element within the JSX code, compiles down into a nested selection of `React.createElement()` calls. This functionality, included within the React library, accepts arguments which define first the HTML element we want to create, then its assigned properties (such as `className` or `style`) and then any children.

**In-Built React Create Element Function**

```javascript
React.createElement(
  type,
  [props],
  [...children]
)
```

Which for our simple example from the clean `App.js` component, excluding anything within the `<div>` would be:

**Example Compiled Code of Empty App Component**

```javascript
function App() {
	return React.createElement(
 		"div", {
 		className: "App"
	});
}

```

Note how the properties (*"props"*) of the element are declared as an object, between curly brackets `{ }`, and that we can hence have many. The following arguments each refer to the structural children of the created element (for instance, a `<p>` element within the `<div>`). If we would like to have text content within the element instead of another HTML element We can see the compiled version of our *"Hello World"* app below:

**Compiled "Hello World" Component**

```javascript
function App() {
  return React.createElement(
  	"div", 
  	{
   		className: "App"
  	},
  	React.createElement("p", null, "Hello World!"));
}
```

Already, we can see that the amount of code required to produce the same result is significantly greater when using vanilla JavaScript. This problem is only exaggerated further once we start having a greater nested structure. For example, if we would like to create a custom navigation component using vanilla Javascript, the end result may look like:

**Compiled Example Navigation Component**

```javascript
function NavBar() {
  return React.createElement("nav", {
    className: "navBar"
  }, React.createElement("ul", null, 
  
  		React.createElement("li", {
    		className: "navBar__item"
  		}, React.createElement("a", {
    		href: "/"
  		}, "Home")), 
  		
  		React.createElement("li", {
    		className: "navBar__item"
  		}, React.createElement("a", {
    		href: "/products"
  		}, "Products")), 
  		
  		React.createElement("li", {
    		className: "navBar__item"
  		}, React.createElement("a", {
    		href: "/about"
  		}, "About"))));
  		
}
```
As opposed to the far more concise:

```javascript
function NavBar() {
  return (
    <nav className="navBar">
		<ul>
          <li className="navBar__item">
          	<a href="/">Home</a>
          </li>
          <li className="navBar__item">
          	<a href="/products">Products</a>
          </li>
          <li className="navBar__item">
          	<a href="/about">About</a>
          </li>
      	</ul>
    </nav>
  );
}
```

It should be clear now why we generally opt for using JSX when creating our custom React components. It really is like having HTML within JavaScript. We already know where to look for the information we need and the components' code itself neatly represents the structure of the component on your page.

