import logo from './logo.svg';
import './App.css';
import {Button, Typography} from "@mui/material";
import {useState} from "react";

function App() {
  const [pushed, setPushed] = useState(false)
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
        <Button variant={'contained'} onClick={()=>setPushed(!pushed)}>Button</Button>
        {pushed && <Typography sx={{color: 'primary.main'}}>Pushed!!</Typography>}
      </header>
    </div>
  );
}

export default App;
