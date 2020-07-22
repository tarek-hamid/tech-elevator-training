-- The following queries utilize the "dvdstore" database.

-- 1. All of the films that Nick Stallone has appeared in
-- (30 rows)
SELECT film.title
FROM film_actor
JOIN film ON film.film_id = film_actor.film_id
JOIN actor ON actor.actor_id = film_actor.actor_id
WHERE actor.first_name = 'NICK' AND actor.last_name = 'STALLONE';


-- 2. All of the films that Rita Reynolds has appeared in
-- (20 rows)
SELECT film.title
FROM film_actor
JOIN film ON film.film_id = film_actor.film_id
JOIN actor ON actor.actor_id = film_actor.actor_id
WHERE actor.first_name = 'RITA' AND actor.last_name = 'REYNOLDS';

-- 3. All of the films that Judy Dean or River Dean have appeared in
-- (46 rows)
SELECT film.title
FROM film_actor
JOIN film ON film.film_id = film_actor.film_id
JOIN actor ON actor.actor_id = film_actor.actor_id
WHERE (actor.first_name = 'RIVER' OR actor.first_name ='JUDY') AND (actor.last_name = 'DEAN');

-- 4. All of the the ‘Documentary’ films
-- (68 rows)
SELECT film.title
FROM film_category
JOIN film ON film.film_id = film_category.film_id
JOIN category ON category.category_id = film_category.category_id
WHERE category.name = 'Documentary';

-- 5. All of the ‘Comedy’ films
-- (58 rows)
SELECT film.title
FROM film_category
JOIN film ON film.film_id = film_category.film_id
JOIN category ON category.category_id = film_category.category_id
WHERE category.name = 'Comedy';

-- 6. All of the ‘Children’ films that are rated ‘G’
-- (10 rows)
SELECT film.title
FROM film_category
JOIN film ON film.film_id = film_category.film_id
JOIN category ON category.category_id = film_category.category_id
WHERE category.name = 'Children' AND film.rating = 'G';

-- 7. All of the ‘Family’ films that are rated ‘G’ and are less than 2 hours in length
-- (3 rows)
SELECT film.title
FROM film_category
JOIN film ON film.film_id = film_category.film_id
JOIN category ON category.category_id = film_category.category_id
WHERE category.name = 'Family' AND film.rating = 'G' AND  film.length < 120;

-- 8. All of the films featuring actor Matthew Leigh that are rated ‘G’
-- (9 rows)
SELECT film.title
FROM film_actor
JOIN film ON film.film_id = film_actor.film_id
JOIN actor ON actor.actor_id = film_actor.actor_id
WHERE actor.first_name = 'MATTHEW' AND actor.last_name = 'LEIGH' AND film.rating = 'G';

-- 9. All of the ‘Sci-Fi’ films released in 2006
-- (61 rows)
SELECT film.title
FROM film_category
JOIN film ON film.film_id = film_category.film_id
JOIN category ON category.category_id = film_category.category_id
WHERE category.name = 'Sci-Fi' AND film.release_year = '2006';

-- 10. All of the ‘Action’ films starring Nick Stallone
-- (2 rows)
SELECT film.title
FROM film
JOIN film_actor ON film.film_id = film_actor.film_id
JOIN film_category ON film.film_id = film_category.film_id
JOIN actor ON film_actor.actor_id = actor.actor_id
JOIN category ON film_category.category_id = category.category_id
WHERE category.name = 'Action' AND actor.first_name = 'NICK' AND actor.last_name = 'STALLONE';


-- 11. The address of all stores, including street address, city, district, and country
-- (2 rows)
SELECT address.address, city.city, address.district, country.country
FROM address
JOIN store ON store.address_id = address.address_id
JOIN city ON address.city_id = city.city_id
JOIN country ON country.country_id = city.country_id;


-- 12. A list of all stores by ID, the store’s street address, and the name of the store’s manager
-- (2 rows)
SELECT address.address_id, address.address, staff.first_name || ' ' || staff.last_name
FROM address
JOIN store ON store.address_id = address.address_id
JOIN staff ON staff.store_id = store.store_id;


