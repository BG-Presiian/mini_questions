import { Component } from "react";
import { Consumer } from "../../context/context";

const WithConsumer = (OriginalComponent) => {
    class NewComponent extends Component {
        render() {
            return (
                <Consumer>
                    {
                        context => {
                                return(
                                    <OriginalComponent  { ...this.props }
                                        context = { context }
                                    ></OriginalComponent>
                                )
                            }
                    }
                </Consumer>
            );
        }
    }

    return NewComponent;
}

export default WithConsumer;