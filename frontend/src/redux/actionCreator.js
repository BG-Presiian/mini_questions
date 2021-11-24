export let checkChange = () => {
    return {
        type: 'CHECK_CHANGE'
    };
}

export let incrementNumber = (payload) => {
    return {
        type: 'INCREMENT_NUMBER',
        payload
    };
}

export let decrementNumber = (payload) => {
    return {
        type: 'DECREMENT_NUMBER',
        payload
    }
}