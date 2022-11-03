# React Router

## What is routing?
Thus far, our React apps have the same URL no matter where in the app we are.

This means we cannot link directly to specific pages or sections in our applications. If we share a URL, we can only share a link to the starting page.

In reality we want websites that have different paths.

Load different pages for different paths.

In our React apps, when the URL changes, the visual content should change.

In a non-React app, we would normally store different HTML files on the server (or perhaps dynamically generate those files on the server) and requests to different URLS would result in different pages being sent back to the client. But this not the model for a Single Page App (SPA). If we did something like this, we would be at the mercy of the request-response cycle...which is, after all, one of the reasons why we switched to React. We want to use Javascript in the browser to make the changes we want to see.

React Router can give the the best of both worlds. Page changes are handled by our client-side code (React) and any visible content changes are done without fetching a new HTML file.

## Installing React Router
React Router doesn't come as standard, so we need to install it. 

There are a couple of different versions being used widely: v5 and v6. We will show you how to implement the latest version (v 6), which is a much improved version under the hood. The good news is that if you ever encounter v5, you will find implementing it much the same. React Router have a page in their documentation that specifically refers to upgrading from v5 to v6 should you ever need it.

Either use the code we worked on yesterday, or pull and copy the start code for this lesson. If you are using start_code you will need to `npm i` to pull in the required `node_modules`.

Ensuring that you are at the root of your project, run:

```sh
# Terminal 
npm install react-router-dom@6
```

## Writing our routes

### `<Routes>` (formerly `<Switch>`)
`<Routes>` lets our app know what our collection of routes are and to only run one route at a time.

Open `ChocolateContainer.js` and import the packages we will need for routing. We can also begin to use some of the syntax.

```jsx
// ChocolateContainer.js
import {Browser as Router, Route, Switch} from 'react-router-dom';  // ADDED
...
    return (
        <>

        </>
    )



```













