-- Create 'product' table
CREATE TABLE product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Create 'vendor' table
CREATE TABLE vendor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    link VARCHAR(255) NOT NULL
);

-- Create 'shelf' table
CREATE TABLE shelf (
    id INT AUTO_INCREMENT PRIMARY KEY,
    capacity INT NOT NULL
);

-- Create 'category' table
CREATE TABLE category (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Create 'item' table
CREATE TABLE item (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT,
    quantity INT NOT NULL,
    category_id INT,
    price_per_unit INT NOT NULL,
    shelf_id INT,
    vendor_id INT,
    FOREIGN KEY (product_id) REFERENCES product(id),
    FOREIGN KEY (category_id) REFERENCES category(id),
    FOREIGN KEY (shelf_id) REFERENCES shelf(id),
    FOREIGN KEY (vendor_id) REFERENCES vendor(id)
);
