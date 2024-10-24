INSERT INTO Beer (long_description, short_description, photo_url, maltiness, blg, alcohol_content)
VALUES
    ('A smooth and creamy porter with a smoky aftertaste.', 'Classic porter', '/images/porter.jpg', 'High', '18', '6.5%'),
    ('A balanced amber ale with sweet caramel and toffee notes.', 'Amber ale', '/images/amber_ale.jpg', 'Medium', '15', '5.2%'),
    ('A light and refreshing wheat beer with fruity undertones.', 'Wheat beer', '/images/wheat_beer.jpg', 'Low', '11', '4.8%'),
    ('A strong and hoppy double IPA with bold bitterness.', 'Double IPA', '/images/double_ipa.jpg', 'High', '21', '8.5%'),
    ('A smooth pilsner with a clean and refreshing finish.', 'Pilsner', '/images/pilsner.jpg', 'Low', '12', '5.0%'),
    ('A rich and malty dunkel with a slightly sweet finish.', 'Dunkel', '/images/dunkel.jpg', 'Medium', '16', '6.0%'),
    ('A Belgian-style tripel with spicy and fruity notes.', 'Belgian tripel', '/images/tripel.jpg', 'Medium', '20', '8.0%'),
    ('A sour beer with strong citrus and tart fruit flavors.', 'Sour beer', '/images/sour_beer.jpg', 'Low', '14', '4.5%'),
    ('A spiced winter ale with hints of cinnamon and nutmeg.', 'Winter ale', '/images/winter_ale.jpg', 'Medium', '17', '6.8%'),
    ('A bold and dark imperial stout with coffee and chocolate.', 'Imperial stout', '/images/imperial_stout.jpg', 'High', '24', '9.5%'),
    ('A refreshing pale ale with balanced bitterness and floral hops.', 'Pale ale', '/images/pale_ale.jpg', 'Medium', '13', '5.5%'),
    ('A classic barleywine with deep malt character and strong alcohol content.', 'Barleywine', '/images/barleywine.jpg', 'High', '25', '10.0%'),
    ('A traditional Scottish ale with rich maltiness and light sweetness.', 'Scottish ale', '/images/scottish_ale.jpg', 'Medium', '18', '7.0%'),
    ('A fruity and refreshing radler, mixing beer with citrus juice.', 'Radler', '/images/radler.jpg', 'Low', '7', '3.0%'),
    ('A herbal saison with earthy and slightly spicy flavors.', 'Saison', '/images/saison.jpg', 'Medium', '16', '6.2%'),
    ('A black IPA combining roasted malt flavors with hoppy bitterness.', 'Black IPA', '/images/black_ipa.jpg', 'High', '22', '7.5%');
INSERT INTO Drink_Styles (style_name)
VALUES ('IPA'), ('Lager'), ('Stout'), ('Ale'), ('Wheat Beer');
-- Assuming that Beer, DrinkStyles, and Pubs have already been inserted and we know their IDs
INSERT INTO Drink (drink_name, type, drink_description, id_beer) VALUES ('Lager Delight', 'beer', 'A light and crisp lager with a refreshing taste.', 1);
INSERT INTO Drink (drink_name, type, drink_description, id_beer) VALUES ('Stout Supreme', 'beer', 'Rich and creamy stout with deep chocolate undertones.', 2);
INSERT INTO Drink (drink_name, type, drink_description, id_beer) VALUES ('Tropical IPA', 'beer', 'A hoppy IPA bursting with tropical fruit flavors.', 3);
INSERT INTO Drink (drink_name, type, drink_description, id_beer) VALUES ('Golden Ale', 'beer', 'A smooth and malty golden ale with a hint of caramel.', 4);
INSERT INTO Drink (drink_name, type, drink_description) VALUES ('Mango Smoothie', 'non-alcoholic', 'A refreshing and sweet mango-flavored smoothie.');
INSERT INTO Drink (drink_name, type, drink_description) VALUES ('Sparkling Water', 'non-alcoholic', 'Crisp sparkling water with a hint of lemon.');
INSERT INTO Drink (drink_name, type, drink_description) VALUES ('Chardonnay', 'wine', 'A light and refreshing Chardonnay with notes of apple and pear.');
INSERT INTO Drink (drink_name, type, drink_description) VALUES ('Cabernet Sauvignon', 'wine', 'Full-bodied red wine with rich flavors of blackberry and oak.');
INSERT INTO Drink (drink_name, type, drink_description, id_beer) VALUES ('Porter Classic', 'beer', 'A classic porter with a smoky finish.', 5);
INSERT INTO Drink (drink_name, type, drink_description) VALUES ('Cola', 'non-alcoholic', 'A fizzy and sweet cola drink.');
INSERT INTO Drink (drink_name, type, drink_description, id_beer) VALUES ('Amber Ale', 'beer', 'A balanced amber ale with hints of caramel and toffee.', 6);
INSERT INTO Drink (drink_name, type, drink_description) VALUES ('Rosé', 'wine', 'A vibrant rosé with fruity and floral notes.');
INSERT INTO Drink (drink_name, type, drink_description) VALUES ('Lemonade', 'non-alcoholic', 'Classic homemade lemonade with a tangy twist.');
INSERT INTO Drink (drink_name, type, drink_description, id_beer) VALUES ('Pilsner Perfection', 'beer', 'A crisp and refreshing pilsner with a smooth finish.', 7);
INSERT INTO Drink (drink_name, type, drink_description, id_beer) VALUES ('Double IPA', 'beer', 'A bold double IPA with intense hop flavors.', 8);
INSERT INTO Drink (drink_name, type, drink_description) VALUES ('Espresso', 'non-alcoholic', 'A strong and rich espresso shot.');
INSERT INTO Drink (drink_name, type, drink_description) VALUES ('Tea', 'non-alcoholic', 'Classic English tea served hot.');
INSERT INTO Drink (drink_name, type, drink_description) VALUES ('Whiskey Sour', 'cocktail', 'A perfect balance of whiskey, lemon juice, and sugar.');
INSERT INTO Drink (drink_name, type, drink_description, id_beer) VALUES ('Wheat Beer Wonder', 'beer', 'A light wheat beer with a fruity aftertaste.', 9);
INSERT INTO Drink (drink_name, type, drink_description) VALUES ('Mojito', 'cocktail', 'A refreshing cocktail made with mint, lime, and rum.');
