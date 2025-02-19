-- Sample data for Beer
INSERT INTO Beer (id_beer, long_description, short_description, photo_url, maltiness, blg, alcohol_content)
VALUES
    (1, 'A full-bodied dark beer with a rich caramel aroma.', 'Dark beer', 'https://example.com/beer1.jpg', 'Medium', '12°', '5.5%'),
    (2, 'A refreshing pale ale with citrus notes.', 'Pale Ale', 'https://example.com/beer2.jpg', 'Light', '10°', '4.8%'),
    (3, 'A smooth wheat beer with a hint of banana.', 'Wheat Beer', 'https://example.com/beer3.jpg', 'Low', '11°', '4.2%'),
    (4, 'A strong and bitter IPA with floral aroma.', 'IPA', 'https://example.com/beer4.jpg', 'High', '14°', '6.5%');

-- Sample data for DrinkStyles
INSERT INTO Drink_Styles (id_drink_style, style_name)
VALUES
    (1, 'IPA'),
    (2, 'Stout'),
    (3, 'Lager'),
    (4, 'Pilsner'),
    (5, 'Wheat Beer');

-- Sample data for Drinks
INSERT INTO Drink (id_drink, drink_name, type, drink_description, id_beer)
VALUES
    (1, 'Golden Lager', 'Beer', 'A classic golden lager with a crisp taste.', 1),
    (2, 'Citrus Ale', 'Beer', 'A citrus-infused ale perfect for summer.', 2),
    (3, 'Dark Stout', 'Beer', 'A deep and rich stout with coffee notes.', 3),
    (4, 'Hazy Wheat', 'Beer', 'A wheat beer with light fruity flavors.', 4),
    (5, 'Laphroaig', 'Whiskey', 'Single malt Scotch whisky distillery on Islay, Scotland.', null);

-- Sample data for Drink_Styles_Drink (relationship)
INSERT INTO Drink_Styles_Drink (id_drink, id_drink_style)
VALUES
    (1, 3),
    (2, 5),
    (3, 2),
    (4, 5),
    (5, 1);

-- Sample data for Ratings
INSERT INTO Ratings (id_rating, google, google_count, facebook, facebook_count, trip_advisor, trip_advisor_count, untapped, untapped_count, our_drinks_quality, our_service_quality, our_cost)
VALUES
    (1, 4.5, 200, 4.7, 150, 4.3, 180, 4.6, 90, 4.8, 4.6, 3),
    (2, 4.2, 100, 4.5, 80, 4.1, 90, 4.4, 70, 4.6, 4.4, 2),
    (3, 4.8, 300, 4.9, 250, 4.7, 260, 4.9, 200, 4.9, 4.8, 4);

-- Sample data for Pubs
INSERT INTO Pub (id_pub, pub_name, address, place_id, city, phone_number, website_url, icon_url, description, latitude, longitude, reservable, takeout, id_rating)
VALUES
    (1, 'The Craft Bar', '123 Beer Street', 'PL12345', 'New York', '+123456789', 'https://craftbar.com', 'https://craftbar.com/icon.jpg', 'A cozy place for craft beer lovers.', 40.7128, -74.0060, true, true, 1),
    (2, 'Hoppy Haven', '456 Ale Avenue', 'PL67890', 'Los Angeles', '+987654321', 'https://hoppyhaven.com', 'https://hoppyhaven.com/icon.jpg', 'A trendy spot with a wide selection of IPAs.', 34.0522, -118.2437, true, false, 2),
    (3, 'Stout & Co.', '789 Brew Boulevard', 'PL11122', 'Chicago', '+112233445', 'https://stoutco.com', 'https://stoutco.com/icon.jpg', 'A historic pub specializing in stouts and dark ales.', 41.8781, -87.6298, false, true, 3);

-- Sample data for Opening Hours
INSERT INTO Opening_Hours (id_opening_hours, weekday, time_open, time_close, id_pub)
VALUES
    (1, 'Monday', '12:00:00', '23:00:00', 1),
    (2, 'Tuesday', '12:00:00', '23:00:00', 1),
    (3, 'Monday', '14:00:00', '01:00:00', 2),
    (4, 'Tuesday', '14:00:00', '01:00:00', 2),
    (5, 'Monday', '16:00:00', '02:00:00', 3),
    (6, 'Tuesday', '16:00:00', '02:00:00', 3);

-- Sample data for Photos
INSERT INTO Photo (id_add_photo, title, photo_url, id_pub)
VALUES
    (1, 'Pub Interior', 'https://example.com/pub1.jpg', 1),
    (2, 'Craft Beer Selection', 'https://example.com/pub2.jpg', 1),
    (3, 'Crowded Friday Night', 'https://example.com/pub3.jpg', 2),
    (4, 'Outdoor Patio', 'https://example.com/pub4.jpg', 3);

-- Sample data for Tags
INSERT INTO Tag (id_tag, name, id_pub)
VALUES
    (1, 'Cozy', 1),
    (2, 'Live Music', 1),
    (3, 'Trendy', 2),
    (4, 'Large Selection', 2),
    (5, 'Historic', 3),
    (6, 'Outdoor Seating', 3);

-- Sample data for Drink_Pub (relationship)
INSERT INTO Drink_Pub (id_pub, id_drink)
VALUES
    (1, 1),
    (1, 2),
    (2, 3),
    (2, 4),
    (3, 5);
