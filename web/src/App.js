import React from "react";
import "./App.css";
import SignUp from "./components/SignUpForm";
import UpLoading from "./components/UpLoadingForm"

function App() {
  return (
    <div className="App">
      <body className="App-header">
        <SignUp/>
        <UpLoading/>
      </body>
    </div>
    
  );
}

export default App;
