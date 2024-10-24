import { createStore, applyMiddleware } from 'redux';
import { Provider } from 'react-redux';
import { thunk } from 'redux-thunk';
import rootReducer from './reducers'; // Adjust the path to your reducers

const store = createStore(rootReducer, applyMiddleware(thunk));
export default store;
