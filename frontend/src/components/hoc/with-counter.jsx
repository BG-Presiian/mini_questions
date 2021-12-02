import { Component } from "react";

const WithCounter = (OriginalComponent) => {
    class NewComponent extends Component {
        constructor() {
            super();
            this.state = {
                number: 0
    
            };
        }
    
        incrementNumber = () => {
            this.setState({
                number: this.state.number + 1
            });
        }

        render() {
            return (
                <OriginalComponent  { ...this.props }
                                    count = { this.state.number }
                                    incrementNumber = { this.incrementNumber }>
                </OriginalComponent>
            );
        }
    }

    return NewComponent;
}

export default WithCounter;