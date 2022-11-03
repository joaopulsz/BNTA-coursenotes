import './App.css';
import {BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import Home from './components/Home';
import About from './components/About';
import Contact from './components/Contact';
import Services from './components/Services';

function App() {
  return (
    <BrowserRouter>
    <div className="App">
      <h1>React Router Lesson</h1>
      <ul>
        <li><Link to='/'>Home</Link></li>
        <li><Link to='/about'>About</Link></li>
        <li><Link to='/services'>Services</Link></li>
        <li><Link to='/contact'>Contact</Link></li>
      </ul>
      <Routes>
        <Route path ='/' element={<Home />} />
        <Route path ='/about' element={<About />} />
        <Route path ='/services' element={<Services />} />
        <Route path ='/contact' element={<Contact />} />
      </Routes>
    </div>
    </BrowserRouter>
  );
}

export default App;
