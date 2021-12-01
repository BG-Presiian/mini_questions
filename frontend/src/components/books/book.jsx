import { Component } from "react";
import Axios from "axios";
import { useParams } from "react-router";

function GetId() {
    let { id } = useParams();
    return id;
}

class Book extends Component {
    constructor(props) {
        super(props);
        this.state = {
            book: {},
            loading: true
        }
    }

    loadBook = (id = 0) => {
        Axios.get("https://jsonplaceholder.typicode.com/users/" + id)
             .then(response => {
                 this.setState({
                     book: response.data,
                     loading: false
                 });
             })
             .catch(error => {
                 console.log("Something went wrong", error)
             });
    }

    render() {
        let { book } = this.state;
        return(
            <>
            {
                this.state.loading ? <h4>Waiting for Data</h4> :
                <>
                        <h3>{book.name}</h3>
                        <hr/>
                        <h3>Email: {book.email}</h3>
                        <h3>Phone: {book.phone}</h3>
                        <h3>Website: {book.website}</h3>
                        <h3>City: {book.address.city}</h3>
                </>
            }                
            </>
        );
    }

    componentDidMount() {
        console.log(GetId());
        let id = GetId();
        this.loadBook(id);
    }
}

export default Book;