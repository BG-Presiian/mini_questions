import React, { Component } from 'react';
import WithConsumer from '../hoc/with-consumer';

class Login extends Component {
    constructor(props) {
        super(props);
        this.state = {
            usr: "",
            pwd: "",
            outputLabel: ""
        }

        this.handleChangeUsr = this.handleChangeUsr.bind(this);
        this.handleChangePwd = this.handleChangePwd.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleLogout = this.handleLogout.bind(this);
    }

    handleSubmit(event) {
        event.preventDefault();
        let usrName = "test";
        let pass = "test";

        if(this.props.context.getValue.isAuthicated !== true) {
            // TODO: change the logic here to work for any/every username and password instead of one set
            if( this.state.usr === usrName && this.state.pwd === pass) {
                this.props.context.setValue('isAuthicated', true);
                this.setState({outputLabel: "Logged In"});
            } else {
                this.setState({outputLabel: "Username and Password did not match"});
            }
        } else {
            this.setState({outputLabel: "User is already logged in"})
        }
    }

    handleLogout(event) {
        if(this.props.context.getValue.isAuthicated) {
            this.props.context.setValue('isAuthicated', false);
            this.setState({outputLabel: "Logged Out"});
        }

    }

    handleChangeUsr(event) {
        this.setState({usr: event.target.value});
    }

    handleChangePwd(event) {
        this.setState({pwd: event.target.value});
    }

    render() {
        return (
            <>
                <form onSubmit={this.handleSubmit}>
                    <label>
                        Username:
                        <input  type="text" 
                                name="usr" 
                                value={this.state.usr} 
                                onChange={this.handleChangeUsr}/>
                    </label>
                    <label>
                        Password:
                        <input  type="password" 
                                name="pwd" 
                                value={this.state.pwd}
                                onChange={this.handleChangePwd}/>
                    </label>
                    <br/>
                    <input type="submit" value="Login"/>
                    <input type="button" value="Logout" onClick={this.handleLogout}/>
                    <br/>
                    <label id="outputLabel">{this.state.outputLabel}</label>
                </form>
            </>
        );
    }
}
export default WithConsumer(Login);