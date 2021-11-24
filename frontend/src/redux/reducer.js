import initalStore from "./store";

let reducer = (store = initalStore, action) => {
    let newStore = { ...store };
    
    switch(action.type) {
        case 'CHECK_CHANGE': 
            newStore.checkStatus = !newStore.checkStatus;
            break;

        case 'INCREMENT_NUMBER':
            newStore.num += action.payload;
            break;

        case 'DECREMENT_NUMBER':
            newStore.num -= action.payload;
            break;
        
        default:
            break;
    }
    return newStore;
};

export default reducer;