-- 13. The first and last name of the top ten customers ranked by number of rentals 
-- (#1 should be “ELEANOR HUNT�? with 46 rentals, #10 should have 39 rentals)
SELECT customer.first_name || ' ' || customer.last_name as customer_name, COUNT(*)
FROM rental
JOIN customer ON customer.customer_id = rental.customer_id
GROUP BY customer.first_name, customer.last_name
ORDER BY COUNT(*) DESC;

-- 14. The first and last name of the top ten customers ranked by dollars spent 
-- (#1 should be “KARL SEAL�? with 221.55 spent, #10 should be “ANA BRADLEY�? with 174.66 spent)
SELECT customer.first_name || ' ' || customer.last_name as customer_name, SUM(payment.amount) as total_payments
FROM payment
JOIN customer ON customer.customer_id = payment.customer_id
GROUP BY customer.first_name, customer.last_name
ORDER BY total_payments DESC;

-- 15. The store ID, street address, total number of rentals, total amount of sales (i.e. payments), and average sale of each store.
-- (NOTE: Keep in mind that an employee may work at multiple stores.)
-- (Store 1 has 7928 total rentals and Store 2 has 8121 total rentals)
SELECT s.store_id, a.address, COUNT(p.rental_id), SUM(p.staff_id)
FROM store as s
JOIN address as a on a.address_id = s.address_id
JOIN inventory as i on i.store_id = s.store_id
JOIN rental as r on  r.inventory_id = i.inventory_id
JOIN payment as p on r.rental_id = p.rental_id
GROUP by s.store_id, a.address;

-- 16. The top ten film titles by number of rentals
-- (#1 should be “BUCKET BROTHERHOOD�? with 34 rentals and #10 should have 31 rentals)
SELECT f.title, COUNT(r.rental_id)
FROM film as f
JOIN inventory as i on i.film_id = f.film_id
JOIN rental as r on r.inventory_id = i.inventory_id
GROUP by f.title
ORDER BY COUNT DESC;

-- 17. The top five film categories by number of rentals 
-- (#1 should be “Sports�? with 1179 rentals and #5 should be “Family�? with 1096 rentals)
SELECT c.name, COUNT(r.rental_id)
FROM category as c
JOIN film_category as fc on fc.category_id = c.category_id
JOIN inventory as i on i.film_id = fc.film_id
JOIN rental as r on r.inventory_id = i.inventory_id
GROUP by c.name
ORDER BY COUNT DESC LIMIT 5;

-- 18. The top five Action film titles by number of rentals 
-- (#1 should have 30 rentals and #5 should have 28 rentals)
SELECT f.title, COUNT(r.rental_id)
FROM category as c
JOIN film_category as fc on fc.category_id = c.category_id
JOIN film as f on f.film_id = fc.film_id
JOIN inventory as i on i.film_id = fc.film_id
JOIN rental as r on r.inventory_id = i.inventory_id
WHERE c.name = 'Action'
GROUP by f.title
ORDER BY COUNT DESC LIMIT 5;

-- 19. The top 10 actors ranked by number of rentals of films starring that actor 
-- (#1 should be “GINA DEGENERES�? with 753 rentals and #10 should be “SEAN GUINESS�? with 599 rentals)
SELECT a.first_name, a.last_name, COUNT(r.rental_id)
FROM category as c
JOIN film_category as fc on fc.category_id = c.category_id
JOIN film as f on f.film_id = fc.film_id
JOIN film_actor as fa on fa.film_id = f.film_id
JOIN actor as a on a.actor_id = fa.actor_id
JOIN inventory as i on i.film_id = fc.film_id
JOIN rental as r on r.inventory_id = i.inventory_id
GROUP by a.actor_id
ORDER BY COUNT DESC LIMIT 10;

-- 20. The top 5 “Comedy�? actors ranked by number of rentals of films in the “Comedy�? category starring that actor 
-- (#1 should have 87 rentals and #5 should have 72 rentals)
SELECT a.first_name, a.last_name, COUNT(r.rental_id)
FROM category as c
JOIN film_category as fc on fc.category_id = c.category_id
JOIN film as f on f.film_id = fc.film_id
JOIN film_actor as fa on fa.film_id = f.film_id
JOIN actor as a on a.actor_id = fa.actor_id
JOIN inventory as i on i.film_id = fc.film_id
JOIN rental as r on r.inventory_id = i.inventory_id
WHERE c.name = 'Comedy'
GROUP by a.actor_id
ORDER BY COUNT DESC LIMIT 5;
