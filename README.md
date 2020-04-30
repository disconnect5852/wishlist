# wishlist
Try this try that to make a simple CRUD like wishlist app, with some admin functions, security, public wishlist linking.
Mixing Spring boot, spring mvc, spring data, spring security, with JSF (primefaces), JSP (should be avoided as it's BAAAD!), H2 db, etc...

Each user has own wishlists, sees own wishlist, except if: generated wishlist public links can be linked to anyone.
Use it with maven, has a prepared database, but you can create new one, by deleting data folder, and uncomment lines in application.properties

in browser: http://localhost:8080/
this will redirect you to http://localhost:8080/login
the default TOP SECRET admin user is: adminbacsi pw: istenvagyok
there is a simple user too: senkike pw: jelszo12345

after login, http://localhost:8080/welcome is loaded, with two links to http://localhost:8080/wishlist and to http://localhost:8080/admin/admin (reachable by users with admin rights ;) )

The UI is not nice, not friendly, but works.
Refresh after DB operation sometimes not works (JSF spiritual world..)

Kipróbáltam ezt, meg azt, tervezés nélkül, improvizatív módon, CRUD szerű kívánságlistás app, néhány admin funkcióval, jogosultságkezeléssel, nyilvánosan linkelhető kívánságlistával.
Össze-Vissza keverve Spring boot, spring mvc, spring data, spring security, JSF, JSP (takarodj!), H2 DB, stb.

Minden felhasználónak lehetnek kívánságlistái, csak a sajátjait látja (kivéve linken megosztott listánál).
Mavennel fordítható, van benne egy előkészített DB pár userrel, pár kívánságlistával, de újra is lehet csinálni, törölve a data mappát, és kikommentelni a megfelelő sorokat az application.properties-ben

böngészőbe: http://localhost:8080/
elirányít ide: http://localhost:8080/login
A beépített TITKOS admin user: adminbacsi pw: istenvagyok (olyan titkos, hogy senki sem tudja ám)
Egyszerű pór user is van: senkike pw: jelszo12345

Bejelentkezés után, http://localhost:8080/welcome irányít, ahol 2 link van http://localhost:8080/wishlist és to http://localhost:8080/admin/admin (csak admin érheti ezt el, ő tud új felhasználót is létrehozni, törölni, jelszót változtatni ;) )

Nem szép a felület, UI design az van ami default, de egyszerű. Néhány gomb/elem, csak a megfelelő kitöltések, kijelölésektől lesz aktív/látható.
DB művelet utáni frissítés nem mindig működik valamiért, JSF lelki világába kellene beleásni, majd egyszer...

Bla bla...