-- Insert into DrinkStyles
INSERT INTO drink_styles (id_drink_style, style_name) VALUES
                                        (1, 'Lager'),
                                        (2, 'Ale'),
                                        (3, 'Stout'),
                                        (4, 'Pilsner'),
                                        (5, 'IPA');

-- Insert into Drinks
INSERT INTO drink (id_drink, drink_name, type, drink_description) VALUES
                                                    (1, 'Golden Lager', 'Beer', 'A crisp and refreshing lager.'),
                                                    (2, 'Pale Ale', 'Beer', 'A hoppy pale ale with citrus notes.'),
                                                    (3, 'Dry Stout', 'Beer', 'A rich and creamy dry stout.'),
                                                    (4, 'Czech Pilsner', 'Beer', 'A classic Czech-style pilsner.'),
                                                    (5, 'Hazy IPA', 'Beer', 'A hazy IPA with tropical fruit flavors.');
-- Insert into Ratings
INSERT INTO ratings (id_rating, our_service_quality,our_cost) VALUES
                                                                 (1, 4.5, 1 ),
                                                                 (2, 4.0,  2),
                                                                 (3, 5.0,  3),
                                                                 (4, 3.5, 4),
                                                                 (5, 4.8, 5);
-- Insert into Pubs (with embedded Geolocation)
INSERT INTO pub (id_pub, pub_name, latitude, longitude, address,city, phone_number,id_rating) VALUES
                                                                     (1, 'The London Pub', 51.5074, -0.1278, '123 London St, London, UK', 'London','+44 20 7946 0958',2),
                                                                     (2, 'Le Parisien', 48.8566, 2.3522, '456 Rue de Paris, Paris, France','London', '+33 1 42 68 53 00',1),
                                                                     (3, 'The New Yorker', 40.7128, -74.0060, '789 Broadway, New York, USA','London', '+1 212-555-0190',3),
                                                                     (4, 'Los Angeles Brew House', 34.0522, -118.2437, '101 Sunset Blvd, Los Angeles, USA', 'London','+1 213-555-0147',4),
                                                                     (5, 'Tokyo Taproom', 35.6895, 139.6917, '202 Shibuya, Tokyo, Japan', 'London','+81 3-1234-5678',5);

-- Insert into OpeningHours
INSERT INTO opening_hours (id_opening_hours, id_pub, weekday, time_open, time_close) VALUES
                                                                                         (1, 1, 'Monday', '12:00', '23:00'),
                                                                                         (2, 1, 'Tuesday', '12:00', '23:00'),
                                                                                         (3, 1, 'Wednesday', '12:00', '23:00'),
                                                                                         (4, 2, 'Thursday', '11:00', '01:00'),
                                                                                         (5, 2, 'Friday', '11:00', '02:00'),
                                                                                         (6, 3, 'Saturday', '10:00', '03:00'),
                                                                                         (7, 3, 'Sunday', '10:00', '22:00'),
                                                                                         (8, 4, 'Monday', '14:00', '22:00'),
                                                                                         (9, 5, 'Monday', '16:00', '23:30');
-- Insert into Photos
INSERT INTO photo (id_add_photo, id_pub, photo_url, title) VALUES
                                                      (1, 1, 'https://example.com/photos/london_pub.jpg', 'The front of the London Pub'),
                                                      (2, 2, 'https://example.com/photos/paris_pub.jpg', 'Inside Le Parisien'),
                                                      (3, 3, 'https://example.com/photos/ny_pub.jpg', 'The New Yorker pub exterior'),
                                                      (4, 4, 'https://example.com/photos/la_pub.jpg', 'Los Angeles Brew House interior'),
                                                      (5, 5, 'https://example.com/photos/tokyo_pub.jpg', 'Tokyo Taproom seating area');


-- Insert into Join Table: Drink_Styles_Drink
INSERT INTO drink_styles_drink (id_drink, id_drink_style) VALUES
                                                        (1, 1),
                                                        (2, 2),
                                                        (3, 3),
                                                        (4, 4),
                                                        (5, 5);

-- Insert into Join Table: Drink_Pub
INSERT INTO drink_pub (id_drink, id_pub) VALUES
                                             (1, 1),
                                             (2, 1),
                                             (3, 2),
                                             (4, 3),
                                             (5, 4),
                                             (5, 5);