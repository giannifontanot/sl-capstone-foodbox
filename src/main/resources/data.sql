

INSERT INTO food (id, cuisine, description, image_url, is_enabled, food_name, price)values(1, 'MEXICAN', '1 Receta de la abuelita de mole verde', 'tinyurl.com/moleVerdeImage','Y', '1 Mole Verde', 10);
INSERT INTO food (id, cuisine, description, image_url, is_enabled, food_name, price)values(5, 'MEXICAN', '5 Receta de la abuelita de mole verde', 'tinyurl.com/moleVerdeImage','Y', '5 Mole Verde', 50);
INSERT INTO food (id, cuisine, description, image_url, is_enabled, food_name, price)values(2, 'MEXICAN', '2Receta de la abuelita de mole verde', 'tinyurl.com/moleVerdeImage','Y', '2 Mole Verde', 20);
INSERT INTO food (id, cuisine, description, image_url, is_enabled, food_name, price)values(3, 'MEXICAN', '3 Receta de la abuelita de mole verde', 'tinyurl.com/moleVerdeImage','Y', '3 Mole Verde', 30);
INSERT INTO food (id, cuisine, description, image_url, is_enabled, food_name, price)values(4, 'MEXICAN', '4 Receta de la abuelita de mole verde', 'tinyurl.com/moleVerdeImage','Y', '4 Mole Verde', 40);

insert into user(id,contact,email,password,is_admin, username)values(1,"21480945441","elmerhomero@123.com", "notiene","N", "yomerito");




 insert into box (id, food_id)values(1,1);
 insert into box (id, food_id)values(1,2);
 insert into box (id, food_id)values(1,3);
 insert into box (id, food_id)values(1,4);

 insert into box (id, food_id)values(2,1);
 insert into box (id, food_id)values(2,2);


 insert into orden(id,status,box_id,user_id)values(1,"READY", 1,1);
 insert into orden(id,status,box_id,user_id)values(2,"PEND", 2,1);