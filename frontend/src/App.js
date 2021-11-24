import Header from "./components/header/header";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from "./components/Login/Login";
import User from "./components/users/user";
import Books from "./components/books/books";
import Book from "./components/books/book";
import { Component } from "react";
import { Provider } from "./context/context";
// import GuardedRoute from "./components/guarded-route/guarded-route";


class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      userName: "User",
      appName: "New ReactApp",
      num: 0,
      isAuthicated: false
    }
  }

  updateState = (key, value) => {
    this.setState({
      [key]: value
    });
  }

  render() {
    return(
      <>
        <BrowserRouter>
        <Provider value={ { getValue: this.state, setValue: this.updateState } }>
            <Header></Header>
            <Routes>
              <Route index element={<Login/>} />
                <Route path="user" element={ <User/> } auth={this.state.isAuthicated} />
                <Route path="books/*" element={ <Books/> } auth={this.state.isAuthicated} />
                  <Route path=":id" element={ <Book/> } auth={this.state.isAuthicated} />
            </Routes>
          </Provider>
        </BrowserRouter>
      </>
    );
  }
}

export default App;