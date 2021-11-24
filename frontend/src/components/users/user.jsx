import { Component } from "react";
import Axios from "axios";

class User extends Component {
    constructor(props) {
        super(props);
        this.state = {
            user: {},
            loading: true
        }
    }

    loadUser = (id = 0) => {
        Axios.get("https://jsonplaceholder.typicode.com/users/" + id)
             .then(response => {
                 this.setState({
                     user: response.data,
                     loading: false
                 });
             })
             .catch(error => {
                 console.log("Something went wrong", error)
             });
    }

    render() {
        let { user } = this.state;
        return(
            <>
            {
                this.state.loading ? <h4>Waiting for Data</h4> :
                <>
                        <h3>{user.name}</h3>
                        <hr/>
                        <h3>Email: {user.email}</h3>
                        <h3>Phone: {user.phone}</h3>
                        <h3>Website: {user.website}</h3>
                        <h3>City: {user.address.city}</h3>
                </>
            }                
            </>
        );
    }

    componentDidMount() {
        let id = this.props.match.id;
        this.loadUser(id);
    }
}

export default User;