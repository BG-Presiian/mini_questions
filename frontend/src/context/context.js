import React from 'react';

let AppContext = React.createContext("");
let Provider = AppContext.Provider;
let Consumer = AppContext.Consumer;

export { Provider, Consumer };