import { Component } from "react";
import Axios from 'axios';
import { Link } from "react-router-dom";

class Books extends Component {
    constructor() {
        super();
        this.state = {
            books: [],
            loading: true
        }
    }

    loadBooks = () => {
        Axios.get("https://jsonplaceholder.typicode.com/users")
             .then(response => {
                 this.setState({
                     books: response.data,
                     loading: false
                 });
             })
             .catch(error => {
                 console.log("Something went wrong", error)
             });
    }

    render() {
        return(
            <>
            {
                this.state.loading ? <h4>Waiting for Data</h4> :
                <ul>
                    {   
                        this.state.books.map(book => 
                            <li key={book.id}><Link to={"/book/" + book.id}>{book.name}</Link></li>)
                    }
                </ul>
            }                
            </>
        );
    }

    componentDidMount() {
        this.loadBooks();
    }
}

export default Books;