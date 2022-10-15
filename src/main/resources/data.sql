

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

insert into user(id,contact,email,password, profile, username, credit, name) values (1,"21480945441","elmerhomero@123
.com", "sitiene","C", "yomerito", "", "Yo soy Yomerito");
insert into user(id,contact,email,password, profile, username, credit, name) values (2,"21480945441","admin@123.com", "notiene","A", "admin", "", "Yo soy el Admin");
insert into user(id,contact,email,password, profile, username, credit, name) values (3,"21480945444","tu@123.com", "notiene","C", "user2", "",
                                                                                     "Yo soy el user2");




 insert into box (id, food_id, quantity)values(1,1,1);
 insert into box (id, food_id, quantity)values(1,2,1);
 insert into box (id, food_id, quantity)values(1,3,1);
 insert into box (id, food_id, quantity)values(1,4,1);

 insert into box (id, food_id, quantity)values(2,1,1);
 insert into box (id, food_id, quantity)values(2,2,1);


 insert into orden(id,status,box_id,user_id)values(1,"READY", 1,1);
 insert into orden(id,status,box_id,user_id)values(2,"PENDING", 2,1);
insert into orden(id,status,box_id,user_id)values(3,"PENDING", 2,3);