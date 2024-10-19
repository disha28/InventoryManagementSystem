-- Insert Categories
INSERT INTO category (id, name) VALUES
(1, 'Electronics'),
(2, 'Groceries'),
(3, 'Clothing'),
(4, 'Furniture');

-- Insert Vendors
INSERT INTO vendor (id, link) VALUES
(1, 'https://vendor1.com'),
(2, 'https://vendor2.com'),
(3, 'https://vendor3.com'),
(4, 'https://vendor4.com');

-- Insert Shelves
INSERT INTO shelf (id, capacity) VALUES
(1, 50),
(2, 30),
(3, 20),
(4, 100);

-- Insert Products
INSERT INTO product (id, name) VALUES
(1, 'Laptop'),
(2, 'Smartphone'),
(3, 'T-shirt'),
(4, 'Dining Table'),
(5, 'Apple'),
(6, 'Bread'),
(7, 'Jacket');

-- Insert Items
INSERT INTO item (id, product_id, quantity, category_id, price_per_unit, shelf_id, vendor_id) VALUES
(1, 1, 10, 1, 1000, 1, 1), -- Laptop
(2, 2, 20, 1, 700, 1, 2), -- Smartphone
(3, 3, 15, 3, 20, 3, 3), -- T-shirt
(4, 4, 5, 4, 300, 4, 4), -- Dining Table
(5, 5, 40, 2, 2, 2, 1), -- Apple
(6, 6, 25, 2, 1, 2, 2), -- Bread
(7, 7, 8, 3, 50, 3, 4); -- Jacket
