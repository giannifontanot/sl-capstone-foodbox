

INSERT INTO food (id, cuisine, description, image_url, is_enabled, food_name, price)values(1, 'ARAB', 'rico Kebab',
                                                                                           'http://tinyurl
.com/kebab2Image','Y', 'Kebab', 10);
INSERT INTO food (id, cuisine, description, image_url, is_enabled, food_name, price)values(5, 'SPAIN', 'Delicious
rice with fried shimp to perfection',
                                                                                           'http://tinyurl
.com/shrimpFriedRiceImage','Y', 'Shrimp Fried Rice', 50);
INSERT INTO food (id, cuisine, description, image_url, is_enabled, food_name, price)values(2, 'MEXICAN', 'Borrego
asado en horno de hoyo ',
                                                                                           'http://tinyurl
.com/barbacoaImage','Y', 'Tacos de Barbacoa', 20);
INSERT INTO food (id, cuisine, description, image_url, is_enabled, food_name, price)values(3, 'MEXICAN', 'Receta de la abuelita de mole verde', 'http://tinyurl.com/moleVerdeImage','Y', 'Mole Verde', 30);

insert into user(id,contact,email,password, profile, username, credit) values (1,"21480945441","elmerhomero@123
.com", "sitiene","C", "yomerito", "4444-0000-0000-0001");
insert into user(id,contact,email,password, profile, username, credit) values (2,"21480945441","admin@123.com",
                                                                                "notiene","A",
                                                                       "admin", "4444-0000-0000-0001");




 insert into box (id, food_id, quantity)values(1,1,1);
 insert into box (id, food_id, quantity)values(1,2,1);
 insert into box (id, food_id, quantity)values(1,3,1);
 insert into box (id, food_id, quantity)values(1,4,1);

 insert into box (id, food_id, quantity)values(2,1,1);
 insert into box (id, food_id, quantity)values(2,2,1);


 insert into orden(id,status,box_id,user_id)values(1,"READY", 1,1);
 insert into orden(id,status,box_id,user_id)values(2,"PEND", 2,1);