import {
    FETCH_PRODUCTS,
    ADD_PRODUCT,
    UPDATE_PRODUCT,
    DELETE_PRODUCT,
    FETCH_SHELVES,
    ADD_SHELF,
    UPDATE_SHELF,
    DELETE_SHELF,
    FETCH_VENDORS,
    ADD_VENDOR,
    UPDATE_VENDOR,
    DELETE_VENDOR,
    FETCH_CATEGORIES,
    ADD_CATEGORY,
    UPDATE_CATEGORY,
    DELETE_CATEGORY,
} from './actions';

const initialState = {
    products: [],
    shelves: [],
    vendors: [],
    categories: [],
};

const rootReducer = (state = initialState, action) => {
    switch (action.type) {
        // Products
        case FETCH_PRODUCTS:
            return { ...state, products: action.payload };
        case ADD_PRODUCT:
            return { ...state, products: [...state.products, action.payload] };
        case UPDATE_PRODUCT:
            return {
                ...state,
                products: state.products.map((product) =>
                    product.id === action.payload.id ? action.payload : product
                ),
            };
        case DELETE_PRODUCT:
            return {
                ...state,
                products: state.products.filter((product) => product.id !== action.payload),
            };

        // Shelves
        case FETCH_SHELVES:
            return { ...state, shelves: action.payload };
        case ADD_SHELF:
            return { ...state, shelves: [...state.shelves, action.payload] };
        case UPDATE_SHELF:
            return {
                ...state,
                shelves: state.shelves.map((shelf) =>
                    shelf.id === action.payload.id ? action.payload : shelf
                ),
            };
        case DELETE_SHELF:
            return {
                ...state,
                shelves: state.shelves.filter((shelf) => shelf.id !== action.payload),
            };

        // Vendors
        case FETCH_VENDORS:
            return { ...state, vendors: action.payload };
        case ADD_VENDOR:
            return { ...state, vendors: [...state.vendors, action.payload] };
        case UPDATE_VENDOR:
            return {
                ...state,
                vendors: state.vendors.map((vendor) =>
                    vendor.id === action.payload.id ? action.payload : vendor
                ),
            };
        case DELETE_VENDOR:
            return {
                ...state,
                vendors: state.vendors.filter((vendor) => vendor.id !== action.payload),
            };

        // Categories
        case FETCH_CATEGORIES:
            return { ...state, categories: action.payload };
        case ADD_CATEGORY:
            return { ...state, categories: [...state.categories, action.payload] };
        case UPDATE_CATEGORY:
            return {
                ...state,
                categories: state.categories.map((category) =>
                    category.id === action.payload.id ? action.payload : category
                ),
            };
        case DELETE_CATEGORY:
            return {
                ...state,
                categories: state.categories.filter((category) => category.id !== action.payload),
            };

        default:
            return state;
    }
};

export default rootReducer;
