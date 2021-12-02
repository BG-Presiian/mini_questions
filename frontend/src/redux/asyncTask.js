import { decrementNumber } from "./actionCreator";

export const asyncTask = () => {
    let val = 0;
    return dispatch => {
        setTimeout(() => {
            val = 2;
            dispatch(decrementNumber(val));
        }, 200);
    }
}