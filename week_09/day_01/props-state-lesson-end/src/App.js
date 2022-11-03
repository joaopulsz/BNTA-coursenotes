import './App.css';
import MemberContainer from './containers/MemberContainer';
import StateToggleExample from './components/StateToggleExample';

function App() {
  return (
    <div className="App">
      <h1>Member Manager</h1>
      <MemberContainer />
      <StateToggleExample />
    </div>
  );
}

export default App;
