import { Component } from "react";
import Axios from 'axios';
import { Link } from "react-router-dom";

class Users extends Component {
    constructor() {
        super();
        this.state = {
            users: [],
            loading: true
        }
    }

    loadUsers = () => {
        Axios.get("https://jsonplaceholder.typicode.com/users")
             .then(response => {
                 this.setState({
                     users: response.data,
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
                        this.state.users.map(user => 
                            <li key={user.id}><Link to={"/user/" + user.id}>{user.name}</Link></li>)
                    }
                </ul>
            }                
            </>
        );
    }

    componentDidMount() {
        this.loadUsers();
    }
}

export default Users;