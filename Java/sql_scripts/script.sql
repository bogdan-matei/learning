CREATE TABLE storage_item(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    type VARCHAR(15) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE inventory(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    itemId INT UNSIGNED NOT NULL,
    type VARCHAR(15) not null,
    PRIMARY KEY(id),
    FOREIGN KEY(itemId) REFERENCES storage_item(id) 
);
